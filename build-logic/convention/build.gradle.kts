plugins {
    `kotlin-dsl`
    `maven-publish`
}

dependencies {
    implementation(libs.compose.gradle.plugin)
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.kotlin.compose.gradle.plugin)
    implementation(libs.android.tools.build.gradle.plugin)
    implementation("io.github.gradle-nexus:publish-plugin:1.3.0")
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        register("dextensionPublish") {
            id = "com.y19th.convention.mavenPublish"
            implementationClass = "PublishingConventionPlugin"
        }
    }
}