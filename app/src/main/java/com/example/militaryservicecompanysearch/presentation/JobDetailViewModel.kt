package com.example.militaryservicecompanysearch.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice
import com.example.militaryservicecompanysearch.domain.repository.MilitaryServiceCompanyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JobDetailViewModel @Inject constructor(
    private val militaryServiceCompanyRepository: MilitaryServiceCompanyRepository
) : ViewModel() {

    private val _isBookmarked = MutableStateFlow(false)
    val isBookmarked: StateFlow<Boolean> = _isBookmarked

    fun updateBookmarkStatus(recruitmentNo: String) {
        viewModelScope.launch {
            _isBookmarked.value = !isBookmarked.value
            militaryServiceCompanyRepository.updateBookmarkStatus(recruitmentNo, _isBookmarked.value)
        }
    }

    fun setIsBookmarked(isBookmarked: Boolean) {
        _isBookmarked.value = isBookmarked
    }

}
