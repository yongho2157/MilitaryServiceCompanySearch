package com.example.militaryservicecompanysearch.data.source.remote

import com.example.militaryservicecompanysearch.data.model.RecruitmentNoticeResponse

interface MilitaryServiceCompanyRemoteDataSource {
    suspend fun fetchRecruitmentNotices(pageNo: Int): RecruitmentNoticeResponse
}
