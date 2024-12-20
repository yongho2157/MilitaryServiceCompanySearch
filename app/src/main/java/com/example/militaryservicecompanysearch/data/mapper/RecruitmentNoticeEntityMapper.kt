package com.example.militaryservicecompanysearch.data.mapper

import androidx.paging.PagingData
import androidx.paging.map
import com.example.militaryservicecompanysearch.data.model.RecruitmentNoticeEntity
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice

object RecruitmentNoticeEntityMapper : EntityMapper<List<RecruitmentNotice>, List<RecruitmentNoticeEntity>> {

    override fun asEntity(domain: List<RecruitmentNotice>): List<RecruitmentNoticeEntity> {
        return domain.map { domain ->
            RecruitmentNoticeEntity(
                welfareBenefits = domain.welfareBenefits ?: "",
                registrationDate = domain.registrationDate ?: "",
                lastModifiedDate = domain.lastModifiedDate ?: "",
                highestEducation = domain.highestEducation ?: "",
                recruitmentNo = domain.recruitmentNo ?: "",
                recruitmentTitle = domain.recruitmentTitle ?: "",
                manager = domain.manager ?: "",
                jobPosition = domain.jobPosition ?: "",
                managerPhoneNumber = domain.managerPhoneNumber ?: "",
                companyPhoneNumber = domain.companyPhoneNumber ?: "",
                companyName = domain.companyName ?: "",
                sectorCode = domain.sectorCode ?: "",
                sector = domain.sector ?: "",
                companyAddress = domain.companyAddress ?: "",
                location = domain.location ?: "",
                workingDays = domain.workingDays ?: "",
                locationCode = domain.locationCode ?: "",
                careerPeriod = domain.careerPeriod ?: "",
                careerCategory = domain.careerCategory ?: "",
                salaryCode = domain.salaryCode ?: "",
                salary = domain.salary ?: "",
                homePageLink = domain.homePageLink ?: "",
                submissionMethod = domain.submissionMethod ?: "",
                companyAddressCode = domain.companyAddressCode ?: "",
                dueDate = domain.dueDate ?: "",
                recruitmentCount = domain.recruitmentCount ?: "",
                saeopjaDrno = domain.saeopjaDrno ?: "",
                personnelCode = domain.personnelCode ?: "",
                personnel = domain.personnel ?: "",
                militaryServiceTypeCode = domain.militaryServiceTypeCode ?: "",
                militaryServiceType = domain.militaryServiceType ?: "",
                validFlag = domain.validFlag ?: "",
                isBookmarked = domain.isBookmarked
            )
        }
    }

    override fun asDomain(entity: List<RecruitmentNoticeEntity>): List<RecruitmentNotice> {
        return entity.map { entity ->
            RecruitmentNotice(
                welfareBenefits = entity.welfareBenefits,
                registrationDate = entity.registrationDate,
                lastModifiedDate = entity.lastModifiedDate,
                highestEducation = entity.highestEducation,
                recruitmentNo = entity.recruitmentNo,
                recruitmentTitle = entity.recruitmentTitle,
                manager = entity.manager,
                jobPosition = entity.jobPosition,
                managerPhoneNumber = entity.managerPhoneNumber,
                companyPhoneNumber = entity.companyPhoneNumber,
                companyName = entity.companyName,
                sectorCode = entity.sectorCode,
                sector = entity.sector,
                companyAddress = entity.companyAddress,
                location = entity.location,
                workingDays = entity.workingDays,
                locationCode = entity.locationCode,
                careerPeriod = entity.careerPeriod,
                careerCategory = entity.careerCategory,
                salaryCode = entity.salaryCode,
                salary = entity.salary,
                homePageLink = entity.homePageLink,
                submissionMethod = entity.submissionMethod,
                companyAddressCode = entity.companyAddressCode,
                dueDate = entity.dueDate,
                recruitmentCount = entity.recruitmentCount,
                saeopjaDrno = entity.saeopjaDrno,
                personnelCode = entity.personnelCode,
                personnel = entity.personnel,
                militaryServiceTypeCode = entity.militaryServiceTypeCode,
                militaryServiceType = entity.militaryServiceType,
                validFlag = entity.validFlag,
                isBookmarked = entity.isBookmarked
            )
        }
    }
}

