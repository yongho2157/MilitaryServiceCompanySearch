package com.example.militaryservicecompanysearch.domain.repository

import androidx.paging.PagingData
import com.example.militaryservicecompanysearch.domain.model.DataError
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice
import com.example.militaryservicecompanysearch.domain.model.Result
import kotlinx.coroutines.flow.Flow

interface MilitaryServiceCompanyRepository {
    fun getRecruitmentNoticesByTitle(title: String, sectors: List<String>): Flow<PagingData<RecruitmentNotice>>
    fun getRecruitmentNoticesBySector(sectors: List<String>): Flow<PagingData<RecruitmentNotice>>
    suspend fun getRecruitmentNotices(): Result<List<RecruitmentNotice>, DataError.Network>
    fun getLocalRecruitmentNotices(): Flow<PagingData<RecruitmentNotice>>
}
