package com.example.militaryservicecompanysearch.data.source.local

import androidx.paging.PagingSource
import com.example.militaryservicecompanysearch.data.model.RecruitmentNoticeEntity

interface MilitaryServiceCompanyLocalDataSource {

    suspend fun insertRecruitmentNotices(recruitmentNotices: List<RecruitmentNoticeEntity>)

    suspend fun getAllRecruitmentNotices(): List<RecruitmentNoticeEntity>

    fun getPagedRecruitmentNotices(): PagingSource<Int, RecruitmentNoticeEntity>

    fun getRecruitmentNoticesByTitle(title: String, sectors: List<String>): PagingSource<Int, RecruitmentNoticeEntity>

    fun getRecruitmentNoticesBySectors(sectors: List<String>): PagingSource<Int, RecruitmentNoticeEntity>

}
