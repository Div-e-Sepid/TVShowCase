buildscript {

    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(Plugin.android)
        classpath(Plugin.kotlin)
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