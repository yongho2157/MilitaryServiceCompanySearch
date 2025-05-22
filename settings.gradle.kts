pluginManagement {

    includeBuild("build-logic")

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
gradle.startParameter.excludedTaskNames.addAll(listOf(":build-logic:convention:testClasses"))
rootProject.name = "MilitaryServiceCompanySearch"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":core:network")
include(":core:common")
include(":core:data")
include(":core:database")
include(":core:model")
include(":core:domain")
include(":feature:recruitment-notice")
include(":core:navigation")
include(":feature:main")
include(":feature:recruitment-notice-detail")
include(":core:designsystem")
