/*
 * Apache-2.0
 *
 * Copyright 2026-PRESENT organization baomidou(苞米豆).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@file:Suppress("UnstableApiUsage")

import PluginHelpers.useJUnitJupiterM2
import io.github.mymx2.plugin.dyIncludeProjects
import net.ltgt.gradle.errorprone.errorprone
import net.ltgt.gradle.nullaway.nullaway

plugins {
  id("io.github.mymx2.build") version "1.3.9"
  id("io.github.mymx2.build.feature.catalogs") version "1.3.9"
  id("io.github.mymx2.plugin.dy.example.settings") version "1.3.9"
  id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "dynamic-datasource"

dyIncludeProjects(
  mapOf(
    ":dynamic-datasource-creator" to "libraries/dynamic-datasource-creator",
    ":dynamic-datasource-spring" to "libraries/dynamic-datasource-spring",
    ":dynamic-datasource-spring-boot-common" to "libraries/dynamic-datasource-spring-boot-common",
    ":dynamic-datasource-spring-boot-starter" to "libraries/dynamic-datasource-spring-boot-starter",
    ":dynamic-datasource-spring-boot3-starter" to
      "libraries/dynamic-datasource-spring-boot3-starter",
    ":dynamic-datasource-spring-boot4-starter" to
      "libraries/dynamic-datasource-spring-boot4-starter",
  ) + mapOf(":dynamic-datasource-test-common" to "libraries/dynamic-datasource-test-common")
)

gradle.lifecycle.apply {
  afterProject {
    val projectPath = project.path
    val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

    if (projectPath.startsWith(":dynamic-datasource")) {
      val highBootVersion = listOf("spring-boot3", "spring-boot4").any { projectPath.contains(it) }

      // java TODO: remove
      tasks.withType<JavaCompile>().configureEach {
        options.apply {
          release = if (highBootVersion) 17 else 8
          compilerArgs.remove("-Werror")
          errorprone {
            disableAllChecks = true
            disableAllWarnings = true
            nullaway { disable() }
          }
        }
      }

      // format TODO: remove
      tasks.named { it.startsWith("spotlessJava") }.configureEach { enabled = false }

      // junit
      val junit = libs.findVersion("junit").get().requiredVersion
      useJUnitJupiterM2(junitBomVersion = junit)

      // dependency
      val boot =
        if (projectPath.contains("spring-boot4")) {
          val lib = libs.findLibrary("springBootDependencies4").get().get()
          val version = lib.version
          version to lib
        } else if (projectPath.contains("spring-boot3")) {
          val version = libs.findVersion("boot3").get().requiredVersion
          version to "org.springframework.boot:spring-boot-dependencies:$version"
        } else {
          val version = libs.findVersion("boot2").get().requiredVersion
          version to "org.springframework.boot:spring-boot-dependencies:$version"
        }

      dependencies { add("implementation", platform(boot.second)) }

      if (projectPath.contains("spring-boot")) {
        val processor = "org.springframework.boot:spring-boot-configuration-processor:${boot.first}"
        dependencies {
          add("compileOnly", processor)
          add("annotationProcessor", processor)
        }
      }
    }
  }
}
