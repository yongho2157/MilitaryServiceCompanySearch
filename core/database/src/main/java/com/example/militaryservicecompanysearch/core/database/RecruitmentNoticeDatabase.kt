package com.example.militaryservicecompanysearch.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.militaryservicecompanysearch.core.database.dao.RecruitmentNoticeDao
import com.example.militaryservicecompanysearch.core.database.dao.RemoteKeysDao
import com.example.militaryservicecompanysearch.core.database.model.RecruitmentNoticeEntity
import com.example.militaryservicecompanysearch.core.database.model.RemoteKeysEntity

@Database(
    entities = [RecruitmentNoticeEntity::class, RemoteKeysEntity::class],
    version = 4,
    exportSchema = false
)
abstract class RecruitmentNoticeDatabase : RoomDatabase() {

    abstract fun recruitmentNoticeDao(): RecruitmentNoticeDao
    abstract fun remoteKeysDao(): RemoteKeysDao
}
