plugins {
    // Android Gradle Plugin (AGP) 8.11.0 — latest stable
    id("com.android.application") version "8.11.0" apply false
    id("com.android.library") version "8.11.0" apply false

    // Kotlin 2.2.21 (stable release as of October 2025)
    id("org.jetbrains.kotlin.android") version "2.2.21" apply false
    id("org.jetbrains.kotlin.kapt") version "2.2.21" apply false

    // KSP 2.2.20‑Beta1‑2.0.2 — compatible with Kotlin 2.2.x
    id("com.google.devtools.ksp") version "2.2.20-Beta1-2.0.2" apply false

    // Google Services plugin 4.4.4 — latest documented by Google Developers
    id("com.google.gms.google-services") version "4.4.4" apply false
}

tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}
