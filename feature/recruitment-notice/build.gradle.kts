plugins {
    alias(libs.plugins.mscs.android.feature)
    alias(libs.plugins.mscs.android.library.compose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.mscs.hilt)
}

android {
    namespace = "com.example.mscs.feature.recruitmentnotice"
}

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.domain)
    implementation(libs.androidx.paging.common.ktx)
    implementation(libs.androidx.paging.runtime.ktx)
    implementation(libs.androidx.paging.compose)

}

