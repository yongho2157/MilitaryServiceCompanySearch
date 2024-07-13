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

@Xml(name = "body")
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

@Xml(name = "item")
data class Item(
    @PropertyElement(name = "bokrihs")
    var bokrihs: String?, // 복리후생
    @PropertyElement(name = "ccdatabalsaengDtm")
    var ccdatabalsaengDtm: String?, // 최초발생일
    @PropertyElement(name = "cjdatabyeongyeongDtm")
    var cjdatabyeongyeongDtm: String?, // 최종변동일
    @PropertyElement(name = "cjhakryeok")
    var cjhakryeok: String?, // 최종학력
    @PropertyElement(name = "cygonggoNo")
    var cygonggoNo: String?, // 채용번호
    @PropertyElement(name = "cyjemokNm")
    var cyjemokNm: String?, // 채용제목
    @PropertyElement(name = "damdangjaFnm")
    var damdangjaFnm: String?, // 담당자
    @PropertyElement(name = "ddeopmuNm")
    var ddeopmuNm: String?, // 담당업무
    @PropertyElement(name = "ddjyeonrakcheoNo")
    var ddjyeonrakcheoNo: String?, // 담당자연락처
    @PropertyElement(name = "dpyeonrakcheoNo")
    var dpyeonrakcheoNo: String?, // 대표연락처
    @PropertyElement(name = "eopcheNm")
    var eopcheNm: String?, // 업체명
    @PropertyElement(name = "eopjongGbcd")
    var eopjongGbcd: String?, // 업종구분코드
    @PropertyElement(name = "eopjongGbcdNm")
    var eopjongGbcdNm: String?, // 업종구분명
    @PropertyElement(name = "geunmujy")
    var geunmujy: String?, // 근무지주소
    @PropertyElement(name = "geunmujysido")
    var geunmujysido: String?, // 근무지시도
    @PropertyElement(name = "gmhyeongtaeNm")
    var gmhyeongtaeNm: String?, // 근무일
    @PropertyElement(name = "gmjybjusoCd")
    var gmjybjusoCd: String?, // 근무지법정동코드
    @PropertyElement(name = "grNs")
    var grNs: String?, // 경력년수
    @PropertyElement(name = "gyeongryeokGbcdNm")
    var gyeongryeokGbcdNm: String?, // 경력구분
    @PropertyElement(name = "gyjogeonCd")
    var gyjogeonCd: String?, // 급여 조건 코드
    @PropertyElement(name = "gyjogeonCdNm")
    var gyjogeonCdNm: String?, // 급여 조건명
    @PropertyElement(name = "hmpgAddr")
    var hmpgAddr: String?, // 회사 사이트
    @PropertyElement(name = "jeopsubb")
    var jeopsubb: String?, // 접수방법
    @PropertyElement(name = "jusoCd")
    var jusoCd: String?,
    @PropertyElement(name = "magamDt")
    var magamDt: String?, // 마감일자
    @PropertyElement(name = "mjinwonNm")
    var mjinwonNm: String?, // 모집 인원
    @PropertyElement(name = "saeopjaDrno")
    var saeopjaDrno: String?,
    @PropertyElement(name = "yeokjongBrcd")
    var yeokjongBrcd: String?, // 역종분류코드
    @PropertyElement(name = "yeokjongBrcdNm")
    var yeokjongBrcdNm: String?, // 역종 분류명
    @PropertyElement(name = "yowonGbcd")
    var yowonGbcd: String?, // 요원 구분 코드
    @PropertyElement(name = "yowonGbcdNm")
    var yowonGbcdNm: String?, // 요원 구분명
    @PropertyElement(name = "yuhyoYn")
    var yuhyoYn: String? // 유효 여부
)
