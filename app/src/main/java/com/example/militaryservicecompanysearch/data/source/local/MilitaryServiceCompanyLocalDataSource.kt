package com.example.militaryservicecompanysearch.data.source.local

import androidx.paging.PagingSource
import com.example.militaryservicecompanysearch.data.model.RecruitmentNoticeEntity
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice
import kotlinx.coroutines.flow.Flow

interface MilitaryServiceCompanyLocalDataSource {

    suspend fun insertRecruitmentNotices(recruitmentNotices: List<RecruitmentNoticeEntity>)

    suspend fun getAllRecruitmentNotices(): List<RecruitmentNoticeEntity>

    fun getPagedRecruitmentNotices(sectors: List<String>, militaryServiceTypeCode: Int): PagingSource<Int, RecruitmentNoticeEntity>

    fun getRecruitmentNoticesByTitle(title: String, sectors: List<String>): PagingSource<Int, RecruitmentNoticeEntity>

    fun getBookmarkedRecruitmentNotices(): Flow<List<RecruitmentNoticeEntity>>

    suspend fun updateBookmarkStatus(recruitmentNo: String, isBookmarked: Boolean)

}
