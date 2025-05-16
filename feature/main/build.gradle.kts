plugins {
    alias(libs.plugins.mscs.android.feature)
    alias(libs.plugins.mscs.android.library.compose)
}

android {
    namespace = "com.example.mscs.feature.main"
}

dependencies {
    implementation(projects.feature.recruitmentNotice)
    implementation(projects.feature.recruitmentNoticeDetail)
    implementation(libs.kotlinx.immutable)
}
