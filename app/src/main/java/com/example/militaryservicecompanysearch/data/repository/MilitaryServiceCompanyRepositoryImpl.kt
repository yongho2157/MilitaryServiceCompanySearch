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
                val response = militaryServiceCompanyRemoteDataSource.fetchRecruitmentNotices().body.items.item
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
}