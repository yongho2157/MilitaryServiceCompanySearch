package com.example.mscs.feature.recruitment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.militaryservicecompanysearch.core.domain.usecase.GetRecruitmentNoticesUseCase
import com.example.mscs.feature.model.RecruitmentUiState
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
    private val _recruitmentUiState = MutableStateFlow<RecruitmentUiState>(RecruitmentUiState.Loading)
    val recruitmentUiState: StateFlow<RecruitmentUiState> = _recruitmentUiState.asStateFlow()

    init {
        viewModelScope.launch {
            _recruitmentUiState.value = RecruitmentUiState.Success(
                recruitmentNotices = getRecruitmentNoticesUseCase(
                    sectors = emptyList(),
                    militaryServiceType = "",
                    personnel = ""
                ).cachedIn(viewModelScope)
            )
        }
    }
}
