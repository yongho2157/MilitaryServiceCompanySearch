package com.example.militaryservicecompanysearch.data.source.remote

import com.example.militaryservicecompanysearch.BuildConfig
import com.example.militaryservicecompanysearch.data.model.RecruitmentNoticeResponse
import com.example.militaryservicecompanysearch.data.service.OpenDataService
import javax.inject.Inject

class MilitaryServiceCompanyRemoteDataSourceImpl @Inject constructor(private val openDataService: OpenDataService) :
    MilitaryServiceCompanyRemoteDataSource {
    override suspend fun fetchRecruitmentNotices(): RecruitmentNoticeResponse =
        openDataService.getRecruitmentNotices(10, 1, BuildConfig.SERVICE_KEY)
}