plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }


    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api("io.insert-koin:koin-core:3.5.0")
                implementation("io.ktor:ktor-client-core:2.3.4")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
                api("dev.icerock.moko:mvvm-core:0.16.1")
                implementation("org.orbit-mvi:orbit-core:4.6.1")
                implementation("org.orbit-mvi:orbit-viewmodel:4.6.1")
            }
        }
        val androidMain by getting {
            dependencies {
                api("io.insert-koin:koin-android:3.5.0")
                api("org.orbit-mvi:orbit-compose:4.6.1")
                implementation("io.ktor:ktor-client-okhttp:2.3.4")
            }
        }
        val iosMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-darwin:2.3.4")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = "com.example.kadoc"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}