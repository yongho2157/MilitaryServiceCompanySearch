plugins {
    alias(libs.plugins.mscs.android.library)
    alias(libs.plugins.mscs.hilt)
}

android {
    namespace = "com.example.militaryservicecompanysearch.core.domain"
}

dependencies {
    implementation(projects.core.common)
    api(projects.core.model)

    implementation(libs.androidx.paging.common.ktx)
    implementation(libs.androidx.paging.runtime.ktx)
}
