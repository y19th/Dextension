plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.maven.publish.vannitech)
    id("multiplatform-publish-setup")
    id("com.y19th.convention.mavenPublish")
}

android.namespace = "com.y19th.dextension.compose"

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)

                api(libs.decompose.jetbrains)
                api(projects.dextensionCore)
            }
        }
    }
}

mavenPublishing {
    publishToMavenCentral()
    signAllPublications()
}
