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

    api(Dependency.Square.OkHttp.okhttp)
    api(Dependency.Square.OkHttp.loggingInterceptor)

    api(Dependency.Square.Retrofit.retrofit)
    api(Dependency.Square.Retrofit.moshiConverter)

    api(Dependency.Square.Moshi.moshi)
    kapt(Dependency.Square.Moshi.codeGen)

    testImplementation(Dependency.junit)
    testImplementation(Dependency.Kotlin.Coroutines.test)
    androidTestImplementation(Dependency.AndroidX.Test.ext)
}