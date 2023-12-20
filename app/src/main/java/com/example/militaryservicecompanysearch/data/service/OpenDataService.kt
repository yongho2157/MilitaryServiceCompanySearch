package com.example.militaryservicecompanysearch.data.service

import com.example.militaryservicecompanysearch.data.model.RecruitmentNoticeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenDataService {

    @GET("/list")
    fun getRecruitmentNotices(
        @Query("numOfRows") numOfRows: Int,
        @Query("pageNo") pageNo: Int,
        @Query("ServiceKey") serviceKey: String
    ): RecruitmentNoticeResponse

}