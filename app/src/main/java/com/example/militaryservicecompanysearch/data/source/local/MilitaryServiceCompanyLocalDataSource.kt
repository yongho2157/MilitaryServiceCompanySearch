package com.example.militaryservicecompanysearch.data.source.local

import com.example.militaryservicecompanysearch.data.model.RecruitmentNoticeEntity

interface MilitaryServiceCompanyLocalDataSource {

    suspend fun insertRecruitmentNotices(recruitmentNotices: List<RecruitmentNoticeEntity>)

    suspend fun getRecruitmentNotices(): List<RecruitmentNoticeEntity>

}