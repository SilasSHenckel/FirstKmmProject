plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin ("plugin.serialization") version "1.8.21"
    id("org.jetbrains.compose") version "1.5.0"
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
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
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
                implementation("io.insert-koin:koin-core:3.2.0")
                implementation("io.insert-koin:koin-test:3.2.0")

                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)

                implementation("dev.gitlive:firebase-firestore:1.8.1")
                implementation("dev.gitlive:firebase-common:1.8.1")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
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
    namespace = "com.example.myfirstappkotlinmultiplataform"
    compileSdk = 34
    defaultConfig {
        minSdk = 27
    }
}