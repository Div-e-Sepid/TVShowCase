plugins {
    id("kotlin")
}

sourceSets {
    getByName("main").java.srcDirs("src/main/kotlin")
}

dependencies {
    api(Dependency.Kotlin.stdLib)
    api(Dependency.Kotlin.Coroutines.android)
}