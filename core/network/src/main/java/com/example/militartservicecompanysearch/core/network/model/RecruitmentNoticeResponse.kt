package com.example.militartservicecompanysearch.core.network.model

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "response")
data class RecruitmentNoticeResponse(
    @Element(name = "body")
    val body: Body,
    @Element(name = "header")
    val header: Header
)

@Xml(name = "header")
data class Header(
    @PropertyElement(name = "resultCode")
    val resultCode: Int,
    @PropertyElement(name = "resultMsg")
    val resultMessage: String
)

@Xml(name = "body")
data class Body(
    @Element(name = "items")
    val items: NetworkRecruitmentNotices,
    @PropertyElement(name = "numOfRows")
    val numOfRows: Int,
    @PropertyElement(name = "pageNo")
    val pageNo: Int,
    @PropertyElement(name = "totalCount")
    val totalCount: Int
)

@Xml(name = "items")
data class NetworkRecruitmentNotices(
    @Element(name = "item")
    val item: List<NetworkRecruitmentNotice>
)

@Xml(name = "item")
data class NetworkRecruitmentNotice(
    @PropertyElement(name = "bokrihs")
    val welfareBenefits: String?, // 복리후생
    @PropertyElement(name = "ccdatabalsaengDtm")
    val registrationDate: String, // 최초발생일
    @PropertyElement(name = "cjdatabyeongyeongDtm")
    val lastModifiedDate: String, // 최종변동일
    @PropertyElement(name = "cjhakryeok")
    val highestEducation: String, // 최종학력
    @PropertyElement(name = "cygonggoNo")
    val recruitmentNo: String, // 채용번호
    @PropertyElement(name = "cyjemokNm")
    val recruitmentTitle: String, // 채용제목
    @PropertyElement(name = "damdangjaFnm")
    val manager: String, // 담당자
    @PropertyElement(name = "ddeopmuNm")
    val jobPosition: String, // 담당업무
    @PropertyElement(name = "ddjyeonrakcheoNo")
    val managerPhoneNumber: String?, // 담당자연락처
    @PropertyElement(name = "dpyeonrakcheoNo")
    val companyPhoneNumber: String, // 대표연락처
    @PropertyElement(name = "eopcheNm")
    val companyName: String, // 업체명
    @PropertyElement(name = "eopjongGbcd")
    val sectorCode: String, // 업종구분코드
    @PropertyElement(name = "eopjongGbcdNm")
    val sector: String, // 업종구분명
    @PropertyElement(name = "geunmujy")
    val companyAddress: String, // 근무지주소
    @PropertyElement(name = "geunmujysido")
    val location: String, // 근무지시도
    @PropertyElement(name = "gmhyeongtaeNm")
    val workingDays: String, // 근무일
    @PropertyElement(name = "gmjybjusoCd")
    val locationCode: String, // 근무지법정동코드
    @PropertyElement(name = "grNs")
    val careerPeriod: String?, // 경력년수
    @PropertyElement(name = "gyeongryeokGbcdNm")
    val careerCategory: String, // 경력구분
    @PropertyElement(name = "gyjogeonCd")
    val salaryCode: String, // 급여 조건 코드
    @PropertyElement(name = "gyjogeonCdNm")
    val salary: String, // 급여 조건명
    @PropertyElement(name = "hmpgAddr")
    val homePageLink: String?, // 회사 사이트
    @PropertyElement(name = "jeopsubb")
    val submissionMethod: String?, // 접수방법
    @PropertyElement(name = "jusoCd")
    val companyAddressCode: String,
    @PropertyElement(name = "magamDt")
    val dueDate: String, // 마감일자
    @PropertyElement(name = "mjinwonNm")
    val recruitmentCount: String, // 모집 인원
    @PropertyElement(name = "saeopjaDrno")
    val saeopjaDrno: String, // 사업자번호
    @PropertyElement(name = "yeokjongBrcd")
    val personnelCode: String, // 역종분류코드
    @PropertyElement(name = "yeokjongBrcdNm")
    val personnel: String, // 역종 분류명
    @PropertyElement(name = "yowonGbcd")
    val militaryServiceTypeCode: String, // 요원 구분 코드
    @PropertyElement(name = "yowonGbcdNm")
    val militaryServiceType: String, // 요원 구분명
    @PropertyElement(name = "yuhyoYn")
    val validFlag: String, // 유효 여부
)
