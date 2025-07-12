plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.maven.publish.vannitech)
    id("multiplatform-publish-setup")
    id("com.y19th.convention.mavenPublish")
}

android.namespace = "com.y19th.dextension.extensions"

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(projects.dextensionCore)
            }
        }
    }
}

mavenPublishing {
    publishToMavenCentral()
    signAllPublications()
}
