package com.example.militaryservicecompanysearch.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.militaryservicecompanysearch.data.model.RecruitmentNoticeEntity
import com.example.militaryservicecompanysearch.data.model.RemoteKeysEntity

@Database(
    entities = [RecruitmentNoticeEntity::class, RemoteKeysEntity::class],
    version = 3,
    exportSchema = false
)
abstract class RecruitmentNoticeDatabase : RoomDatabase() {

    abstract fun recruitmentNoticeDao(): RecruitmentNoticeDao
    abstract fun remoteKeysDao(): RemoteKeysDao
}
