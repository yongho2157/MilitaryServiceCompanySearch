package com.example.militaryservicecompanysearch.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.example.militaryservicecompanysearch.data.mapper.asDomain
import com.example.militaryservicecompanysearch.data.mapper.asEntity
import com.example.militaryservicecompanysearch.data.source.local.MilitaryServiceCompanyLocalDataSource
import com.example.militaryservicecompanysearch.data.source.remote.MilitaryServiceCompanyRemoteDataSource
import com.example.militaryservicecompanysearch.domain.model.DataError
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice
import com.example.militaryservicecompanysearch.domain.model.Result
import com.example.militaryservicecompanysearch.domain.repository.MilitaryServiceCompanyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import retrofit2.HttpException
import javax.inject.Inject

class MilitaryServiceCompanyRepositoryImpl @Inject constructor(
    private val militaryServiceCompanyRemoteDataSource: MilitaryServiceCompanyRemoteDataSource,
    private val militaryServiceCompanyLocalDataSource: MilitaryServiceCompanyLocalDataSource
) : MilitaryServiceCompanyRepository {

    override fun getRecruitmentNoticesByTitle(title: String, sectors: List<String>): Flow<PagingData<RecruitmentNotice>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                initialLoadSize = 30
            ),
            pagingSourceFactory = {
                if (title.isEmpty()) {
                    militaryServiceCompanyLocalDataSource.getPagedRecruitmentNotices()
                } else {
                    militaryServiceCompanyLocalDataSource.getRecruitmentNoticesByTitle(title, sectors)
                }
            }
        ).flow
            .map { pagingData ->
                pagingData.map { recruitmentNoticeEntity ->
                    recruitmentNoticeEntity.asDomain()
                }
            }
    }

    override fun getRecruitmentNoticesBySector(sectors: List<String>): Flow<PagingData<RecruitmentNotice>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                initialLoadSize = 30
            ),
            pagingSourceFactory = {
                militaryServiceCompanyLocalDataSource.getRecruitmentNoticesBySectors(sectors)
            }
        ).flow
            .map { pagingData ->
                pagingData.map { recruitmentNoticeEntity ->
                    recruitmentNoticeEntity.asDomain()
                }
            }
    }

    override suspend fun getRecruitmentNotices(): Result<List<RecruitmentNotice>, DataError.Network> {
        return try {
            val recruitmentNotices = militaryServiceCompanyLocalDataSource.getAllRecruitmentNotices()
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
        } catch (e: HttpException) {
            when (e.code()) {
                408 -> Result.Error(DataError.Network.REQUEST_TIMEOUT)
                else -> Result.Error(DataError.Network.UNKNOWN)
            }
        }
    }

    override fun getLocalRecruitmentNotices(): Flow<PagingData<RecruitmentNotice>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                initialLoadSize = 30
            ),
            pagingSourceFactory = { militaryServiceCompanyLocalDataSource.getPagedRecruitmentNotices() }
        ).flow
            .map { pagingData ->
                pagingData.map { recruitmentNoticeEntity ->
                    recruitmentNoticeEntity.asDomain()
                }
            }
    }

}
