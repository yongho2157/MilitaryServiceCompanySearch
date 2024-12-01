package com.example.militaryservicecompanysearch.data.source.local

import androidx.paging.PagingSource
import com.example.militaryservicecompanysearch.data.db.RecruitmentNoticeDao
import com.example.militaryservicecompanysearch.data.model.RecruitmentNoticeEntity
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

}
