plugins {
    alias(libs.plugins.mscs.android.feature)
    alias(libs.plugins.mscs.android.library.compose)
}

android {
    namespace = "com.example.mscs.feature.main"
}

dependencies {
    implementation(projects.feature.recruitment)
    implementation(libs.kotlinx.immutable)
}
