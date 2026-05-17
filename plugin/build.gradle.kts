import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    id("buildlogic.java-conventions")
    id("com.gradleup.shadow")
}

dependencies {
    implementation(project(":KitUtil"))
    compileOnly(libs.app.ashcon.sportpaper)
    compileOnly(libs.tc.oc.pgm.core)
    compileOnly(libs.it.unimi.dsi.fastutil)
    compileOnly(libs.com.google.guava)
    compileOnly(libs.com.google.code.gson)
    compileOnly(libs.org.apache.commons.commons.lang3)
}

tasks.named<ShadowJar>("shadowJar") {
    archiveFileName = "KitRecommender.jar"
    archiveClassifier.set("")
    destinationDirectory = rootProject.projectDir.resolve("build/libs")

    minimize()
    dependencies {
        exclude(dependency("org.jetbrains:annotations"))
    }

    exclude("META-INF/**")
}

tasks {
    processResources {
        val name = project.name
        val description = project.description
        val version = project.version.toString()
        val commitHash = project.latestCommitHash()

        filesMatching(listOf("plugin.yml")) {
            expand(
                mapOf(
                    "name" to name,
                    "description" to description,
                    "mainClass" to "me.pablete1234.kit.recommender.KitRecommender",
                    "version" to version,
                    "apiVersion" to "1.21.11",
                    "commitHash" to commitHash,
                    "url" to "https://github.com/Pablete1234/KitRecommender"
                )
            )
        }
    }

    named("jar") {
        enabled = false
    }

    named("build") {
        dependsOn(shadowJar)
    }
}
