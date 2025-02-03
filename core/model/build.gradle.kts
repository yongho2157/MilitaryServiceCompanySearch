plugins {
    alias(libs.plugins.mscs.android.library)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "com.example.militaryservicecompanysearch.core.model"
}

dependencies {
    implementation(libs.tikxml.annotation)
}
