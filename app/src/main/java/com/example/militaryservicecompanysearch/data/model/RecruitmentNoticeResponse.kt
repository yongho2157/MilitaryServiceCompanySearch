package com.example.militaryservicecompanysearch.data.model

import com.example.militaryservicecompanysearch.domain.model.Item
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
