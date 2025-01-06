enum class Personnel(val type: String, val code: String) {
    ALL("전체", "000"),
    ACTIVE("현역", "006"),
    SUPPLEMENTARY("보충역", "002");

    companion object {
        fun fromCode(type: String): String = entries.find { it.type == type }?.code ?: ALL.code
    }
}
