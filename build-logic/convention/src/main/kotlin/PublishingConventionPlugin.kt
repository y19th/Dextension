import com.y19th.dextension.defaultPomConfig
import com.y19th.dextension.defaultSignatureConfig
import org.gradle.api.Plugin
import org.gradle.api.Project

class PublishingConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            pluginManager.apply("maven-publish")
            pluginManager.apply("signing")

            /*
                        configure<NexusPublishExtension> {
                            repositories {
                                sonatype {
                                    nexusUrl.set(URI.create("https://s01.oss.sonatype.org/service/local/"))
                                    snapshotRepositoryUrl.set(URI.create("https://s01.oss.sonatype.org/content/repositories/snapshots/"))
                                    username.set(project.findProperty("ossrhUsername") as? String)
                                    password.set(project.findProperty("ossrhPassword") as? String)
                                }
                            }
                        }
            */

            defaultPomConfig()
            defaultSignatureConfig()
        }
    }
}