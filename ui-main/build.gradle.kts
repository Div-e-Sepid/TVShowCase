plugins {
    id("com.android.library")
    id("dagger.hilt.android.plugin")
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
    api(project(":presentation"))
    api(project(":domain"))

    implementation(Dependency.Google.Hilt.android)
    kapt(Dependency.Google.Hilt.compiler)

    testImplementation(Dependency.junit)
    androidTestImplementation(Dependency.AndroidX.Test.ext)
    androidTestImplementation(Dependency.AndroidX.Test.espressoCore)
}