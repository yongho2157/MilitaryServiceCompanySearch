plugins {
    alias(libs.plugins.mscs.android.application)
    alias(libs.plugins.mscs.android.application.compose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.mscs.hilt)
}

android {
    namespace = "com.example.militaryservicecompanysearch"

    defaultConfig {

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    lint {
        abortOnError = false  // lint 에러 무시
        checkReleaseBuilds = false
    }

    // 리소스 관련 에러도 무시
    aaptOptions {
        ignoreAssetsPattern = "!.svn:!.git:!.ds_store:!*.scc:.*:!CVS:!thumbs.db:!picasa.ini:!*~"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {


    // Modules
    implementation(projects.core.data)
    implementation(projects.core.domain)
    implementation(projects.feature.main)
    implementation(projects.feature.recruitment)

    // Navigation
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui.ktx)
//    implementation(libs.androidx.navigation.compose)

    // Paging
    implementation(libs.androidx.paging.common.ktx)
    implementation(libs.androidx.paging.runtime.ktx)
}
