plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("co.touchlab.skie")
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
            export("io.monkeypatch:mobk-core-iosx64:0.0.11")
        }


    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api("io.monkeypatch:mobk-core:0.0.11")
                api("io.monkeypatch:mobk-viewmodel:0.0.11")
                api("io.insert-koin:koin-core:3.5.0")
                implementation("io.ktor:ktor-client-core:2.3.4")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
                implementation("co.touchlab.skie:configuration-annotations:0.5.0")
            }
        }
        val androidMain by getting {
            dependencies {
                api("io.insert-koin:koin-android:3.5.0")
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