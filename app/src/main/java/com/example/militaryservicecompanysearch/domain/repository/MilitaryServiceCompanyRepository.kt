package com.example.militaryservicecompanysearch.domain.repository

import com.example.militaryservicecompanysearch.domain.DataError
import com.example.militaryservicecompanysearch.domain.Result
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice
import kotlinx.coroutines.flow.Flow

interface MilitaryServiceCompanyRepository {

    suspend fun getRecruitmentNotices(): Result<List<RecruitmentNotice>, DataError.Network>

}