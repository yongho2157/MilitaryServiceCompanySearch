package com.example.militaryservicecompanysearch.core.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.militartservicecompanysearch.core.model.Result
import com.example.militartservicecompanysearch.core.model.DataError
import com.example.militartservicecompanysearch.core.model.RecruitmentNotice
import com.example.militaryservicecompanysearch.core.data.mapper.asDomain
import com.example.militaryservicecompanysearch.core.data.mapper.asEntity
import com.example.militaryservicecompanysearch.core.data.source.local.MilitaryServiceCompanyLocalDataSource
import com.example.militaryservicecompanysearch.core.data.source.remote.MilitaryServiceCompanyRemoteDataSource
import com.example.militaryservicecompanysearch.core.domain.repository.MilitaryServiceCompanyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MilitaryServiceCompanyRepositoryImpl @Inject constructor(
    private val militaryServiceCompanyRemoteDataSource: MilitaryServiceCompanyRemoteDataSource,
    private val militaryServiceCompanyLocalDataSource: MilitaryServiceCompanyLocalDataSource
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
                    pagingData.asDomain()
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

                militaryServiceCompanyLocalDataSource.insertRecruitmentNotices(dataResponse.asEntity())
                return Result.Success(dataResponse)
            } else {
                return Result.Success(recruitmentNotices.asDomain())
            }
        } catch (e: Exception) {
            return Result.Error(DataError.Network.REQUEST_TIMEOUT)
//            when (e.code()) {
//                408 -> Result.Error(DataError.Network.REQUEST_TIMEOUT)
//                else -> Result.Error(DataError.Network.UNKNOWN)
//            }
        }
    }

    override fun getLocalRecruitmentNotices(
        sectors: List<String>,
        militaryServiceTypeCode: Int,
        personnelCode: String,
        pagingConfig: PagingConfig
    ): Flow<PagingData<RecruitmentNotice>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = {
                militaryServiceCompanyLocalDataSource.getPagedRecruitmentNotices(
                    sectors = sectors,
                    militaryServiceTypeCode = militaryServiceTypeCode,
                    personnelCode = personnelCode
                )
            }
        ).flow
            .map { pagingData ->
                pagingData.asDomain()
            }
    }

    override fun getBookmarkedRecruitmentNotices(): Flow<List<RecruitmentNotice>> {
        return militaryServiceCompanyLocalDataSource
            .getBookmarkedRecruitmentNotices()
            .map { recruitmentNotices ->
                recruitmentNotices.asDomain()
            }
    }

    override suspend fun updateBookmarkStatus(recruitmentNo: String, isBookmarked: Boolean) {
        militaryServiceCompanyLocalDataSource.updateBookmarkStatus(
            recruitmentNo = recruitmentNo,
            isBookmarked = isBookmarked
        )
    }
}
