package com.example.militaryservicecompanysearch.data.service

import com.example.militaryservicecompanysearch.BuildConfig
import com.example.militaryservicecompanysearch.data.model.RecruitmentNoticeResponse
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
