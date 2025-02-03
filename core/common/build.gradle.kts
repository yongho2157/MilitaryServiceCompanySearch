plugins {
    alias(libs.plugins.mscs.android.library)
}

android {
    namespace = "com.example.militaryservicecompanysearch.core.common"
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
}
