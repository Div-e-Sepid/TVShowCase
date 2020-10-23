plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Version.compileSdkVersion)
    buildToolsVersion(Version.buildToolsVersion)

    defaultConfig {
        minSdkVersion(Version.minSdkVersion)
        targetSdkVersion(Version.targetSdkVersion)
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
        getByName("androidTest").java.srcDirs("src/androidTest/kotlin")
        getByName("test").java.srcDirs("src/test/kotlin")
    }
}

dependencies {
    api(project(":domain"))

    api(Dependency.AndroidX.coreKtx)
    api(Dependency.AndroidX.appCompat)
    api(Dependency.AndroidX.activity)
    api(Dependency.AndroidX.fragment)
    api(Dependency.AndroidX.constraintLayout)
    api(Dependency.AndroidX.swipeRefreshLayout)

    api(Dependency.AndroidX.Navigation.fragmentKtx)
    api(Dependency.AndroidX.Navigation.uiKtx)

    api(Dependency.Google.material)
}