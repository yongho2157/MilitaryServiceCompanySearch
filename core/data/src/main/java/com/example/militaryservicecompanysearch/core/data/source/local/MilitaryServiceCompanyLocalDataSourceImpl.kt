package com.example.militaryservicecompanysearch.core.data.source.local

import androidx.paging.PagingSource
import com.example.militaryservicecompanysearch.core.data.source.local.helper.RecruitmentFilterHelper.isAllFiltersPresent
import com.example.militaryservicecompanysearch.core.data.source.local.helper.RecruitmentFilterHelper.isMilitaryServiceAndPersonnel
import com.example.militaryservicecompanysearch.core.data.source.local.helper.RecruitmentFilterHelper.isMilitaryServiceOnly
import com.example.militaryservicecompanysearch.core.data.source.local.helper.RecruitmentFilterHelper.isNoFilter
import com.example.militaryservicecompanysearch.core.data.source.local.helper.RecruitmentFilterHelper.isPersonnelOnly
import com.example.militaryservicecompanysearch.core.data.source.local.helper.RecruitmentFilterHelper.isSectorsAndPersonnel
import com.example.militaryservicecompanysearch.core.data.source.local.helper.RecruitmentFilterHelper.isSectorsOnly
import com.example.militaryservicecompanysearch.core.database.dao.RecruitmentNoticeDao
import com.example.militaryservicecompanysearch.core.database.model.RecruitmentNoticeEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MilitaryServiceCompanyLocalDataSourceImpl @Inject constructor(
    private val recruitmentNoticeDao: RecruitmentNoticeDao
) : MilitaryServiceCompanyLocalDataSource {

    override suspend fun insertRecruitmentNotices(recruitmentNotices: List<RecruitmentNoticeEntity>) {
        recruitmentNoticeDao.insertRecruitmentNotices(recruitmentNotices)
    }

    override suspend fun getAllRecruitmentNotices(): List<RecruitmentNoticeEntity> {
        return recruitmentNoticeDao.getAllRecruitmentNotices()
    }

    override fun getPagedRecruitmentNotices(
        sectors: List<String>,
        militaryServiceTypeCode: Int,
        personnelCode: String
    ): PagingSource<Int, RecruitmentNoticeEntity> {

        return when {
            isNoFilter(
                sectors = sectors,
                militaryServiceTypeCode = militaryServiceTypeCode,
                personnelCode = personnelCode
            ) -> {
                recruitmentNoticeDao.getRecruitmentNotices()
            }

            isAllFiltersPresent(sectors, militaryServiceTypeCode, personnelCode) -> {
                recruitmentNoticeDao.getRecruitmentNotices(sectors, militaryServiceTypeCode, personnelCode)
            }

            isSectorsAndPersonnel(sectors, personnelCode) -> {
                recruitmentNoticeDao.getRecruitmentNoticesBySectorsAndPersonnel(sectors, personnelCode)
            }

            isMilitaryServiceAndPersonnel(militaryServiceTypeCode, personnelCode) -> {
                recruitmentNoticeDao.getRecruitmentNoticesByMilitaryServiceAndPersonnel(
                    militaryServiceTypeCode,
                    personnelCode
                )
            }

            isSectorsOnly(sectors) -> {
                recruitmentNoticeDao.getRecruitmentNoticesBySectors(sectors)
            }

            isMilitaryServiceOnly(militaryServiceTypeCode) -> {
                recruitmentNoticeDao.getRecruitmentNoticesByMilitaryServiceTypeCode(militaryServiceTypeCode)
            }

            isPersonnelOnly(personnelCode) -> {
                recruitmentNoticeDao.getRecruitmentNoticesByPersonnel(personnelCode)
            }

            else -> recruitmentNoticeDao.getRecruitmentNotices()

        }
    }

    override fun getRecruitmentNoticesByTitle(title: String): PagingSource<Int, RecruitmentNoticeEntity> {
        return recruitmentNoticeDao.getRecruitmentNoticesByTitle(title)
    }

    override fun getBookmarkedRecruitmentNotices(): Flow<List<RecruitmentNoticeEntity>> {
        return recruitmentNoticeDao.getBookmarkedRecruitmentNotices()
    }

    override suspend fun updateBookmarkStatus(recruitmentNo: String, isBookmarked: Boolean) {
        recruitmentNoticeDao.updateBookmarkStatus(recruitmentNo = recruitmentNo, isBookmarked = isBookmarked)
    }

}
