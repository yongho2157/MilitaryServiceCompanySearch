package com.example.militartservicecompanysearch.core.network

import com.example.militartservicecompanysearch.core.network.model.RecruitmentNoticeResponse
import com.example.militaryservicecompanysearch.core.network.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenDataService {
    @GET("list")
    suspend fun getRecruitmentNotices(
        @Query("numOfRows") numOfRows: Int = 20,
        @Query("pageNo") pageNo: Int,
        @Query("ServiceKey") serviceKey: String = BuildConfig.SERVICE_KEY
    ): RecruitmentNoticeResponse
}
