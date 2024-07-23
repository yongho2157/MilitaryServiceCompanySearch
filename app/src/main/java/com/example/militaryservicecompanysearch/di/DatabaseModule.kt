package com.example.militaryservicecompanysearch.di

import android.app.Application
import androidx.room.Room
import com.example.militaryservicecompanysearch.data.db.RecruitmentNoticeDao
import com.example.militaryservicecompanysearch.data.db.RecruitmentNoticeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        application: Application
    ): RecruitmentNoticeDatabase {
        return Room
            .databaseBuilder(application, RecruitmentNoticeDatabase::class.java, "recruitment_notice.db")
            .build()
    }

    @Provides
    @Singleton
    fun provideRecruitmentNoticeDao(appDatabase: RecruitmentNoticeDatabase): RecruitmentNoticeDao {
        return appDatabase.recruitmentNoticeDao()
    }

}