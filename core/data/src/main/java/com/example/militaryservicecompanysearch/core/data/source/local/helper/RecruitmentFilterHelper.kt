package com.example.militaryservicecompanysearch.core.data.source.local.helper

import Personnel

object RecruitmentFilterHelper {
    fun isNoFilter(
        sectors: List<String>,
        militaryServiceTypeCode: Int,
        personnelCode: String
    ): Boolean {
        return sectors.isEmpty() &&
                militaryServiceTypeCode == 0 &&
                personnelCode == Personnel.ALL.code
    }

    fun isAllFiltersPresent(
        sectors: List<String>,
        militaryServiceTypeCode: Int,
        personnelCode: String
    ): Boolean {
        return sectors.isNotEmpty() &&
                militaryServiceTypeCode != 0 &&
                personnelCode != Personnel.ALL.code
    }

    fun isSectorsOnly(sectors: List<String>): Boolean {
        return sectors.isNotEmpty()
    }

    fun isMilitaryServiceOnly(militaryServiceTypeCode: Int): Boolean {
        return militaryServiceTypeCode != 0
    }

    fun isPersonnelOnly(personnelCode: String): Boolean {
        return personnelCode != Personnel.ALL.code
    }

    fun isSectorsAndPersonnel(sectors: List<String>, personnelCode: String): Boolean {
        return sectors.isNotEmpty() && personnelCode != Personnel.ALL.code
    }

    fun isMilitaryServiceAndPersonnel(
        militaryServiceTypeCode: Int,
        personnelCode: String
    ): Boolean {
        return militaryServiceTypeCode != 0 && personnelCode != Personnel.ALL.code
    }
}
