package com.example.militaryservicecompanysearch.core.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.militartservicecompanysearch.core.model.Result
import com.example.militartservicecompanysearch.core.model.DataError
import com.example.militartservicecompanysearch.core.model.RecruitmentNotice
import com.example.militaryservicecompanysearch.core.data.mapper.toDomain
import com.example.militaryservicecompanysearch.core.data.mapper.toEntity
import com.example.militaryservicecompanysearch.core.data.source.local.MilitaryServiceCompanyLocalDataSource
import com.example.militaryservicecompanysearch.core.data.source.remote.MilitaryServiceCompanyRemoteDataSource
import com.example.militaryservicecompanysearch.core.data.source.remote.RecruitmentNoticeRemoteMediator
import com.example.militaryservicecompanysearch.core.domain.repository.MilitaryServiceCompanyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MilitaryServiceCompanyRepositoryImpl @Inject constructor(
    private val militaryServiceCompanyRemoteDataSource: MilitaryServiceCompanyRemoteDataSource,
    private val militaryServiceCompanyLocalDataSource: MilitaryServiceCompanyLocalDataSource,
    private val recruitmentNoticeRemoteMediator: RecruitmentNoticeRemoteMediator
) : MilitaryServiceCompanyRepository {

    override fun getRecruitmentNoticesByTitle(title: String): Flow<PagingData<RecruitmentNotice>> {
        return if (title.isEmpty()) {
            flowOf(PagingData.empty())
        } else {
            Pager(
                config = PagingConfig(
                    pageSize = 10,
                    initialLoadSize = 30
                ),
                pagingSourceFactory = {
                    militaryServiceCompanyLocalDataSource.getRecruitmentNoticesByTitle(title)
                }
            ).flow
                .map { pagingData ->
                    pagingData.toDomain()
                }
        }
    }

    override suspend fun getRecruitmentNotices(): Result<List<RecruitmentNotice>, DataError.Network> {
        return try {
            val recruitmentNotices =
                militaryServiceCompanyLocalDataSource.getAllRecruitmentNotices()
            if (recruitmentNotices.isEmpty()) {
                val countResponse = militaryServiceCompanyRemoteDataSource
                    .fetchRecruitmentNotices(numOfRows = 1, pageNo = 1).body.totalCount

                val dataResponse = militaryServiceCompanyRemoteDataSource
                    .fetchRecruitmentNotices(numOfRows = countResponse, pageNo = 1).body.items.item

                militaryServiceCompanyLocalDataSource.insertRecruitmentNotices(dataResponse.map { it.toEntity() })
                return Result.Success(dataResponse.map { it.toDomain() })
            } else {
                return Result.Success(recruitmentNotices.map { it.toDomain() })
            }
        } catch (e: Exception) {
            return Result.Error(DataError.Network.REQUEST_TIMEOUT)
        }
    }

    @OptIn(ExperimentalPagingApi::class)
    override fun getLocalRecruitmentNotices(
        sectors: List<String>,
        militaryServiceTypeCode: Int,
        personnelCode: String,
    ): Flow<PagingData<RecruitmentNotice>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                initialLoadSize = 30
            ),
            remoteMediator = recruitmentNoticeRemoteMediator,
            pagingSourceFactory = {
                militaryServiceCompanyLocalDataSource.getPagedRecruitmentNotices(
                    sectors = sectors,
                    militaryServiceTypeCode = militaryServiceTypeCode,
                    personnelCode = personnelCode
                )
            }
        ).flow
            .map { pagingData ->
                pagingData.toDomain()
            }
    }

    override fun getBookmarkedRecruitmentNotices(): Flow<List<RecruitmentNotice>> {
        return militaryServiceCompanyLocalDataSource
            .getBookmarkedRecruitmentNotices()
            .map { recruitmentNotices ->
                recruitmentNotices.map { it.toDomain() }
            }
    }

    override suspend fun updateBookmarkStatus(recruitmentNo: String, isBookmarked: Boolean) {
        militaryServiceCompanyLocalDataSource.updateBookmarkStatus(
            recruitmentNo = recruitmentNo,
            isBookmarked = isBookmarked
        )
    }

    override suspend fun getRecruitmentNoticeByRecruitmentNo(recruitmentNo: String): RecruitmentNotice {
        return militaryServiceCompanyLocalDataSource.getRecruitmentNoticeByRecruitmentNo(
            recruitmentNo
        )?.toDomain() ?: error("RecruitmentNotice not found with recruitmentNo: $recruitmentNo")
    }
}
