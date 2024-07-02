package com.example.militaryservicecompanysearch.data.mapper


import com.example.militaryservicecompanysearch.data.model.Item
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice

object RecruitmentNoticeMapper {

    fun List<Item>.toListRecruitmentNoticeMapper(): List<RecruitmentNotice> = map { it.toRecruitmentNoticeMapper() }
//    fun List<Item>.toListDetailRecruitmentNoticeMapper(): List<DetailRecruitmentNoticeMapper> = map { it.toRecruitmentNoticeMapper() }

    private fun Item.toRecruitmentNoticeMapper(): RecruitmentNotice = RecruitmentNotice(
        companyName = eopcheNm ?: "",
        title = cyjemokNm ?: "",
        jobPosition = ddeopmuNm ?: "",
//        location = geunmujy ?: "",
//        welfareBenefits = bokrihs ?: "",
//        salary = gyjogeonCdNm ?: "",
        dueDate = ("~" + magamDt!!.substring(4, 6) + "/" + magamDt!!.substring(6, 8)) ?: ""
    )

//    private fun Item.toDetailRecruitmentNoticeMapper(): DetailRecruitmentNoticeMapper = DetailRecruitmentNoticeMapper(
//        companyName = eopcheNm ?: "",
//        title = cyjemokNm ?: "",
//        jobPosition = ddeopmuNm ?: "",
////        location = geunmujy ?: "",
////        welfareBenefits = bokrihs ?: "",
////        salary = gyjogeonCdNm ?: "",
//        dueDate = ("~" + magamDt!!.substring(4, 6) + "/" + magamDt!!.substring(6, 8)) ?: ""
//    )

}