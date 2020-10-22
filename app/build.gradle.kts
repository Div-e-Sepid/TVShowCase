plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion(Version.compileSdkVersion)
    buildToolsVersion(Version.buildToolsVersion)

    defaultConfig {
        applicationId = "com.boozt.tvshowcase"
        minSdkVersion(Version.minSdkVersion)
        targetSdkVersion(Version.targetSdkVersion)
        versionCode = Version.versionCode
        versionName = Version.versionName
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-DEBUG"
        }
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
        getByName("androidTest").java.srcDirs("src/androidTest/kotlin")
        getByName("test").java.srcDirs("src/test/kotlin")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(Dependency.Kotlin.stdLib)
    implementation(Dependency.Kotlin.Coroutines.android)
    testImplementation(Dependency.Kotlin.Coroutines.test)

    implementation(Dependency.AndroidX.coreKtx)
    implementation(Dependency.AndroidX.appCompat)
    implementation(Dependency.AndroidX.material)
    androidTestImplementation(Dependency.AndroidX.Test.ext)
    androidTestImplementation(Dependency.AndroidX.Test.espressoCore)

    testImplementation(Dependency.junit)
}