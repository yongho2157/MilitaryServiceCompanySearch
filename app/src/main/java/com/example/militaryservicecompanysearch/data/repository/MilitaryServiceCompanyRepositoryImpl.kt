package com.example.militaryservicecompanysearch.data.repository

import android.util.Log
import com.example.militaryservicecompanysearch.data.mapper.RecruitmentNoticeMapper.toListRecruitmentNoticeMapper
import com.example.militaryservicecompanysearch.data.model.Item
import com.example.militaryservicecompanysearch.data.source.remote.MilitaryServiceCompanyDataSource
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice
import com.example.militaryservicecompanysearch.domain.repository.MilitaryServiceCompanyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MilitaryServiceCompanyRepositoryImpl @Inject constructor(private val militaryServiceCompanyDataSource: MilitaryServiceCompanyDataSource) :
    MilitaryServiceCompanyRepository {
    override fun getRecruitmentNotices(): Flow<List<RecruitmentNotice>> = flow {
        Log.d("결과", "getRecruitmentNotices")
        try {
            val items = militaryServiceCompanyDataSource.getRecruitmentNotices().body.items
            Log.d("결과", "items : $items")
            emit(items.item.toListRecruitmentNoticeMapper())
        } catch (e: Exception) {
            Log.d("결과", "e: ${e.message}")
        }
    }
}