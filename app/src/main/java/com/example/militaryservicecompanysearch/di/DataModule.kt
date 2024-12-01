package com.example.militaryservicecompanysearch.di

import com.example.militaryservicecompanysearch.data.repository.MilitaryServiceCompanyRepositoryImpl
import com.example.militaryservicecompanysearch.data.source.local.MilitaryServiceCompanyLocalDataSource
import com.example.militaryservicecompanysearch.data.source.local.MilitaryServiceCompanyLocalDataSourceImpl
import com.example.militaryservicecompanysearch.data.source.remote.MilitaryServiceCompanyRemoteDataSource
import com.example.militaryservicecompanysearch.data.source.remote.MilitaryServiceCompanyRemoteDataSourceImpl
import com.example.militaryservicecompanysearch.domain.repository.MilitaryServiceCompanyRepository
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
