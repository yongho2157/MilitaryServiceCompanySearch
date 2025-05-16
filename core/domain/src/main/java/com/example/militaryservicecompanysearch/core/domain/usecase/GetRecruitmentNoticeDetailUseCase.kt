package com.example.militaryservicecompanysearch.core.domain.usecase

import com.example.militaryservicecompanysearch.core.domain.repository.MilitaryServiceCompanyRepository
import javax.inject.Inject

class GetRecruitmentNoticeDetailUseCase @Inject constructor(
    private val militaryServiceCompanyRepository: MilitaryServiceCompanyRepository
) {
    suspend operator fun invoke(recruitmentNo: String) =
        militaryServiceCompanyRepository.getRecruitmentNoticeByRecruitmentNo(recruitmentNo)
}
