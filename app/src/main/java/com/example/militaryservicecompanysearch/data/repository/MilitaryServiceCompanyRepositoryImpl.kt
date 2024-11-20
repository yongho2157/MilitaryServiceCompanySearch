package com.example.militaryservicecompanysearch.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.militaryservicecompanysearch.data.mapper.asDomain
import com.example.militaryservicecompanysearch.data.mapper.asEntity
import com.example.militaryservicecompanysearch.data.source.RecruitmentNoticePagingSource
import com.example.militaryservicecompanysearch.data.source.local.MilitaryServiceCompanyLocalDataSource
import com.example.militaryservicecompanysearch.data.source.remote.MilitaryServiceCompanyRemoteDataSource
import com.example.militaryservicecompanysearch.domain.model.DataError
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice
import com.example.militaryservicecompanysearch.domain.model.Result
import com.example.militaryservicecompanysearch.domain.repository.MilitaryServiceCompanyRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import javax.inject.Inject

class MilitaryServiceCompanyRepositoryImpl @Inject constructor(
    private val militaryServiceCompanyRemoteDataSource: MilitaryServiceCompanyRemoteDataSource,
    private val militaryServiceCompanyLocalDataSource: MilitaryServiceCompanyLocalDataSource
) : MilitaryServiceCompanyRepository {
    override suspend fun getRecruitmentNotices(sectors: List<String>): Result<List<RecruitmentNotice>, DataError.Network> {
        return try {
            val recruitmentNotices = militaryServiceCompanyLocalDataSource.getRecruitmentNoticesBySectors(sectors)
            if (recruitmentNotices.isEmpty()) {
                val response = militaryServiceCompanyRemoteDataSource.fetchRecruitmentNotices(pageNo = 1).body.items.item
                militaryServiceCompanyLocalDataSource.insertRecruitmentNotices(response.asEntity())
                return Result.Success(response)
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

    override suspend fun getRecruitmentNoticesTest(): Flow<PagingData<RecruitmentNotice>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10
            ),
            pagingSourceFactory = {
                RecruitmentNoticePagingSource(
                    militaryServiceCompanyRemoteDataSource = militaryServiceCompanyRemoteDataSource
                )
            }
        ).flow
    }

    override suspend fun getRecruitmentNoticesByTitle(title: String): Result<List<RecruitmentNotice>, DataError.Database> {
        return try {
            val recruitmentNotices = militaryServiceCompanyLocalDataSource.getRecruitmentNoticesByTitle(title)
            return Result.Success(recruitmentNotices.asDomain())
        } catch (e: HttpException) {
            when (e.code()) {
                else -> Result.Error(DataError.Database.UNKNOWN)
            }
        }
    }
}
