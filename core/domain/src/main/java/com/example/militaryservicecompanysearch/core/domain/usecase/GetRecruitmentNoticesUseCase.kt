package com.example.militaryservicecompanysearch.core.domain.usecase

import Personnel
import com.example.militaryservicecompanysearch.core.domain.enums.MilitaryServiceType
import com.example.militaryservicecompanysearch.core.domain.repository.MilitaryServiceCompanyRepository
import javax.inject.Inject

class GetRecruitmentNoticesUseCase @Inject constructor(
    private val militaryServiceCompanyRepository: MilitaryServiceCompanyRepository
) {
    operator fun invoke(
        sectors: List<String>, militaryServiceType: String, personnel: String
    ) = militaryServiceCompanyRepository.getLocalRecruitmentNotices(
        sectors = sectors,
        militaryServiceTypeCode = MilitaryServiceType.fromCode(militaryServiceType),
        personnelCode = Personnel.fromCode(personnel)
    )
}

