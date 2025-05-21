import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.maven.publish.vannitech)
    id("multiplatform-publish-setup")
}

android.namespace = "com.y19th.dextension.koin"

kotlin {
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(projects.dextensionCompose)
                implementation(libs.koin.core)
            }
        }
    }
}

publishing.publications
    .withType<MavenPublication>()
    .configureEach {
        groupId = "io.github.y19th"
        version = "1.0.0"

        pom {
            name = "Dextension"
            description = "Decompose extensions"
            url = "https://github.com/y19th/Dextension"

            licenses {
                license {
                    name = "The Apache License, Version 2.0"
                    url = "https://github.com/y19th/Dextension/blob/master/LICENSE"
                }
            }

            developers {
                developer {
                    id = "y19th"
                    name = "Oleg Agapchenko"
                    email = "whenmistdisappear@gmail.com"
                }
            }

            scm {
                url = "https://github.com/y19th/Dextension"
            }
        }
    }

mavenPublishing {
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL, automaticRelease = false)
    signAllPublications()
}
