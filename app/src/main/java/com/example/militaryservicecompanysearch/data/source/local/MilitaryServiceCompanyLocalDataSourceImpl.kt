package com.example.militaryservicecompanysearch.data.source.local

import androidx.paging.PagingSource
import com.example.militaryservicecompanysearch.data.db.RecruitmentNoticeDao
import com.example.militaryservicecompanysearch.data.model.RecruitmentNoticeEntity
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice
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

    override fun getPagedRecruitmentNotices(): PagingSource<Int, RecruitmentNoticeEntity> {
        return recruitmentNoticeDao.getRecruitmentNotices()
    }

    override fun getRecruitmentNoticesByTitle(title: String, sectors: List<String>): PagingSource<Int, RecruitmentNoticeEntity> {
        return if (sectors.isEmpty()) {
            recruitmentNoticeDao.getRecruitmentNoticesByTitle(title)
        } else {
            recruitmentNoticeDao.getRecruitmentNoticesByTitle(title, sectors)
        }
    }

    override fun getRecruitmentNoticesBySectors(sectors: List<String>): PagingSource<Int, RecruitmentNoticeEntity> {
        return if (sectors.isEmpty()) {
            recruitmentNoticeDao.getRecruitmentNotices()
        } else {
            recruitmentNoticeDao.getRecruitmentNoticesBySectors(sectors)
        }
    }

    override fun getBookmarkedRecruitmentNotices(): Flow<List<RecruitmentNoticeEntity>> {
        return recruitmentNoticeDao.getBookmarkedRecruitmentNotices()
    }

    override suspend fun updateBookmarkStatus(recruitmentNo: String, isBookmarked: Boolean) {
        recruitmentNoticeDao.updateBookmarkStatus(recruitmentNo = recruitmentNo, isBookmarked = isBookmarked)
    }

}
