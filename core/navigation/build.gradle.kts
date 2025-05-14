plugins {
    alias(libs.plugins.mscs.android.library)
    alias(libs.plugins.mscs.android.library.compose)
    alias(libs.plugins.kotlinSerialization)
}

android {
    namespace = "com.example.militaryservicecompanysearch.core.navigation"
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
}
