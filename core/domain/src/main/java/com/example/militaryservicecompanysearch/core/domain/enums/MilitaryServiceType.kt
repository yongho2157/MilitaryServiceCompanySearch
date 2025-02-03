package com.example.militaryservicecompanysearch.core.domain.enums

enum class MilitaryServiceType(val type: String, val code: Int) {
    INDUSTRIAL("산업기능요원", 1),
    RESEARCH("전문연구요원", 2),
    MARITIME("승선근무예비역", 3);

    companion object {
        fun fromCode(type: String): Int {
            return entries.find { it.type == type }?.code ?: 0
        }
    }
}

