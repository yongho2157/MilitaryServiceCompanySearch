package com.example.militaryservicecompanysearch.data.mapper

import com.example.militaryservicecompanysearch.data.model.RecruitmentNoticeEntity
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice

object RecruitmentNoticeEntityMapper : EntityMapper<RecruitmentNotice, RecruitmentNoticeEntity> {

    override fun asEntity(domainList: List<RecruitmentNotice>): List<RecruitmentNoticeEntity> {
        return domainList.map { recruitmentNotice ->
            RecruitmentNoticeEntity(
                welfareBenefits = recruitmentNotice.welfareBenefits ?: "",
                registrationDate = recruitmentNotice.registrationDate ?: "",
                lastModifiedDate = recruitmentNotice.lastModifiedDate ?: "",
                highestEducation = recruitmentNotice.highestEducation ?: "",
                recruitmentNo = recruitmentNotice.recruitmentNo ?: "",
                recruitmentTitle = recruitmentNotice.recruitmentTitle ?: "",
                manager = recruitmentNotice.manager ?: "",
                jobPosition = recruitmentNotice.jobPosition ?: "",
                managerPhoneNumber = recruitmentNotice.managerPhoneNumber ?: "",
                companyPhoneNumber = recruitmentNotice.companyPhoneNumber ?: "",
                companyName = recruitmentNotice.companyName ?: "",
                sectorCode = recruitmentNotice.sectorCode ?: "",
                sector = recruitmentNotice.sector ?: "",
                companyAddress = recruitmentNotice.companyAddress ?: "",
                location = recruitmentNotice.location ?: "",
                workingDays = recruitmentNotice.workingDays ?: "",
                locationCode = recruitmentNotice.locationCode ?: "",
                careerPeriod = recruitmentNotice.careerPeriod ?: "",
                careerCategory = recruitmentNotice.careerCategory ?: "",
                salaryCode = recruitmentNotice.salaryCode ?: "",
                salary = recruitmentNotice.salary ?: "",
                homePageLink = recruitmentNotice.homePageLink ?: "",
                submissionMethod = recruitmentNotice.submissionMethod ?: "",
                companyAddressCode = recruitmentNotice.companyAddressCode ?: "",
                dueDate = recruitmentNotice.dueDate ?: "",
                recruitmentCount = recruitmentNotice.recruitmentCount ?: "",
                saeopjaDrno = recruitmentNotice.saeopjaDrno ?: "",
                personnelCode = recruitmentNotice.personnelCode ?: "",
                personnel = recruitmentNotice.personnel ?: "",
                militaryServiceTypeCode = recruitmentNotice.militaryServiceTypeCode ?: "",
                militaryServiceType = recruitmentNotice.militaryServiceType ?: "",
                validFlag = recruitmentNotice.validFlag ?: "",
                isBookmarked = recruitmentNotice.isBookmarked
            )
        }
    }

    override fun asDomain(entityList: List<RecruitmentNoticeEntity>): List<RecruitmentNotice> {
        return entityList.map { recruitmentNoticeEntity ->
            RecruitmentNotice(
                welfareBenefits = recruitmentNoticeEntity.welfareBenefits,
                registrationDate = recruitmentNoticeEntity.registrationDate,
                lastModifiedDate = recruitmentNoticeEntity.lastModifiedDate,
                highestEducation = recruitmentNoticeEntity.highestEducation,
                recruitmentNo = recruitmentNoticeEntity.recruitmentNo,
                recruitmentTitle = recruitmentNoticeEntity.recruitmentTitle,
                manager = recruitmentNoticeEntity.manager,
                jobPosition = recruitmentNoticeEntity.jobPosition,
                managerPhoneNumber = recruitmentNoticeEntity.managerPhoneNumber,
                companyPhoneNumber = recruitmentNoticeEntity.companyPhoneNumber,
                companyName = recruitmentNoticeEntity.companyName,
                sectorCode = recruitmentNoticeEntity.sectorCode,
                sector = recruitmentNoticeEntity.sector,
                companyAddress = recruitmentNoticeEntity.companyAddress,
                location = recruitmentNoticeEntity.location,
                workingDays = recruitmentNoticeEntity.workingDays,
                locationCode = recruitmentNoticeEntity.locationCode,
                careerPeriod = recruitmentNoticeEntity.careerPeriod,
                careerCategory = recruitmentNoticeEntity.careerCategory,
                salaryCode = recruitmentNoticeEntity.salaryCode,
                salary = recruitmentNoticeEntity.salary,
                homePageLink = recruitmentNoticeEntity.homePageLink,
                submissionMethod = recruitmentNoticeEntity.submissionMethod,
                companyAddressCode = recruitmentNoticeEntity.companyAddressCode,
                dueDate = recruitmentNoticeEntity.dueDate,
                recruitmentCount = recruitmentNoticeEntity.recruitmentCount,
                saeopjaDrno = recruitmentNoticeEntity.saeopjaDrno,
                personnelCode = recruitmentNoticeEntity.personnelCode,
                personnel = recruitmentNoticeEntity.personnel,
                militaryServiceTypeCode = recruitmentNoticeEntity.militaryServiceTypeCode,
                militaryServiceType = recruitmentNoticeEntity.militaryServiceType,
                validFlag = recruitmentNoticeEntity.validFlag,
                isBookmarked = recruitmentNoticeEntity.isBookmarked
            )
        }
    }


    override fun asEntity(domain: RecruitmentNotice): RecruitmentNoticeEntity {
        return RecruitmentNoticeEntity(
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

    override fun asDomain(entity: RecruitmentNoticeEntity): RecruitmentNotice {
        return RecruitmentNotice(
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


fun List<RecruitmentNotice>.asEntity(): List<RecruitmentNoticeEntity> {
    return RecruitmentNoticeEntityMapper.asEntity(this)
}

fun RecruitmentNotice.asEntity(): RecruitmentNoticeEntity {
    return RecruitmentNoticeEntityMapper.asEntity(this)
}

fun List<RecruitmentNoticeEntity>.asDomain(): List<RecruitmentNotice> {
    return RecruitmentNoticeEntityMapper.asDomain(this)
}

fun RecruitmentNoticeEntity.asDomain(): RecruitmentNotice {
    return RecruitmentNoticeEntityMapper.asDomain(this)
}
