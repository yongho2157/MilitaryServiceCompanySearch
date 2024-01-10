package com.example.militaryservicecompanysearch.domain.repository

import com.example.militaryservicecompanysearch.data.model.Item
import kotlinx.coroutines.flow.Flow

interface MilitaryServiceCompanyRepository {

    suspend fun getRecruitmentNotices(): Flow<List<Item>>

}