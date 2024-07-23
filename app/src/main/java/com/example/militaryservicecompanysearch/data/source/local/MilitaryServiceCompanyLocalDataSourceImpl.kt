package com.example.militaryservicecompanysearch.data.source.local

import com.example.militaryservicecompanysearch.data.db.RecruitmentNoticeDao
import com.example.militaryservicecompanysearch.data.model.RecruitmentNoticeEntity
import javax.inject.Inject

class MilitaryServiceCompanyLocalDataSourceImpl @Inject constructor(
    private val recruitmentNoticeDao: RecruitmentNoticeDao
) : MilitaryServiceCompanyLocalDataSource {

    override suspend fun insertRecruitmentNotices(recruitmentNotices: List<RecruitmentNoticeEntity>) {
        recruitmentNoticeDao.insertRecruitmentNotices(recruitmentNotices)
    }

    override suspend fun getRecruitmentNotices(): List<RecruitmentNoticeEntity> {
        return recruitmentNoticeDao.getRecruitmentNotices()
    }

}