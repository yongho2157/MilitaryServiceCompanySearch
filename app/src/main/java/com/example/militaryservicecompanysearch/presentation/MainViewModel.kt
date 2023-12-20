package com.example.militaryservicecompanysearch.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.militaryservicecompanysearch.domain.repository.MilitaryServiceCompanyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val militaryServiceCompanyRepository: MilitaryServiceCompanyRepository
) : ViewModel() {

    fun getRecruitmentNotices() {
        CoroutineScope(Dispatchers.IO).launch {
            militaryServiceCompanyRepository.getRecruitmentNotices()
                .map {
                    Log.d("결과", "it: $it")
                }
        }
    }

}