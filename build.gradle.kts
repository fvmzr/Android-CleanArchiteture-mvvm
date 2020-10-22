// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:4.0.0")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")
        classpath(kotlin("gradle-plugin", version = "1.3.72"))
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

