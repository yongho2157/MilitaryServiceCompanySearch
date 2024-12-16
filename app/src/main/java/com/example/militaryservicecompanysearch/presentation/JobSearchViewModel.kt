package com.example.militaryservicecompanysearch.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice
import com.example.militaryservicecompanysearch.domain.repository.MilitaryServiceCompanyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JobSearchViewModel @Inject constructor(
    private val militaryServiceCompanyRepository: MilitaryServiceCompanyRepository
) : ViewModel() {

    private val _recruitmentNoticeList: MutableStateFlow<PagingData<RecruitmentNotice>> =
        MutableStateFlow(PagingData.empty())
    val recruitmentNoticeList = _recruitmentNoticeList.asStateFlow()

    fun getRecruitmentNoticesByTitle(title: String) {
        viewModelScope.launch {
            militaryServiceCompanyRepository
                .getRecruitmentNoticesByTitle(title = title)
                .cachedIn(viewModelScope)
                .collect {
                    _recruitmentNoticeList.value = it
                }
        }
    }

}
