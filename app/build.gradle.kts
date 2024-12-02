import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt)
    alias(libs.plugins.navigation.safeargs)
    alias(libs.plugins.kotlin.parcelize)
}

val properties = Properties().apply { load(FileInputStream(File(rootProject.rootDir, "local.properties"))) }

android {
    namespace = "com.example.militaryservicecompanysearch"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.militaryservicecompanysearch"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "BASE_URL", properties.getProperty("base_url"))
        buildConfigField("String", "SERVICE_KEY", properties.getProperty("service_key"))
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        buildConfig = true
        dataBinding = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }

    packaging {
        resources {
//            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "META-INF/gradle/incremental.annotation.processors"
        }
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // tikxml
    implementation(libs.tikxml.annotation)
    implementation(libs.tikxml.core)
    implementation(libs.tikxml.retrofit.converter)
    kapt(libs.tikxml.processor)

    // retrofit
    implementation(libs.retrofit.core)

    // hilt
    implementation(libs.hilt.android)
    implementation(libs.hilt.compiler)

    // okhttp
    implementation(libs.okhttp.logging)

    implementation(libs.fragment.ktx)

    // navigation
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui.ktx)

    // room
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    implementation(libs.room.paging)
    kapt(libs.room.compiler)

    // paging
    implementation(libs.androidx.paging.common.ktx)
    implementation(libs.androidx.paging.runtime.ktx)

}
