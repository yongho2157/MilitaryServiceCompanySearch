package com.example.militaryservicecompanysearch.domain.repository

import com.example.militaryservicecompanysearch.data.model.Item
import kotlinx.coroutines.flow.Flow

interface MilitaryServiceCompanyRepository {

    fun getRecruitmentNotices(): Flow<List<Item>>

}