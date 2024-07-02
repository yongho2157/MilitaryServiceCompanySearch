package com.example.militaryservicecompanysearch.domain.model

data class DetailRecruitmentNotice(
    var manager: String, // 담당자
    var managerPhoneNumber: String, // 담당자 연락처
    var companyPhoneNumber: String, // 대표 연락처
    var sectors: String, // 업종 구분명
    var sectorsCode: Int, // 업종 코드
    var careerPeriod: String, // 경력년수
    var careerCategory: String, // 경력구분
    var salary: String, // 급여조건명
    var salaryCode: Int, // 급여조건코드
    var militaryServiceType: String, // 역종분류명
    var militaryServiceTypeCode: Int, // 역종 분류 코드
    var personnel: String, // 요원구분명
    var personnelCode: Int, // 요원구분코드
    var recruitmentCount: String, // 모집인원명
    var workingDays: String, // 근무형태명
    var location: String,
    var welfareBenefits: String,
    var dueDate: String
)
