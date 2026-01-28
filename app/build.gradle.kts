import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
    id("org.jetbrains.kotlin.plugin.compose") // Required for Kotlin 2.x Compose builds
    id("com.google.gms.google-services")
}

android {
    namespace = "com.karma.sureshtrb.enKarma"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.karma.sureshtrb.enKarma"
        minSdk = 24
        targetSdk = 36
        versionCode = 55
        versionName = "1.0.55"
    }
    packaging {
        jniLibs {
            useLegacyPackaging = false
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    buildFeatures {
        compose = true
        viewBinding = true
        dataBinding = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
        freeCompilerArgs.addAll(
            listOf("-Xjsr305=strict")
        )
    }
    jvmToolchain(17)
}

composeCompiler {
    reportsDestination = layout.buildDirectory.dir("compose_compiler_reports")
    stabilityConfigurationFile =
        rootProject.layout.projectDirectory.file("stability_config.conf")
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:2.2.21")

    // AndroidX core libraries
    implementation("androidx.appcompat:appcompat:1.7.1")
    implementation("androidx.core:core-ktx:1.17.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.1")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.preference:preference-ktx:1.2.1")
    implementation("androidx.recyclerview:recyclerview:1.4.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.9.4")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.9.4")
    implementation("com.google.android.material:material:1.13.0")

    // Firebase BoM keeps all SDKs in sync
    implementation(platform("com.google.firebase:firebase-bom:34.4.0"))
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-database")
    implementation("com.google.firebase:firebase-firestore")
    implementation("com.google.firebase:firebase-analytics")

    // Utility and networking
    implementation("org.jsoup:jsoup:1.21.2")
    // REMOVED: KAndroid dependency - using standard Android TextWatcher instead
    implementation("com.pusher:pusher-java-client:2.4.4")
    implementation("com.loopj.android:android-async-http:1.4.11")
    implementation("com.google.code.gson:gson:2.13.2")
    implementation("com.itextpdf:itextg:5.5.10")

    // Jetpack Compose (October 2025 BoM)
    implementation(platform("androidx.compose:compose-bom:2025.10.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material:material")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.activity:activity-compose:1.11.0")

    implementation("com.github.parse-community.Parse-SDK-Android:parse:4.3.0")
    // Annotation processors
    implementation("com.github.bumptech.glide:glide:5.0.5")
    kapt("com.github.bumptech.glide:compiler:5.0.5")
}
