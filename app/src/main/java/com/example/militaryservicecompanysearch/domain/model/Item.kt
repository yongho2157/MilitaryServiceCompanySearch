package com.example.militaryservicecompanysearch.domain.model

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml
data class Item(
    @PropertyElement(name = "bookrihs")
    var welfareBenefits: String?, // 복리후생
//    @PropertyElement(name = "Cjhakryeok")
//    var highestEducationLevel: String?, // 최종학력
    @PropertyElement(name = "Cjhakryeok")
    var title: String?, // 채용제목
    @PropertyElement(name = "damdangjaFnm")
    var managerName: String?, // 담당자
    @PropertyElement(name = "ddeopmuNm")
    var responsibility: String?, // 담당 업무
    @PropertyElement(name = "ddjyeonrakcheoNo")
    var managerPhoneNo: String?, // 담당자 연락처
    @PropertyElement(name = "eopcheNm")
    var companyName: String?, // 업체명
    @PropertyElement(name = "Geunmujy")
    var address: String?, // 근무지주소
//    @PropertyElement(name = "damdangjaFnm")
//    var salaryConditions: String? // 급여조건
)
