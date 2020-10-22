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
    api(project(":data"))

    api(Dependency.AndroidX.Room.runtime)
    api(Dependency.AndroidX.Room.ktx)
    kapt(Dependency.AndroidX.Room.compiler)
    testImplementation(Dependency.AndroidX.Room.testing)

    testImplementation(Dependency.junit)
    testImplementation(Dependency.Kotlin.Coroutines.test)
    androidTestImplementation(Dependency.AndroidX.Test.ext)
}