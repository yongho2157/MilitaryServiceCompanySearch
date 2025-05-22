plugins {
    alias(libs.plugins.mscs.android.feature)
    alias(libs.plugins.mscs.android.library.compose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.mscs.hilt)
}

android {
    namespace = "com.example.mscs.feature.recruitmentnoticedetail"
}

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.domain)
    implementation(projects.core.designsystem)
    implementation(projects.feature.recruitmentNotice)
}

