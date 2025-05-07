package com.example.militartservicecompanysearch.core.model

data class RecruitmentNotice(
    val welfareBenefits: String?, // 복리후생
    val registrationDate: String, // 최초발생일
    val lastModifiedDate: String, // 최종변동일
    val highestEducation: String, // 최종학력
    val recruitmentNo: String, // 채용번호
    val recruitmentTitle: String, // 채용제목
    val manager: String, // 담당자
    val jobPosition: String, // 담당업무
    val managerPhoneNumber: String?, // 담당자연락처
    val companyPhoneNumber: String, // 대표연락처
    val companyName: String, // 업체명
    val sectorCode: String, // 업종구분코드
    val sector: String, // 업종구분명
    val companyAddress: String, // 근무지주소
    val location: String, // 근무지시도
    val workingDays: String, // 근무일
    val locationCode: String, // 근무지법정동코드
    val careerPeriod: String?, // 경력년수
    val careerCategory: String, // 경력구분
    val salaryCode: String, // 급여 조건 코드
    val salary: String, // 급여 조건명
    val homePageLink: String?, // 회사 사이트
    val submissionMethod: String?, // 접수방법
    val companyAddressCode: String,
    val dueDate: String, // 마감일자
    val recruitmentCount: String, // 모집 인원
    val saeopjaDrno: String, // 사업자번호
    val personnelCode: String, // 역종분류코드
    val personnel: String, // 역종 분류명
    val militaryServiceTypeCode: String, // 요원 구분 코드
    val militaryServiceType: String, // 요원 구분명
    val validFlag: String, // 유효 여부
    val isBookmarked: Boolean = false
)
