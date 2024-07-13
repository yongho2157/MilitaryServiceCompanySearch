package com.example.militaryservicecompanysearch.data.mapper


import com.example.militaryservicecompanysearch.data.model.Item
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice

object RecruitmentNoticeMapper {

    fun List<Item>.toListRecruitmentNoticeMapper(): List<RecruitmentNotice> = map { it.toRecruitmentNoticeMapper() }

    private fun Item.toRecruitmentNoticeMapper(): RecruitmentNotice = RecruitmentNotice(
        recruitmentTitle = cyjemokNm ?: "",
        companyName = eopcheNm ?: "",
        location = geunmujysido ?: "",
        careerPeriod = grNs ?: "",
        careerCategory = gyeongryeokGbcdNm ?: "",
        sector = eopjongGbcdNm ?: "",
        manager = damdangjaFnm ?: "",
        managerPhoneNumber = ddjyeonrakcheoNo ?: "",
        companyPhoneNumber = dpyeonrakcheoNo ?: "",
        companyAddress = geunmujy ?: "",
        homePageLink = hmpgAddr ?: "",
        personnel = yeokjongBrcdNm ?: "",
        militaryServiceType = yowonGbcdNm ?: "",
        recruitmentCount = mjinwonNm ?: "",
        highestEducation = cjhakryeok ?: "",
        workingDays = gmhyeongtaeNm ?: "",
        jobPosition = ddeopmuNm ?: "",
        salary = gyjogeonCdNm ?: "",
        welfareBenefits = bokrihs ?: "",
        dueDate = ("~" + magamDt!!.substring(4, 6) + "/" + magamDt!!.substring(6, 8)) ?: ""
    )


}