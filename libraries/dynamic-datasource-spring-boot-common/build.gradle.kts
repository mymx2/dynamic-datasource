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

dependencies {
  api(project(":dynamic-datasource-spring"))
  api("org.aspectj:aspectjweaver")
  api("org.springframework.boot:spring-boot-autoconfigure")
  api("org.springframework:spring-aop")
  api(depLibs.oracleSpringBootStarterUcp)
  api(depLibs.ucp)
  compileOnly(depLibs.beecp)
  compileOnly(depLibs.c3p0)
  compileOnly(depLibs.commonsDbcp2)
  compileOnly(depLibs.druid)
  compileOnly(depLibs.hikariCPJava7)
  compileOnly(depLibs.mybatisPlus)
  compileOnly(depLibs.transactionsJdbc)
}
