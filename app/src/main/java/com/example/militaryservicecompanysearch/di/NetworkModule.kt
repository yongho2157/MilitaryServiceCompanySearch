package com.example.militaryservicecompanysearch.di

import com.example.militaryservicecompanysearch.data.service.OpenDataService
import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(okhttp: OkHttpClient, tikXml: TikXml): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://apis.data.go.kr/1300000/CyJeongBo/")
            .client(okhttp)
            .addConverterFactory(TikXmlConverterFactory.create(tikXml))
            .build()
    }

    @Provides
    @Singleton
    fun providesOpenDataApi(
        retrofit: Retrofit
    ): OpenDataService = retrofit.create(OpenDataService::class.java)

    /**
     * xml 요소를 전부 가져오지 않기 위해 지정
     */
    @Provides
    @Singleton
    fun provideTikXml(): TikXml {
        return TikXml.Builder()
            .exceptionOnUnreadXml(false)
            .build()
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

}