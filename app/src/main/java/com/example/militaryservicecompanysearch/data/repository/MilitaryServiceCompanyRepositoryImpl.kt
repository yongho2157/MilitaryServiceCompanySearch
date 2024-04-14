package com.example.militaryservicecompanysearch.data.repository

import com.example.militaryservicecompanysearch.data.mapper.RecruitmentNoticeMapper.toListRecruitmentNoticeMapper
import com.example.militaryservicecompanysearch.data.source.remote.MilitaryServiceCompanyDataSource
import com.example.militaryservicecompanysearch.domain.model.DataError
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice
import com.example.militaryservicecompanysearch.domain.model.Result
import com.example.militaryservicecompanysearch.domain.repository.MilitaryServiceCompanyRepository
import retrofit2.HttpException
import javax.inject.Inject

class MilitaryServiceCompanyRepositoryImpl @Inject constructor(private val militaryServiceCompanyDataSource: MilitaryServiceCompanyDataSource) :
    MilitaryServiceCompanyRepository {
    override suspend fun getRecruitmentNotices(): Result<List<RecruitmentNotice>, DataError.Network> {
        return try {
            val items = militaryServiceCompanyDataSource.getRecruitmentNotices().body.items
            Result.Success(items.item.toListRecruitmentNoticeMapper())
        } catch (e: HttpException) {
            when (e.code()) {
                408 -> Result.Error(DataError.Network.REQUEST_TIMEOUT)
                else -> Result.Error(DataError.Network.UNKNOWN)
            }
        }
    }
}