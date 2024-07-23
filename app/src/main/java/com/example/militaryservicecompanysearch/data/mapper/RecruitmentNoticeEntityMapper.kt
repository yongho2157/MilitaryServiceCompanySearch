package com.example.militaryservicecompanysearch.data.mapper


import com.example.militaryservicecompanysearch.data.model.RecruitmentNoticeEntity
import com.example.militaryservicecompanysearch.domain.model.RecruitmentNotice

object RecruitmentNoticeEntityMapper : EntityMapper<List<RecruitmentNotice>, List<RecruitmentNoticeEntity>> {

    override fun asEntity(domain: List<RecruitmentNotice>): List<RecruitmentNoticeEntity> {
        return domain.map { recruitmentNotice ->
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
                validFlag = recruitmentNotice.validFlag ?: ""
            )
        }
    }

    override fun asDomain(entity: List<RecruitmentNoticeEntity>): List<RecruitmentNotice> {
        return entity.map { recruitmentNoticeEntity ->
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
                validFlag = recruitmentNoticeEntity.validFlag
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