package com.example.militaryservicecompanysearch.data.source.remote

import com.example.militaryservicecompanysearch.data.model.RecruitmentNoticeResponse

interface MilitaryServiceCompanyDataSource {
    suspend fun getRecruitmentNotices(): RecruitmentNoticeResponse
}