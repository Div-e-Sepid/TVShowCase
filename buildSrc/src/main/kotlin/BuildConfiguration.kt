private const val KOTLIN_VERSION = "1.4.10"
private const val HILT_VERSION = "2.28-alpha"
private const val NAVIGATION_VERSION = "2.3.1"

object Plugin {
    const val android = "com.android.tools.build:gradle:4.1.0"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN_VERSION"
    const val hilt = "com.google.dagger:hilt-android-gradle-plugin:$HILT_VERSION"
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
            private const val COROUTINES_VERSION = "1.3.0"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$COROUTINES_VERSION"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$COROUTINES_VERSION"
        }
    }

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:1.3.2"
        const val appCompat = "androidx.appcompat:appcompat:1.2.0"
        const val activity = "androidx.activity:activity-ktx:1.1.0"
        const val fragment = "androidx.fragment:fragment-ktx:1.2.5"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.2"

        object Room {
            private const val ROOM_VERSION = "2.2.5"
            const val runtime = "androidx.room:room-runtime:$ROOM_VERSION"
            const val compiler = "androidx.room:room-compiler:$ROOM_VERSION"
            const val ktx = "androidx.room:room-ktx:$ROOM_VERSION"
            const val testing = "androidx.room:room-testing:$ROOM_VERSION"
        }

        object Navigation {
            const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:$NAVIGATION_VERSION"
            const val uiKtx = "androidx.navigation:navigation-ui-ktx:$NAVIGATION_VERSION"
        }

        object Test {
            const val ext = "androidx.test.ext:junit:1.1.2"
            const val espressoCore = "androidx.test.espresso:espresso-core:3.3.0"
        }
    }

    object Google {
        const val material = "com.google.android.material:material:1.2.1"

        object Hilt {
            const val android = "com.google.dagger:hilt-android:$HILT_VERSION"
            const val compiler = "com.google.dagger:hilt-android-compiler:$HILT_VERSION"
        }
    }

    object Square {

        object OkHttp {
            private const val HTTP_VERSION = "4.7.2"
            const val okhttp = "com.squareup.okhttp3:okhttp:$HTTP_VERSION"
            const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$HTTP_VERSION"
        }

        object Retrofit {
            private const val RETROFIT_VERSION = "2.8.1"
            const val retrofit = "com.squareup.retrofit2:retrofit:$RETROFIT_VERSION"
            const val moshiConverter = "com.squareup.retrofit2:converter-moshi:$RETROFIT_VERSION"
        }

        object Moshi {
            private const val MOSHI_VERSION = "1.11.0"
            const val moshi = "com.squareup.moshi:moshi:$MOSHI_VERSION"
            const val codeGen = "com.squareup.moshi:moshi-kotlin-codegen:$MOSHI_VERSION"
        }
    }

    const val junit = "junit:junit:4.13.1"
}