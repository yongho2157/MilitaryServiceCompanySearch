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
    private val _recruitmentNoticeList = MutableLiveData<List<RecruitmentNotice>>(emptyList())
    val recruitmentNoticeList : LiveData<List<RecruitmentNotice>>
        get() = _recruitmentNoticeList

    init {
        getRecruitmentNotices()
    }

    private fun getRecruitmentNotices() {
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