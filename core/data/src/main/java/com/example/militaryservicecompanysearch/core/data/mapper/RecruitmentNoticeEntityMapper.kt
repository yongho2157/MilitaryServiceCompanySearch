package com.example.militaryservicecompanysearch.core.data.mapper

import androidx.paging.PagingData
import androidx.paging.map
import com.example.militartservicecompanysearch.core.model.RecruitmentNotice
import com.example.militartservicecompanysearch.core.network.model.NetworkRecruitmentNotice
import com.example.militaryservicecompanysearch.core.database.model.RecruitmentNoticeEntity

internal fun NetworkRecruitmentNotice.toEntity(): RecruitmentNoticeEntity {
    return RecruitmentNoticeEntity(
        welfareBenefits = this.welfareBenefits ?: "",
        registrationDate = this.registrationDate,
        lastModifiedDate = this.lastModifiedDate,
        highestEducation = this.highestEducation,
        recruitmentNo = this.recruitmentNo,
        recruitmentTitle = this.recruitmentTitle,
        manager = this.manager,
        jobPosition = this.jobPosition,
        managerPhoneNumber = this.managerPhoneNumber ?: "",
        companyPhoneNumber = this.companyPhoneNumber,
        companyName = this.companyName,
        sectorCode = this.sectorCode,
        sector = this.sector,
        companyAddress = this.companyAddress,
        location = this.location,
        workingDays = this.workingDays,
        locationCode = this.locationCode,
        careerPeriod = this.careerPeriod ?: "",
        careerCategory = this.careerCategory,
        salaryCode = this.salaryCode,
        salary = this.salary,
        homePageLink = this.homePageLink ?: "",
        submissionMethod = this.submissionMethod ?: "",
        companyAddressCode = this.companyAddressCode,
        dueDate = this.dueDate,
        recruitmentCount = this.recruitmentCount,
        saeopjaDrno = this.saeopjaDrno,
        personnelCode = this.personnelCode,
        personnel = this.personnel,
        militaryServiceTypeCode = this.militaryServiceTypeCode,
        militaryServiceType = this.militaryServiceType,
        validFlag = this.validFlag,
        isBookmarked = false
    )
}

internal fun RecruitmentNotice.toEntity(): RecruitmentNoticeEntity {
    return RecruitmentNoticeEntity(
        welfareBenefits = this.welfareBenefits ?: "",
        registrationDate = this.registrationDate,
        lastModifiedDate = this.lastModifiedDate,
        highestEducation = this.highestEducation,
        recruitmentNo = this.recruitmentNo,
        recruitmentTitle = this.recruitmentTitle,
        manager = this.manager,
        jobPosition = this.jobPosition,
        managerPhoneNumber = this.managerPhoneNumber ?: "",
        companyPhoneNumber = this.companyPhoneNumber,
        companyName = this.companyName,
        sectorCode = this.sectorCode,
        sector = this.sector,
        companyAddress = this.companyAddress,
        location = this.location,
        workingDays = this.workingDays,
        locationCode = this.locationCode,
        careerPeriod = this.careerPeriod ?: "",
        careerCategory = this.careerCategory,
        salaryCode = this.salaryCode,
        salary = this.salary,
        homePageLink = this.homePageLink ?: "",
        submissionMethod = this.submissionMethod ?: "",
        companyAddressCode = this.companyAddressCode,
        dueDate = this.dueDate,
        recruitmentCount = this.recruitmentCount,
        saeopjaDrno = this.saeopjaDrno,
        personnelCode = this.personnelCode,
        personnel = this.personnel,
        militaryServiceTypeCode = this.militaryServiceTypeCode,
        militaryServiceType = this.militaryServiceType,
        validFlag = this.validFlag,
        isBookmarked = this.isBookmarked
    )
}

internal fun NetworkRecruitmentNotice.toDomain(): RecruitmentNotice {
    return RecruitmentNotice(
        welfareBenefits = this.welfareBenefits,
        registrationDate = this.registrationDate,
        lastModifiedDate = this.lastModifiedDate,
        highestEducation = this.highestEducation,
        recruitmentNo = this.recruitmentNo,
        recruitmentTitle = this.recruitmentTitle,
        manager = this.manager,
        jobPosition = this.jobPosition,
        managerPhoneNumber = this.managerPhoneNumber,
        companyPhoneNumber = this.companyPhoneNumber,
        companyName = this.companyName,
        sectorCode = this.sectorCode,
        sector = this.sector,
        companyAddress = this.companyAddress,
        location = this.location,
        workingDays = this.workingDays,
        locationCode = this.locationCode,
        careerPeriod = this.careerPeriod,
        careerCategory = this.careerCategory,
        salaryCode = this.salaryCode,
        salary = this.salary,
        homePageLink = this.homePageLink,
        submissionMethod = this.submissionMethod,
        companyAddressCode = this.companyAddressCode,
        dueDate = this.dueDate,
        recruitmentCount = this.recruitmentCount,
        saeopjaDrno = this.saeopjaDrno,
        personnelCode = this.personnelCode,
        personnel = this.personnel,
        militaryServiceTypeCode = this.militaryServiceTypeCode,
        militaryServiceType = this.militaryServiceType,
        validFlag = this.validFlag
    )
}

internal fun RecruitmentNoticeEntity.toDomain(): RecruitmentNotice {
    return RecruitmentNotice(
        welfareBenefits = this.welfareBenefits,
        registrationDate = this.registrationDate,
        lastModifiedDate = this.lastModifiedDate,
        highestEducation = this.highestEducation,
        recruitmentNo = this.recruitmentNo,
        recruitmentTitle = this.recruitmentTitle,
        manager = this.manager,
        jobPosition = this.jobPosition,
        managerPhoneNumber = this.managerPhoneNumber,
        companyPhoneNumber = this.companyPhoneNumber,
        companyName = this.companyName,
        sectorCode = this.sectorCode,
        sector = this.sector,
        companyAddress = this.companyAddress,
        location = this.location,
        workingDays = this.workingDays,
        locationCode = this.locationCode,
        careerPeriod = this.careerPeriod,
        careerCategory = this.careerCategory,
        salaryCode = this.salaryCode,
        salary = this.salary,
        homePageLink = this.homePageLink,
        submissionMethod = this.submissionMethod,
        companyAddressCode = this.companyAddressCode,
        dueDate = this.dueDate,
        recruitmentCount = this.recruitmentCount,
        saeopjaDrno = this.saeopjaDrno,
        personnelCode = this.personnelCode,
        personnel = this.personnel,
        militaryServiceTypeCode = this.militaryServiceTypeCode,
        militaryServiceType = this.militaryServiceType,
        validFlag = this.validFlag,
        isBookmarked = this.isBookmarked
    )
}

internal fun PagingData<RecruitmentNoticeEntity>.toDomain(): PagingData<RecruitmentNotice> {
    return this.map {
        it.toDomain()
    }
}

internal fun PagingData<RecruitmentNotice>.asEntity(): PagingData<RecruitmentNoticeEntity> {
    return this.map {
        it.toEntity()
    }
}
