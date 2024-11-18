package com.example.militaryservicecompanysearch.data.repository

import android.util.Log
import com.example.militaryservicecompanysearch.data.mapper.asDomain
import com.example.militaryservicecompanysearch.data.mapper.asEntity
import com.example.militaryservicecompanysearch.data.source.local.MilitaryServiceCompanyLocalDataSource
import com.example.militaryservicecompanysearch.data.source.remote.MilitaryServiceCompanyRemoteDataSource
import com.example.militaryservicecompanysearch.domain.model.DataError
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice
import com.example.militaryservicecompanysearch.domain.model.Result
import com.example.militaryservicecompanysearch.domain.repository.MilitaryServiceCompanyRepository
import retrofit2.HttpException
import javax.inject.Inject

class MilitaryServiceCompanyRepositoryImpl @Inject constructor(
    private val militaryServiceCompanyRemoteDataSource: MilitaryServiceCompanyRemoteDataSource,
    private val militaryServiceCompanyLocalDataSource: MilitaryServiceCompanyLocalDataSource
) : MilitaryServiceCompanyRepository {
    override suspend fun getRecruitmentNotices(): Result<List<RecruitmentNotice>, DataError.Network> {
        return try {
            val recruitmentNotices = militaryServiceCompanyLocalDataSource.getRecruitmentNotices()
            if (recruitmentNotices.isEmpty()) {
                Log.d("결과", "api 요청")
                val response = militaryServiceCompanyRemoteDataSource.fetchRecruitmentNotices().body.items.item
                militaryServiceCompanyLocalDataSource.insertRecruitmentNotices(response.asEntity())
                return Result.Success(response)
            } else {
                Log.d("결과", "db 요청")
                return Result.Success(recruitmentNotices.asDomain())
            }
        } catch (e: HttpException) {
            when (e.code()) {
                408 -> Result.Error(DataError.Network.REQUEST_TIMEOUT)
                else -> Result.Error(DataError.Network.UNKNOWN)
            }
        }
    }

    override suspend fun getRecruitmentNoticesByTitle(title: String): Result<List<RecruitmentNotice>, DataError.Database> {
        return try {
            val recruitmentNotices = militaryServiceCompanyLocalDataSource.getRecruitmentNoticesByTitle(title)
            Log.d("결과", "repo - data : $recruitmentNotices, title: $title")
            return Result.Success(recruitmentNotices.asDomain())
        } catch (e: HttpException) {
            when (e.code()) {
                else -> Result.Error(DataError.Database.UNKNOWN)
            }
        }
    }

    override suspend fun getRecruitmentNoticesBySectors(sectors: List<String>): Result<List<RecruitmentNotice>, DataError.Database> {
        return try {
            val recruitmentNotices = militaryServiceCompanyLocalDataSource.getRecruitmentNoticesBySectors(sectors)
            Log.d("결과", "repo - data : $recruitmentNotices, title: $sectors")
            return Result.Success(recruitmentNotices.asDomain())
        } catch (e: HttpException) {
            when (e.code()) {
                else -> Result.Error(DataError.Database.UNKNOWN)
            }
        }
    }
}
