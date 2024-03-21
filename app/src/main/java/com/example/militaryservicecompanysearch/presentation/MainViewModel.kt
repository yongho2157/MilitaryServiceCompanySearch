package com.example.militaryservicecompanysearch.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.militaryservicecompanysearch.domain.repository.MilitaryServiceCompanyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val militaryServiceCompanyRepository: MilitaryServiceCompanyRepository
) : ViewModel() {

    fun getRecruitmentNotices() {
        Log.d("결과", "getRecruitmentNotices")
        militaryServiceCompanyRepository.getRecruitmentNotices().launchIn(viewModelScope)
    }

}