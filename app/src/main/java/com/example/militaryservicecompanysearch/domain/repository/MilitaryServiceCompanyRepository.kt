package com.example.militaryservicecompanysearch.domain.repository

import androidx.paging.PagingData
import com.example.militaryservicecompanysearch.domain.model.DataError
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice
import com.example.militaryservicecompanysearch.domain.model.Result
import kotlinx.coroutines.flow.Flow

interface MilitaryServiceCompanyRepository {
    suspend fun getRecruitmentNoticesByTitle(title: String): Result<List<RecruitmentNotice>, DataError.Database>
    suspend fun getRecruitmentNotices(sectors: List<String>): Result<List<RecruitmentNotice>, DataError.Network>
    suspend fun getRecruitmentNoticesTest(): Flow<PagingData<RecruitmentNotice>>
}
