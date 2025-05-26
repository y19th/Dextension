package com.y19th.dextension

import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType


fun Project.defaultPomConfig() {
    afterEvaluate {
        configure<PublishingExtension> {
            publications.withType<MavenPublication> {
                pom {
                    name.set("Dextension")
                    description.set("Decompose extensions")
                    url.set("https://github.com/y19th/Dextension")
                    version = project.findProperty("current.pom.version")?.toString()


                    licenses {
                        license {
                            name.set("The Apache License, Version 2.0")
                            url.set("https://github.com/y19th/Dextension/blob/master/LICENSE")
                        }
                    }

                    developers {
                        developer {
                            id.set("y19th")
                            name.set("Oleg Agapchenko")
                            email.set("whenmistdisappear@gmail.com")
                        }
                    }

                    scm {
                        url.set("https://github.com/y19th/Dextension")
                    }
                }
            }
        }
    }

}