package com.example.mscs.feature.main

import com.example.militaryservicecompanysearch.core.navigation.MainTabRoute

internal enum class MainTab(
    val iconResId: Int,
    val labelResId: Int,
    val route: MainTabRoute
) {
    Recruitment(
        iconResId = R.drawable.baseline_business_center_24,
        labelResId = R.string.tab_recruitment,
        route = MainTabRoute.Recruitment
    ),
    Favorite(
        iconResId = R.drawable.baseline_favorite_24,
        labelResId = R.string.tab_favorite,
        route = MainTabRoute.Favorite
    ),
    Search(
        iconResId = R.drawable.baseline_search_24,
        labelResId = R.string.tab_search,
        route = MainTabRoute.Search
    )
}
