import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinMultiplatform)
    `maven-publish`
}

kotlin {
    jvm()

    androidTarget {
        publishLibraryVariants("release")
        withSourcesJar(true)

        compilations.all {
            compileTaskProvider {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_11)
                }
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
        macosX64(),
        macosArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "DextensionCore"
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(libs.decompose)
                api(libs.decompose.coroutine)
                api(libs.koin.core)
                api(libs.kermit)
                api(libs.kotlinx.coroutines.core)
            }
        }
    }
}

android {
    namespace = "com.y19th.dextension.core"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildTypes {
        release { }
        debug {  }
    }
}

publishing.publications
    .withType<MavenPublication>()
    .configureEach {
        groupId = "com.y19th.dextension"
        version = "0.0.1"

        pom {
            name.set("Dextension")

            developers {
                developer {
                    id.set("y19th")
                    name.set("Oleg Agapchenko")
                    email.set("whenmistdisappear@gmail.com")
                }
            }
        }
    }

