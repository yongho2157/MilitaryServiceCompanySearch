package com.example.militaryservicecompanysearch.data.source.remote

import com.example.militaryservicecompanysearch.BuildConfig
import com.example.militaryservicecompanysearch.data.model.RecruitmentNoticeResponse
import com.example.militaryservicecompanysearch.data.service.OpenDataService
import javax.inject.Inject

class MilitaryServiceCompanyRemoteDataSourceImpl @Inject constructor(private val openDataService: OpenDataService) :
    MilitaryServiceCompanyRemoteDataSource {
    override suspend fun fetchRecruitmentNotices(pageNo: Int): RecruitmentNoticeResponse =
        openDataService.getRecruitmentNotices(10, pageNo, BuildConfig.SERVICE_KEY)
}
