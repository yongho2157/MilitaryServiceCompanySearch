package com.example.militaryservicecompanysearch.domain.repository

import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice
import kotlinx.coroutines.flow.Flow

interface MilitaryServiceCompanyRepository {

    fun getRecruitmentNotices(): Flow<List<RecruitmentNotice>>

}