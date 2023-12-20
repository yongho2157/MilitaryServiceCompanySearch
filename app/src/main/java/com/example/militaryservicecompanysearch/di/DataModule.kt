package com.example.militaryservicecompanysearch.di

import com.example.militaryservicecompanysearch.data.repository.MilitaryServiceCompanyRepositoryImpl
import com.example.militaryservicecompanysearch.data.source.remote.MilitaryServiceCompanyDataSource
import com.example.militaryservicecompanysearch.data.source.remote.MilitaryServiceCompanyDataSourceImpl
import com.example.militaryservicecompanysearch.domain.repository.MilitaryServiceCompanyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindMilitaryServiceCompanyDataSource(
        militaryServiceCompanyDataSourceImpl: MilitaryServiceCompanyDataSourceImpl
    ): MilitaryServiceCompanyDataSource

    @Binds
    fun bindMilitaryServiceCompanyRepository(
        militaryServiceCompanyRepositoryImpl: MilitaryServiceCompanyRepositoryImpl
    ): MilitaryServiceCompanyRepository

}