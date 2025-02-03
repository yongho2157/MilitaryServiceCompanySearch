package com.example.militaryservicecompanysearch.core.data.source.remote

import com.example.militartservicecompanysearch.core.network.model.RecruitmentNoticeResponse


interface MilitaryServiceCompanyRemoteDataSource {
    suspend fun fetchRecruitmentNotices(numOfRows: Int, pageNo: Int): RecruitmentNoticeResponse
}
