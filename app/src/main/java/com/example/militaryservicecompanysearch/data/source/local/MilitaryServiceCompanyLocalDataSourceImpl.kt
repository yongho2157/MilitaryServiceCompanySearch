package com.example.militaryservicecompanysearch.data.source.local

import androidx.paging.PagingSource
import com.example.militaryservicecompanysearch.data.db.RecruitmentNoticeDao
import com.example.militaryservicecompanysearch.data.model.RecruitmentNoticeEntity
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

    override fun getPagedRecruitmentNotices(sectors: List<String>, militaryServiceTypeCode: Int): PagingSource<Int, RecruitmentNoticeEntity> {
        return if (sectors.isEmpty() && militaryServiceTypeCode == 0) {
            recruitmentNoticeDao.getRecruitmentNotices()
        } else if (sectors.isNotEmpty() && militaryServiceTypeCode != 0) {
            recruitmentNoticeDao.getRecruitmentNotices(sectors, militaryServiceTypeCode)
        } else if (sectors.isNotEmpty()) {
            recruitmentNoticeDao.getRecruitmentNoticesBySectors(sectors)
        } else {
            recruitmentNoticeDao.getRecruitmentNoticesByMilitaryServiceTypeCode(militaryServiceTypeCode)
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
