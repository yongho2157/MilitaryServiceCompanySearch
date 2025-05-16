package com.example.militaryservicecompanysearch.core.data.source.local

import androidx.paging.PagingSource
import com.example.militaryservicecompanysearch.core.database.model.RecruitmentNoticeEntity
import kotlinx.coroutines.flow.Flow

interface MilitaryServiceCompanyLocalDataSource {

    suspend fun insertRecruitmentNotices(recruitmentNotices: List<RecruitmentNoticeEntity>)

    suspend fun getAllRecruitmentNotices(): List<RecruitmentNoticeEntity>

    fun getPagedRecruitmentNotices(sectors: List<String>, militaryServiceTypeCode: Int, personnelCode: String): PagingSource<Int, RecruitmentNoticeEntity>

    fun getRecruitmentNoticesByTitle(title: String): PagingSource<Int, RecruitmentNoticeEntity>

    fun getBookmarkedRecruitmentNotices(): Flow<List<RecruitmentNoticeEntity>>

    suspend fun getRecruitmentNoticeByRecruitmentNo(recruitmentNo: String): RecruitmentNoticeEntity?

    suspend fun updateBookmarkStatus(recruitmentNo: String, isBookmarked: Boolean)

}
