package com.example.militaryservicecompanysearch.core.data.source.remote

import com.example.militartservicecompanysearch.core.network.OpenDataService
import com.example.militartservicecompanysearch.core.network.model.RecruitmentNoticeResponse
import javax.inject.Inject

class MilitaryServiceCompanyRemoteDataSourceImpl @Inject constructor(private val openDataService: OpenDataService) :
    MilitaryServiceCompanyRemoteDataSource {
    override suspend fun fetchRecruitmentNotices(numOfRows: Int, pageNo: Int): RecruitmentNoticeResponse =
        openDataService.getRecruitmentNotices(numOfRows, pageNo)
}
