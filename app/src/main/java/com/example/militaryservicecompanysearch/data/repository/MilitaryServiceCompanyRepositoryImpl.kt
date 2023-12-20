package com.example.militaryservicecompanysearch.data.repository

import com.example.militaryservicecompanysearch.data.source.remote.MilitaryServiceCompanyDataSource
import com.example.militaryservicecompanysearch.domain.model.Item
import com.example.militaryservicecompanysearch.domain.repository.MilitaryServiceCompanyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MilitaryServiceCompanyRepositoryImpl @Inject constructor(private val militaryServiceCompanyDataSource: MilitaryServiceCompanyDataSource) :
    MilitaryServiceCompanyRepository {
    override suspend fun getRecruitmentNotices(): Flow<List<Item>> = flow {
        val items = militaryServiceCompanyDataSource.getRecruitmentNotices().body.items
        emit(items.item)
    }
}