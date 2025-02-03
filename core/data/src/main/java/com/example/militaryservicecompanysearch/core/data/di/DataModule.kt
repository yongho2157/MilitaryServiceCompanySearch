package com.example.militaryservicecompanysearch.core.data.di

import com.example.militaryservicecompanysearch.core.data.repository.MilitaryServiceCompanyRepositoryImpl
import com.example.militaryservicecompanysearch.core.data.source.local.MilitaryServiceCompanyLocalDataSource
import com.example.militaryservicecompanysearch.core.data.source.local.MilitaryServiceCompanyLocalDataSourceImpl
import com.example.militaryservicecompanysearch.core.data.source.remote.MilitaryServiceCompanyRemoteDataSource
import com.example.militaryservicecompanysearch.core.data.source.remote.MilitaryServiceCompanyRemoteDataSourceImpl
import com.example.militaryservicecompanysearch.core.domain.repository.MilitaryServiceCompanyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindMilitaryServiceCompanyRemoteDataSource(
        militaryServiceCompanyRemoteDataSourceImpl: MilitaryServiceCompanyRemoteDataSourceImpl
    ): MilitaryServiceCompanyRemoteDataSource

    @Binds
    fun bindMilitaryServiceCompanyLocalDataSource(
        militaryServiceCompanyLocalDataSourceImpl: MilitaryServiceCompanyLocalDataSourceImpl
    ): MilitaryServiceCompanyLocalDataSource

    @Binds
    fun bindMilitaryServiceCompanyRepository(
        militaryServiceCompanyRepositoryImpl: MilitaryServiceCompanyRepositoryImpl
    ): MilitaryServiceCompanyRepository

}
