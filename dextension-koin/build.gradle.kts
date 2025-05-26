import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.maven.publish.vannitech)
    id("multiplatform-publish-setup")
    id("com.y19th.convention.mavenPublish")
}

android.namespace = "com.y19th.dextension.koin"

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(projects.dextensionCompose)
                api(libs.koin.core)
            }
        }
    }
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()
}