fun List<RecruitmentNotice>.asEntity(): List<RecruitmentNoticeEntity> {
    return RecruitmentNoticeEntityMapper.asEntity(this)
}

fun List<RecruitmentNoticeEntity>.asDomain(): List<RecruitmentNotice> {
    return RecruitmentNoticeEntityMapper.asDomain(this)
}

fun PagingData<RecruitmentNoticeEntity>.asDomain(): PagingData<RecruitmentNotice> {
    return this.map { entity ->
        RecruitmentNotice(
            welfareBenefits = entity.welfareBenefits,
            registrationDate = entity.registrationDate,
            lastModifiedDate = entity.lastModifiedDate,
            highestEducation = entity.highestEducation,
            recruitmentNo = entity.recruitmentNo,
            recruitmentTitle = entity.recruitmentTitle,
            manager = entity.manager,
            jobPosition = entity.jobPosition,
            managerPhoneNumber = entity.managerPhoneNumber,
            companyPhoneNumber = entity.companyPhoneNumber,
            companyName = entity.companyName,
            sectorCode = entity.sectorCode,
            sector = entity.sector,
            companyAddress = entity.companyAddress,
            location = entity.location,
            workingDays = entity.workingDays,
            locationCode = entity.locationCode,
            careerPeriod = entity.careerPeriod,
            careerCategory = entity.careerCategory,
            salaryCode = entity.salaryCode,
            salary = entity.salary,
            homePageLink = entity.homePageLink,
            submissionMethod = entity.submissionMethod,
            companyAddressCode = entity.companyAddressCode,
            dueDate = entity.dueDate,
            recruitmentCount = entity.recruitmentCount,
            saeopjaDrno = entity.saeopjaDrno,
            personnelCode = entity.personnelCode,
            personnel = entity.personnel,
            militaryServiceTypeCode = entity.militaryServiceTypeCode,
            militaryServiceType = entity.militaryServiceType,
            validFlag = entity.validFlag,
            isBookmarked = entity.isBookmarked
        )
    }
}

fun PagingData<RecruitmentNotice>.asEntity(): PagingData<RecruitmentNoticeEntity> {
    return this.map { domain ->
        RecruitmentNoticeEntity(
            welfareBenefits = domain.welfareBenefits ?: "",
            registrationDate = domain.registrationDate ?: "",
            lastModifiedDate = domain.lastModifiedDate ?: "",
            highestEducation = domain.highestEducation ?: "",
            recruitmentNo = domain.recruitmentNo ?: "",
            recruitmentTitle = domain.recruitmentTitle ?: "",
            manager = domain.manager ?: "",
            jobPosition = domain.jobPosition ?: "",
            managerPhoneNumber = domain.managerPhoneNumber ?: "",
            companyPhoneNumber = domain.companyPhoneNumber ?: "",
            companyName = domain.companyName ?: "",
            sectorCode = domain.sectorCode ?: "",
            sector = domain.sector ?: "",
            companyAddress = domain.companyAddress ?: "",
            location = domain.location ?: "",
            workingDays = domain.workingDays ?: "",
            locationCode = domain.locationCode ?: "",
            careerPeriod = domain.careerPeriod ?: "",
            careerCategory = domain.careerCategory ?: "",
            salaryCode = domain.salaryCode ?: "",
            salary = domain.salary ?: "",
            homePageLink = domain.homePageLink ?: "",
            submissionMethod = domain.submissionMethod ?: "",
            companyAddressCode = domain.companyAddressCode ?: "",
            dueDate = domain.dueDate ?: "",
            recruitmentCount = domain.recruitmentCount ?: "",
            saeopjaDrno = domain.saeopjaDrno ?: "",
            personnelCode = domain.personnelCode ?: "",
            personnel = domain.personnel ?: "",
            militaryServiceTypeCode = domain.militaryServiceTypeCode ?: "",
            militaryServiceType = domain.militaryServiceType ?: "",
            validFlag = domain.validFlag ?: "",
            isBookmarked = domain.isBookmarked
        )
    }
}
