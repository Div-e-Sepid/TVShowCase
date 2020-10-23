private const val KOTLIN_VERSION = "1.4.10"
private const val version = "2.28-alpha"
private const val NAVIGATION_VERSION = "2.3.1"

object Plugin {
    const val android = "com.android.tools.build:gradle:4.1.0"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN_VERSION"
    const val hilt = "com.google.dagger:hilt-android-gradle-plugin:$version"
    const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:$NAVIGATION_VERSION"
}

object Version {
    const val compileSdkVersion = 30
    const val buildToolsVersion = "30.0.2"

    const val minSdkVersion = 21
    const val targetSdkVersion = 30
    const val versionCode = 1
    const val versionName = "1.0"
}

object Dependency {

    object Kotlin {
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:$KOTLIN_VERSION"

        object Coroutines {
            private const val version = "1.3.0"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        }
    }

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:1.3.2"
        const val appCompat = "androidx.appcompat:appcompat:1.2.0"
        const val activity = "androidx.activity:activity-ktx:1.1.0"
        const val fragment = "androidx.fragment:fragment-ktx:1.2.5"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.2"
        const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:1.1.0"

        object Room {
            private const val version = "2.2.5"
            const val runtime = "androidx.room:room-runtime:$version"
            const val compiler = "androidx.room:room-compiler:$version"
            const val ktx = "androidx.room:room-ktx:$version"
            const val testing = "androidx.room:room-testing:$version"
        }

        object Navigation {
            const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:$NAVIGATION_VERSION"
            const val uiKtx = "androidx.navigation:navigation-ui-ktx:$NAVIGATION_VERSION"
        }

        object Hilt {
            private const val version = "1.0.0-alpha01"
            const val lifecycle = "androidx.hilt:hilt-lifecycle-viewmodel:$version"
            const val compiler = "androidx.hilt:hilt-compiler:$version"
        }

        object Test {
            const val ext = "androidx.test.ext:junit:1.1.2"
            const val espressoCore = "androidx.test.espresso:espresso-core:3.3.0"
        }
    }

    object Google {
        const val material = "com.google.android.material:material:1.2.1"

        object Hilt {
            const val android = "com.google.dagger:hilt-android:$version"
            const val compiler = "com.google.dagger:hilt-android-compiler:$version"
        }
    }

    object Square {

        object OkHttp {
            private const val version = "4.7.2"
            const val okhttp = "com.squareup.okhttp3:okhttp:$version"
            const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
        }

        object Retrofit {
            private const val version = "2.8.1"
            const val retrofit = "com.squareup.retrofit2:retrofit:$version"
            const val moshiConverter = "com.squareup.retrofit2:converter-moshi:$version"
        }

        object Moshi {
            private const val version = "1.11.0"
            const val moshi = "com.squareup.moshi:moshi:$version"
            const val codeGen = "com.squareup.moshi:moshi-kotlin-codegen:$version"
        }
    }

    const val junit = "junit:junit:4.13.1"
}