package com.example.militaryservicecompanysearch.domain.repository

import com.example.militaryservicecompanysearch.domain.model.DataError
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice
import com.example.militaryservicecompanysearch.domain.model.Result

interface MilitaryServiceCompanyRepository {

    suspend fun getRecruitmentNotices(): Result<List<RecruitmentNotice>, DataError.Network>

}