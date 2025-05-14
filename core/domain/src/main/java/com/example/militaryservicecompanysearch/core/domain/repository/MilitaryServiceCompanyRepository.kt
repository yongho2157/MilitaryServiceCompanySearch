package com.example.militaryservicecompanysearch.core.domain.repository

import androidx.paging.PagingData
import com.example.militartservicecompanysearch.core.model.DataError
import com.example.militartservicecompanysearch.core.model.RecruitmentNotice
import com.example.militartservicecompanysearch.core.model.Result
import kotlinx.coroutines.flow.Flow

interface MilitaryServiceCompanyRepository {
    fun getRecruitmentNoticesByTitle(title: String): Flow<PagingData<RecruitmentNotice>>
    suspend fun getRecruitmentNotices(): Result<List<RecruitmentNotice>, DataError.Network>
    fun getLocalRecruitmentNotices(
        sectors: List<String>,
        militaryServiceTypeCode: Int,
        personnelCode: String,
    ): Flow<PagingData<RecruitmentNotice>>
    fun getBookmarkedRecruitmentNotices(): Flow<List<RecruitmentNotice>>
    suspend fun updateBookmarkStatus(recruitmentNo: String, isBookmarked: Boolean)
}
