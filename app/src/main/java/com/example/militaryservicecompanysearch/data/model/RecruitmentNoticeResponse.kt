package com.example.militaryservicecompanysearch.data.model

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "response")
data class RecruitmentNoticeResponse(
    @Element(name = "body")
    val body: Body,
    @Element(name="header")
    val header: Header
)

@Xml(name = "header")
data class Header(
    @PropertyElement(name = "resultCode")
    val resultCode: Int,
    @PropertyElement(name = "resultMsg")
    val resultMessage: String
)

@Xml(name = "Body")
data class Body(
    @Element(name = "items")
    val items: Items,
    @PropertyElement(name = "numOfRows")
    val numOfRows: Int,
    @PropertyElement(name = "pageNo")
    val pageNo: Int,
    @PropertyElement(name = "totalCount")
    val totalCount: Int
)

@Xml(name = "items")
data class Items(
    @Element(name = "item")
    val item: List<Item>
)

@Xml
data class Item(
    @PropertyElement(name = "bookrihs")
    var welfareBenefits: String, // 복리후생
    @PropertyElement(name = "Cjhakryeok")
    var highestEducationLevel: String, // 최종학력
    @PropertyElement(name = "Cjhakryeok")
    var title: String, // 채용제목
    @PropertyElement(name = "damdangjaFnm")
    var managerName: String, // 담당자
    @PropertyElement(name = "ddeopmuNm")
    var responsibility: String, // 담당 업무
    @PropertyElement(name = "ddjyeonrakcheoNo")
    var managerPhoneNo: String, // 담당자 연락처
    @PropertyElement(name = "eopcheNm")
    var companyName: String, // 업체명
    @PropertyElement(name = "Geunmujy")
    var address: String, // 근무지주소
    @PropertyElement(name = "damdangjaFnm")
    var salaryConditions: String // 급여조건
)
