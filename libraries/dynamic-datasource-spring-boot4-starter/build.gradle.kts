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
plugins {
  id("io.github.mymx2.module.java")
  id("io.github.mymx2.feature.publish-vanniktech")
}

val boot4Dependencies: MinimalExternalModuleDependency = libs.springBootDependencies4.get()

configurations.configureEach { resolutionStrategy { force(boot4Dependencies) } }

dependencies {
  api(project(":dynamic-datasource-spring-boot-common"))
  // compileOnly("com.alibaba:druid-spring-boot-4-starter:1.2.28-SNAPSHOT")
  compileOnly("com.zaxxer:HikariCP")
  compileOnly("org.springframework.boot:spring-boot-jdbc")
  compileOnly("org.springframework.boot:spring-boot-starter-actuator")
  compileOnly("org.springframework.boot:spring-boot-starter-web")
}

dependencies {
  testImplementation(project(":dynamic-datasource-test-common"))
  testImplementation(depLibs.h2)
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("org.springframework.boot:spring-boot-starter-web")
  testImplementation("org.springframework.boot:spring-boot-starter-jdbc")
  testImplementation(depLibs.druid)
  testImplementation("com.zaxxer:HikariCP")
}
