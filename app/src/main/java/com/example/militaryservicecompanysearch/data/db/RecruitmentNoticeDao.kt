package com.example.militaryservicecompanysearch.data.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.militaryservicecompanysearch.data.model.RecruitmentNoticeEntity
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice
import kotlinx.coroutines.flow.Flow

@Dao
interface RecruitmentNoticeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecruitmentNotices(recruitmentNotices: List<RecruitmentNoticeEntity>)

    @Query("SELECT * FROM recruitment_notices")
    suspend fun getAllRecruitmentNotices(): List<RecruitmentNoticeEntity>

    @Query("SELECT * FROM recruitment_notices")
    fun getRecruitmentNotices(): PagingSource<Int, RecruitmentNoticeEntity>

    @Query("SELECT * FROM recruitment_notices WHERE recruitment_title LIKE '%' || :title || '%' and sector IN (:sectors)")
    fun getRecruitmentNoticesByTitle(title: String, sectors: List<String>): PagingSource<Int, RecruitmentNoticeEntity>

    @Query("SELECT * FROM recruitment_notices WHERE recruitment_title LIKE '%' || :title || '%'")
    fun getRecruitmentNoticesByTitle(title: String): PagingSource<Int, RecruitmentNoticeEntity>

    @Query("SELECT * FROM recruitment_notices WHERE (:sectors IS NULL OR sector = '') OR sector IN (:sectors)")
    fun getRecruitmentNoticesBySectors(sectors: List<String>): PagingSource<Int, RecruitmentNoticeEntity>

    @Query("SELECT * FROM recruitment_notices WHERE isBookmarked = 1")
    fun getBookmarkedRecruitmentNotices(): Flow<List<RecruitmentNoticeEntity>>

    @Query("UPDATE recruitment_notices SET isBookmarked = :isBookmarked WHERE recruitment_no = :recruitmentNo")
    suspend fun updateBookmarkStatus(recruitmentNo: String, isBookmarked: Boolean)

    @Query("DELETE FROM recruitment_notices")
    suspend fun clearRecruitmentNotices()
}
