package com.example.militaryservicecompanysearch.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.militaryservicecompanysearch.data.model.RecruitmentNoticeEntity

@Database(
    entities = [RecruitmentNoticeEntity::class],
    version = 1,
    exportSchema = false
)
abstract class RecruitmentNoticeDatabase : RoomDatabase() {

    abstract fun recruitmentNoticeDao(): RecruitmentNoticeDao
}
