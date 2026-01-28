pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        // Required for Compose Compiler Gradle plugin resolution
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev/")
    }

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                // Android Gradle Plugin
                "com.android.application",
                "com.android.library" ->
                    useModule("com.android.tools.build:gradle:8.11.0")

                // Kotlin Gradle plugins
                "org.jetbrains.kotlin.android",
                "org.jetbrains.kotlin.jvm",
                "org.jetbrains.kotlin.kapt" ->
                    useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:2.2.21")

                // ✅ Correct Compose Compiler plugin mapping
                "org.jetbrains.kotlin.plugin.compose" ->
                    useModule("org.jetbrains.kotlin.plugin.compose:org.jetbrains.kotlin.plugin.compose.gradle.plugin:2.2.21")

                // KSP – Kotlin Symbol Processing
                "com.google.devtools.ksp" ->
                    useModule("com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:2.2.20-Beta1-2.0.2")

                // Google/Firebase services
                "com.google.gms.google-services" ->
                    useModule("com.google.gms:google-services:4.4.4")
            }
        }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev/")
        maven("https://jitpack.io") // required for com.github.pawegio:KAndroid
    }
}

rootProject.name = "enKarma"
include(":app")
