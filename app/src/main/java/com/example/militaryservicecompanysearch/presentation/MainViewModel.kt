package com.example.militaryservicecompanysearch.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.militaryservicecompanysearch.domain.model.DataError
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice
import com.example.militaryservicecompanysearch.domain.model.Result
import com.example.militaryservicecompanysearch.domain.repository.MilitaryServiceCompanyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val militaryServiceCompanyRepository: MilitaryServiceCompanyRepository
) : ViewModel() {

//    val recruitmentNoticeList: MutableLiveData<List<RecruitmentNotice>> by lazy {
//        MutableLiveData<List<RecruitmentNotice>>()
//    }

    private val items = arrayListOf(
        RecruitmentNotice(
            welfareBenefits = "4대보험, 연차, 퇴직금",
            registrationDate = "2024-01-01",
            lastModifiedDate = "2024-02-01",
            highestEducation = "대졸",
            recruitmentNo = "20240101-001",
            recruitmentTitle = "소프트웨어 엔지니어 모집",
            manager = "김철수",
            jobPosition = "백엔드 개발",
            managerPhoneNumber = "010-1234-5678",
            companyPhoneNumber = "02-1234-5678",
            companyName = "테크노 회사",
            sectorCode = "IT",
            sector = "정보통신업",
            companyAddress = "서울특별시 강남구 테헤란로 123",
            location = "서울특별시",
            workingDays = "주 5일",
            locationCode = "1100000000",
            careerPeriod = "3년",
            careerCategory = "경력",
            salaryCode = "연봉",
            salary = "3500만원 이상",
            homePageLink = "https://www.techno.co.kr",
            submissionMethod = "이메일 접수",
            companyAddressCode = "061000",
            dueDate = "2024-02-28",
            recruitmentCount = "3명",
            saeopjaDrno = "123456",
            personnelCode = "01",
            personnel = "전산/컴퓨터",
            militaryServiceTypeCode = "A1",
            militaryServiceType = "산업기능요원",
            validFlag = "Y"
        )
    )

    private val _recruitmentNoticeList = MutableLiveData<List<RecruitmentNotice>>()
    val recruitmentNoticeList : LiveData<List<RecruitmentNotice>>
        get() = _recruitmentNoticeList

//    init {
//        _recruitmentNoticeList.value = items
//    }

    fun getRecruitmentNotices() {
        viewModelScope.launch {
            when (val result = militaryServiceCompanyRepository.getRecruitmentNotices()) {
                is Result.Error -> {
                    when (result.error) {
                        DataError.Network.REQUEST_TIMEOUT -> TODO()
                        DataError.Network.NO_INTERNET -> TODO()
                        DataError.Network.SERVER_ERROR -> TODO()
                        DataError.Network.UNKNOWN -> TODO()
                    }
                }
                is Result.Success -> {
                    _recruitmentNoticeList.value = result.data
                }
            }
        }
    }

    fun getRecruitmentNoticesByTitle(title: String) {
        viewModelScope.launch {
            when (val result = militaryServiceCompanyRepository.getRecruitmentNoticesByTitle(title)) {
                is Result.Error -> TODO()
                is Result.Success -> {
                    Log.d("결과", "result : $result")
                }
            }
        }
    }

}