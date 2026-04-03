import com.y19th.dextension.defaultPomConfig
import com.y19th.dextension.defaultSignatureConfig
import org.gradle.api.Plugin
import org.gradle.api.Project

class PublishingConventionPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {
            pluginManager.apply("maven-publish")
            pluginManager.apply("signing")

            defaultPomConfig()
            defaultSignatureConfig()
        }
    }
}