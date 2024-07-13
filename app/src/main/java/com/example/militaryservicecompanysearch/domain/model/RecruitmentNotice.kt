package com.example.militaryservicecompanysearch.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecruitmentNotice(
    val recruitmentTitle: String, // 채용 제목
    val companyName: String, // 회사명
    val location: String, // 근무지시도
    val careerPeriod: String, // 경력년수
    val careerCategory: String, // 경력구분
    val sector: String, // 업종
    val manager: String, // 담당자
    val managerPhoneNumber: String, // 담당자 연락처
    val companyPhoneNumber: String, // 대표 연락처
    val companyAddress: String, // 회사 주소
    val homePageLink: String, // 홈페이지 링크
    val personnel: String, // 고용형태
    val militaryServiceType: String, // 요원형태
    val recruitmentCount: String, // 모집인원
    val highestEducation: String, // 최종학력
    val workingDays: String, // 근무형태
    val jobPosition: String, // 담당업무
    val salary: String, // 급여조건명
    val welfareBenefits: String, // 복리후생
    val dueDate: String, // 마감일
): Parcelable
