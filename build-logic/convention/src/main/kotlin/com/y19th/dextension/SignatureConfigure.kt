package com.y19th.dextension

import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.gradle.plugins.signing.SigningExtension

fun Project.defaultSignatureConfig() {
        configure<SigningExtension> {
            setGradleProperty("signing.keyId")
            setGradleProperty("signing.password")
            setGradleProperty("signing.secretKeyRingFile")
            setGradleProperty("mavenCentralUsername")
            setGradleProperty("mavenCentralPassword")

            sign(extensions.getByType<PublishingExtension>().publications)
        }
}

private fun Project.setGradleProperty(key: String) {
    setProperty(key, retrieveLocal(key))
}

private fun Project.retrieveLocal(key: String): String {
    return gradleLocalProperties(rootDir, providers).getProperty(key)
        ?: throw IllegalStateException("$key is not provided")
}