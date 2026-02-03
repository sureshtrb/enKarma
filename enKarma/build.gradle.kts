plugins {
    // Android Gradle Plugin (AGP) 8.6.0
    id("com.android.application") version "8.6.0" apply false
    id("com.android.library") version "8.6.0" apply false

    // Kotlin 2.0.21
    id("org.jetbrains.kotlin.android") version "2.0.21" apply false
    id("org.jetbrains.kotlin.kapt") version "2.0.21" apply false

    // Compose Compiler plugin
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.21" apply false

    // KSP - compatible with Kotlin 2.0.x
    id("com.google.devtools.ksp") version "2.0.21-1.0.25" apply false

    // Google Services plugin
    id("com.google.gms.google-services") version "4.4.2" apply false
}

tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}
