package com.example.militaryservicecompanysearch.presentation.wishrecruitmentnotice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice
import com.example.militaryservicecompanysearch.domain.repository.MilitaryServiceCompanyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WishRecruitmentNoticeViewModel @Inject constructor(
    private val militaryServiceCompanyRepository: MilitaryServiceCompanyRepository
) : ViewModel() {

    private val _wishRecruitmentNoticeUiState =
        MutableStateFlow<WishRecruitmentNoticeUiState>(WishRecruitmentNoticeUiState.Loading)
    val wishRecruitmentNoticeUiState = _wishRecruitmentNoticeUiState.asStateFlow()

    fun getWishRecruitmentNotices() {
        viewModelScope.launch {
            militaryServiceCompanyRepository.getBookmarkedRecruitmentNotices()
                .collect { recruitmentNotices ->
                    if (recruitmentNotices.isEmpty()) {
                        _wishRecruitmentNoticeUiState.value = WishRecruitmentNoticeUiState.Empty
                    } else {
                        _wishRecruitmentNoticeUiState.value =
                            WishRecruitmentNoticeUiState.HasRecruitmentNotices(recruitmentNotices)
                    }
                }
        }

    }

}

sealed interface WishRecruitmentNoticeUiState {

    data object Loading : WishRecruitmentNoticeUiState
    data class HasRecruitmentNotices(val wishRecruitmentNotices: List<RecruitmentNotice>) :
        WishRecruitmentNoticeUiState

    data object Empty : WishRecruitmentNoticeUiState

}
