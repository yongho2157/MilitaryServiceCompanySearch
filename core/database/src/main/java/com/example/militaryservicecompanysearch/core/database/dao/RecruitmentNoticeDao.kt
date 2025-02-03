package com.example.militaryservicecompanysearch.core.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.militaryservicecompanysearch.core.database.model.RecruitmentNoticeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecruitmentNoticeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecruitmentNotices(recruitmentNotices: List<RecruitmentNoticeEntity>)

    @Query("SELECT * FROM recruitment_notices")
    suspend fun getAllRecruitmentNotices(): List<RecruitmentNoticeEntity>

    @Query("SELECT * FROM recruitment_notices")
    fun getRecruitmentNotices(): PagingSource<Int, RecruitmentNoticeEntity>

    @Query("""
        SELECT * 
        FROM recruitment_notices 
        WHERE sector IN (:sectors) 
            AND military_service_type_code = :militaryServiceTypeCode 
            AND personnel_code = :personnelCode
    """)
    fun getRecruitmentNotices(
        sectors: List<String>,
        militaryServiceTypeCode: Int,
        personnelCode: String
    ): PagingSource<Int, RecruitmentNoticeEntity>

    @Query("SELECT * FROM recruitment_notices WHERE military_service_type_code = :militaryServiceTypeCode")
    fun getRecruitmentNoticesByMilitaryServiceTypeCode(militaryServiceTypeCode: Int): PagingSource<Int, RecruitmentNoticeEntity>

    @Query("SELECT * FROM recruitment_notices WHERE recruitment_title LIKE '%' || :title || '%'")
    fun getRecruitmentNoticesByTitle(title: String): PagingSource<Int, RecruitmentNoticeEntity>

    @Query("SELECT * FROM recruitment_notices WHERE sector IN (:sectors)")
    fun getRecruitmentNoticesBySectors(sectors: List<String>): PagingSource<Int, RecruitmentNoticeEntity>

    @Query("SELECT * FROM recruitment_notices WHERE personnel_code IN (:personnelCode)")
    fun getRecruitmentNoticesByPersonnel(personnelCode: String): PagingSource<Int, RecruitmentNoticeEntity>

    @Query("""
        SELECT * 
        FROM recruitment_notices 
        WHERE sector IN (:sectors) AND personnel_code IN (:personnelCode)
        """)
    fun getRecruitmentNoticesBySectorsAndPersonnel(
        sectors: List<String>,
        personnelCode: String
    ): PagingSource<Int, RecruitmentNoticeEntity>

    @Query("""
        SELECT * 
        FROM recruitment_notices 
        WHERE military_service_type_code = :militaryServiceTypeCode AND personnel_code = :personnelCode
        """)
    fun getRecruitmentNoticesByMilitaryServiceAndPersonnel(
        militaryServiceTypeCode: Int,
        personnelCode: String
    ): PagingSource<Int, RecruitmentNoticeEntity>

    @Query("SELECT * FROM recruitment_notices WHERE isBookmarked = 1")
    fun getBookmarkedRecruitmentNotices(): Flow<List<RecruitmentNoticeEntity>>

    @Query("UPDATE recruitment_notices SET isBookmarked = :isBookmarked WHERE recruitment_no = :recruitmentNo")
    suspend fun updateBookmarkStatus(recruitmentNo: String, isBookmarked: Boolean)

    @Query("DELETE FROM recruitment_notices")
    suspend fun clearRecruitmentNotices()
}
