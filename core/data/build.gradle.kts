plugins {
    alias(libs.plugins.mscs.android.library)
    alias(libs.plugins.mscs.hilt)
}

android {
    namespace = "com.example.militaryservicecompanysearch.core.data"
}

dependencies {
    api(projects.core.common)
    implementation(projects.core.network)
    implementation(projects.core.database)
    implementation(projects.core.domain)

    implementation(libs.room.ktx)
    implementation(libs.retrofit.core)
    implementation(libs.androidx.paging.common.ktx)
    implementation(libs.androidx.paging.runtime.ktx)
}
