package com.example.militaryservicecompanysearch.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recruitment_notices")
data class RecruitmentNoticeEntity(
    @ColumnInfo(name = "welfare_benefits")
    val welfareBenefits: String, // 복리후생
    @ColumnInfo(name = "registration_date")
    val registrationDate: String, // 최초발생일
    @ColumnInfo(name = "lastModified_date")
    val lastModifiedDate: String, // 최종변동일
    @ColumnInfo(name = "highest_education")
    val highestEducation: String, // 최종학력
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "recruitment_no")
    val recruitmentNo: String, // 채용번호
    @ColumnInfo(name = "recruitment_title")
    val recruitmentTitle: String, // 채용제목
    @ColumnInfo(name = "manager")
    val manager: String, // 담당자
    @ColumnInfo(name = "job_position")
    val jobPosition: String, // 담당업무
    @ColumnInfo(name = "manager_phone_number")
    val managerPhoneNumber: String, // 담당자연락처
    @ColumnInfo(name = "company_phone_number")
    val companyPhoneNumber: String, // 대표연락처
    @ColumnInfo(name = "company_name")
    val companyName: String, // 업체명
    @ColumnInfo(name = "sector_code")
    val sectorCode: String, // 업종구분코드
    @ColumnInfo(name = "sector")
    val sector: String, // 업종구분명
    @ColumnInfo(name = "company_address")
    val companyAddress: String, // 근무지주소
    @ColumnInfo(name = "location")
    val location: String, // 근무지시도
    @ColumnInfo(name = "working_days")
    val workingDays: String, // 근무일
    @ColumnInfo(name = "location_code")
    val locationCode: String, // 근무지법정동코드
    @ColumnInfo(name = "career_period")
    val careerPeriod: String, // 경력년수
    @ColumnInfo(name = "career_category")
    val careerCategory: String, // 경력구분
    @ColumnInfo(name = "salary_code")
    val salaryCode: String, // 급여 조건 코드
    @ColumnInfo(name = "salary")
    val salary: String, // 급여 조건명
    @ColumnInfo(name = "home_page_link")
    val homePageLink: String, // 회사 사이트
    @ColumnInfo(name = "submission_method")
    val submissionMethod: String, // 접수방법
    @ColumnInfo(name = "company_address_code")
    val companyAddressCode: String,
    @ColumnInfo(name = "due_date")
    val dueDate: String, // 마감일자
    @ColumnInfo(name = "recruitment_count")
    val recruitmentCount: String, // 모집 인원
    @ColumnInfo(name = "saeopjaDrno")
    val saeopjaDrno: String,
    @ColumnInfo(name = "personnel_code")
    val personnelCode: String, // 역종분류코드
    @ColumnInfo(name = "personnel")
    val personnel: String, // 역종 분류명
    @ColumnInfo(name = "military_service_type_code")
    val militaryServiceTypeCode: String, // 요원 구분 코드
    @ColumnInfo(name = "military_service_type")
    val militaryServiceType: String, // 요원 구분명
    @ColumnInfo(name = "valid_flag")
    val validFlag: String // 유효 여부
)