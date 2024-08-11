package com.example.militaryservicecompanysearch.domain.model

sealed interface DataError: Error {
    enum class Network: DataError {
        REQUEST_TIMEOUT,
        NO_INTERNET,
        SERVER_ERROR,
        UNKNOWN
    }

    enum class Database: DataError {
        UNKNOWN
    }

}