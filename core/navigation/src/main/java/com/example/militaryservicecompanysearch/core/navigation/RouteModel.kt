package com.example.militaryservicecompanysearch.core.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
}

sealed interface MainTabRoute : Route {
    @Serializable
    data object Recruitment : MainTabRoute
    @Serializable
    data object Favorite : MainTabRoute
    @Serializable
    data object Search : MainTabRoute
}
