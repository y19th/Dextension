import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("com.android.library")
    kotlin("multiplatform")
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

    iosX64()
    iosArm64()
    iosSimulatorArm64()
    macosX64()
    macosArm64()
}

android {
    compileSdk = 35

    defaultConfig {
        minSdk = 24
    }

}
