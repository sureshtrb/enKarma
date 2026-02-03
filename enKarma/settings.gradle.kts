pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev/")
        maven("https://jitpack.io")
    }

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "com.android.application",
                "com.android.library" ->
                    useModule("com.android.tools.build:gradle:8.6.0")

                "org.jetbrains.kotlin.android",
                "org.jetbrains.kotlin.jvm",
                "org.jetbrains.kotlin.kapt" ->
                    useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.21")

                "org.jetbrains.kotlin.plugin.compose" ->
                    useModule(
                        "org.jetbrains.kotlin.plugin.compose:" +
                        "org.jetbrains.kotlin.plugin.compose.gradle.plugin:2.0.21"
                    )

                "com.google.devtools.ksp" ->
                    useModule(
                        "com.google.devtools.ksp:" +
                        "com.google.devtools.ksp.gradle.plugin:2.0.21-1.0.25"
                    )

                "com.google.gms.google-services" ->
                    useModule("com.google.gms:google-services:4.4.2")
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
        maven("https://jitpack.io")
    }
}

rootProject.name = "enKarma"
include(":app")
