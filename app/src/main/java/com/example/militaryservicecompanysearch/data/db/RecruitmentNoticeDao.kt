package com.example.militaryservicecompanysearch.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.militaryservicecompanysearch.data.model.RecruitmentNoticeEntity

@Dao
interface RecruitmentNoticeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecruitmentNotices(recruitmentNotices: List<RecruitmentNoticeEntity>)

    @Query("SELECT * FROM recruitment_notices")
    suspend fun getRecruitmentNotices(): List<RecruitmentNoticeEntity>

    @Query("SELECT * FROM recruitment_notices WHERE recruitment_title LIKE '%' || :title || '%'")
    suspend fun getRecruitmentNoticesByTitle(title: String): List<RecruitmentNoticeEntity>

    @Query("SELECT * FROM recruitment_notices WHERE sector IN (:sectors)")
    suspend fun getRecruitmentNoticesBySectors(sectors: List<String>): List<RecruitmentNoticeEntity>
}
