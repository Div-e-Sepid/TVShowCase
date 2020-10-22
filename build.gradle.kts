buildscript {

    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(Plugin.android)
        classpath(Plugin.kotlin)
        classpath(Plugin.hilt)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}