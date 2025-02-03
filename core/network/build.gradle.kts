import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.mscs.android.library)
    alias(libs.plugins.mscs.hilt)
    alias(libs.plugins.kotlin.kapt)
}

val properties = Properties().apply { load(FileInputStream(File(rootProject.rootDir, "local.properties"))) }

android {
    namespace = "com.example.militaryservicecompanysearch.core.network"

    defaultConfig {
        buildConfigField("String", "BASE_URL", properties.getProperty("base_url"))
        buildConfigField("String", "SERVICE_KEY", properties.getProperty("service_key"))
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(projects.core.model)

    // retrofit
    implementation(libs.retrofit.core)

    // okhttp
    implementation(libs.okhttp.logging)

    // tikxml
    implementation(libs.tikxml.core)
    implementation(libs.tikxml.retrofit.converter)
    implementation(libs.tikxml.annotation)
    kapt(libs.tikxml.processor)
}
