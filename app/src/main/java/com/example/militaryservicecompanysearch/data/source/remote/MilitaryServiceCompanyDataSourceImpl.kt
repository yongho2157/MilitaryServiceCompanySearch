package com.example.militaryservicecompanysearch.data.source.remote

import com.example.militaryservicecompanysearch.BuildConfig
import com.example.militaryservicecompanysearch.data.model.RecruitmentNoticeResponse
import com.example.militaryservicecompanysearch.data.service.OpenDataService
import javax.inject.Inject

class MilitaryServiceCompanyDataSourceImpl @Inject constructor(private val openDataService: OpenDataService) :
    MilitaryServiceCompanyDataSource {
    override fun getRecruitmentNotices(): RecruitmentNoticeResponse =
        openDataService.getRecruitmentNotices(10, 1, BuildConfig.SERVICE_KEY)
}