package com.example.militaryservicecompanysearch.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice
import com.example.militaryservicecompanysearch.domain.repository.MilitaryServiceCompanyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val militaryServiceCompanyRepository: MilitaryServiceCompanyRepository
) : ViewModel() {


    init {
        getRecruitmentNotices()
    }
    val recruitmentNoticeList: MutableLiveData<List<RecruitmentNotice>> by lazy {
        MutableLiveData<List<RecruitmentNotice>>()
    }

    fun getRecruitmentNotices() {
        Log.d("결과", "getRecruitmentNotices")
        militaryServiceCompanyRepository.getRecruitmentNotices()
            .map {
                recruitmentNoticeList.value = it
            }
            .launchIn(viewModelScope)
    }

}