private const val KOTLIN_VERSION = "1.4.10"

object Plugin {
    const val android = "com.android.tools.build:gradle:4.1.0"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN_VERSION"
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
        const val material = "com.google.android.material:material:1.2.1"

        object Test {
            const val ext = "androidx.test.ext:junit:1.1.2"
            const val espressoCore = "androidx.test.espresso:espresso-core:3.3.0"
        }
    }

    const val junit = "junit:junit:4.13.1"
}