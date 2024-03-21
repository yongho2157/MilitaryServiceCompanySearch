package com.example.militaryservicecompanysearch.data.source.remote

import com.example.militaryservicecompanysearch.data.model.RecruitmentNoticeResponse
import com.example.militaryservicecompanysearch.data.service.OpenDataService
import javax.inject.Inject

class MilitaryServiceCompanyDataSourceImpl @Inject constructor(private val openDataService: OpenDataService) :
    MilitaryServiceCompanyDataSource {
    override suspend fun getRecruitmentNotices(): RecruitmentNoticeResponse =
        openDataService.getRecruitmentNotices(10, 1, "chwWtHCYOfeDkzdyZjevIvr8atKjgeAzRCsagSjmgzlsWaOIryjxqHQTnDnr84uQNrwqgpaLGF6P++17dArbKg==")
}