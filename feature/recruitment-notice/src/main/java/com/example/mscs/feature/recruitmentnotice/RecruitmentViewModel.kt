package com.example.mscs.feature.recruitmentnotice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.militaryservicecompanysearch.core.domain.usecase.GetRecruitmentNoticesUseCase
import com.example.mscs.feature.model.RecruitmentNoticeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecruitmentViewModel @Inject constructor(
    private val getRecruitmentNoticesUseCase: GetRecruitmentNoticesUseCase
) : ViewModel() {
    private val _recruitmentNoticeUiState = MutableStateFlow<RecruitmentNoticeUiState>(RecruitmentNoticeUiState.Loading)
    val recruitmentNoticeUiState: StateFlow<RecruitmentNoticeUiState> = _recruitmentNoticeUiState.asStateFlow()

    init {
        viewModelScope.launch {
            _recruitmentNoticeUiState.value = RecruitmentNoticeUiState.Success(
                recruitmentNotices = getRecruitmentNoticesUseCase(
                    sectors = emptyList(),
                    militaryServiceType = "",
                    personnel = ""
                ).cachedIn(viewModelScope)
            )
        }
    }
}
