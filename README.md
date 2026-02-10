<p align="center">
  <a href="https://central.sonatype.com/artifact/com.baomidou/dynamic-datasource-spring-boot4-starter" target="_blank"><img alt="maven-central-version"
    src="https://img.shields.io/maven-central/v/com.baomidou/dynamic-datasource-spring-boot4-starter?strategy=latestProperty"/></a>
  <a href="https://central.sonatype.com/repository/maven-snapshots/io/github/baomidou/dynamic-datasource-spring-boot4-starter/maven-metadata.xml" target="_blank"><img alt="maven-metadata-url"
    src="https://img.shields.io/maven-metadata/v?label=snapshot&metadataUrl=https://central.sonatype.com/repository/maven-snapshots/io/github/baomidou/dynamic-datasource-spring-boot4-starter/maven-metadata.xml&strategy=latestProperty"/></a>
  <a href="https://github.com/baomidou/dynamic-datasource-spring-boot4-starter/releases" target="_blank"><img alt="git-hub-release"
    src="https://img.shields.io/github/v/release/baomidou/dynamic-datasource-spring-boot4-starter"/></a>
</p>

<p align="center">
  <a href="https://app.codacy.com/gh/baomidou/dynamic-datasource/dashboard" target="_blank"><img alt="codacy-grade"
    src="https://img.shields.io/codacy/grade/64109c17cc5c4ea090db54cb773621fe"/></a>
  <a href="https://app.codecov.io/gh/baomidou/dynamic-datasource" target="_blank"><img alt="codecov"
    src="https://img.shields.io/codecov/c/github/baomidou/dynamic-datasource"/></a>
  <a href="https://github.com/baomidou/dynamic-datasource/actions/workflows/publish-release.yml" target="_blank"><img alt="git-hub-actions-workflow-status"
    src="https://img.shields.io/github/actions/workflow/status/baomidou/dynamic-datasource/publish-release.yml"/></a>
</p>

<p align="center">
  <a href="https://jdk.java.net" target="_blank"><img alt="JDK"
    src="https://img.shields.io/badge/dynamic/toml?logo=openjdk&label=JDK&color=brightgreen&url=https%3A%2F%2Fraw.githubusercontent.com%2Fmymx2%2Fmica-auto-ksp%2Fmain%2Fgradle%2Flibs.versions.toml&query=%24.versions.jdk&suffix=%2B"/></a>
  <a href="https://gradle.org" target="_blank"><img alt="GRADLE"
    src="https://img.shields.io/badge/dynamic/toml?logo=gradle&label=Gradle&color=209BC4&url=https%3A%2F%2Fraw.githubusercontent.com%2Fmymx2%2Fmica-auto-ksp%2Fmain%2Fgradle%2Flibs.versions.toml&query=%24.versions.gradle"/></a>
  <a href="https://kotlinlang.org/docs/getting-started.html" target="_blank"><img alt="KOTLIN"
    src="https://img.shields.io/badge/dynamic/toml?logo=kotlin&label=Kotlin&color=7f52ff&url=https%3A%2F%2Fraw.githubusercontent.com%2Fmymx2%2Fmica-auto-ksp%2Fmain%2Fgradle%2Flibs.versions.toml&query=%24.versions.kotlin"/></a>
  <a href="https://nodejs.org/en/download" target="_blank"><img alt="NODE"
    src="https://img.shields.io/badge/dynamic/toml?logo=nodedotjs&label=Node&color=5FA04E&url=https%3A%2F%2Fraw.githubusercontent.com%2Fmymx2%2Fmica-auto-ksp%2Fmain%2Fgradle%2Flibs.versions.toml&query=%24.versions.node"/></a>
</p>

<p align="center">
  <a href="https://github.com/baomidou" target="_blank"><img alt="baomidou"
      src="https://img.shields.io/badge/author-🤖_baomidou-E07A28?logo=github"/></a>
  <a href="https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax" target="_blank"><img alt="Markdown"
      src="https://img.shields.io/badge/md-GFM-0070C0?logo=Markdown"/></a>
  <a href="https://github.com/baomidou/dynamic-datasource" target="_blank"><img alt="git-hub-license"
        src="https://img.shields.io/github/license/baomidou/dynamic-datasource"/></a>
  <a href="https://deepwiki.com/baomidou/dynamic-datasource" target="_blank"><img alt="Ask DeepWiki"
      src="https://deepwiki.com/badge.svg"/></a>
</p>

---

> 快速集成多数据源，支持多库、多主从、读写分离和动态切换。

---

## 🌟 核心特性

- 多数据源动态切换（组名 + 单库）
- 默认数据源回退，支持懒加载
- 支持 `@DS` 注解切换数据源
- 支持 Druid / HikariCP / MyBatis / Spring Transaction

---

## 📦 版本选择

请根据 **Spring Boot** 与 **JDK** 版本选择对应的 Starter：

| Spring Boot 版本 | JDK 要求 | Starter 模块                              | Latest Version                                                                                                                  |
| ---------------- | -------- | ----------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------- |
| 1.5.x ~ 2.x.x    | JDK 8+   | `dynamic-datasource-spring-boot-starter`  | ![Version](https://img.shields.io/maven-central/v/com.baomidou/dynamic-datasource-spring-boot-starter?strategy=latestProperty)  |
| 3.x.x            | JDK 17+  | `dynamic-datasource-spring-boot3-starter` | ![Version](https://img.shields.io/maven-central/v/com.baomidou/dynamic-datasource-spring-boot3-starter?strategy=latestProperty) |
| 4.x.x            | JDK 17+  | `dynamic-datasource-spring-boot4-starter` | ![Version](https://img.shields.io/maven-central/v/com.baomidou/dynamic-datasource-spring-boot4-starter?strategy=latestProperty) |

> ⚠️ **注意**
>
> - Spring Boot 3+ 基于 Jakarta EE，最低要求 **JDK 17**
> - 老项目（Boot 2.x）请使用 1.x～3.x 对应版本

---

## 📦 快速上手

### 1️⃣ 添加依赖

**Gradle**

```gradle
implementation("com.baomidou:dynamic-datasource-spring-boot4-starter:latest.release")
```

**Maven**

```xml

<dependency>
  <groupId>com.baomidou</groupId>
  <artifactId>dynamic-datasource-spring-boot4-starter</artifactId>
  <version>最新版本</version>
</dependency>
```

---

### 2️⃣ 配置数据源

```yaml
spring:
  datasource:
    dynamic:
      primary: master
      datasource:
        master:
          url: jdbc:mysql://localhost:3306/master
          username: root
          password: 123456
        slave_1:
          url: jdbc:mysql://localhost:3306/slave1
          username: root
          password: 123456
```

- `primary`：默认数据源
- `slave_1` 自动归入 `slave` 组

---

### 3️⃣ 使用 `@DS` 切换数据源

```java

@Service
@DS("slave")
public class UserService {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public List<?> listAll() {
    return jdbcTemplate.queryForList("SELECT * FROM user");
  }

  @DS("slave_1")
  public List<?> listFromSlave1() {
    return jdbcTemplate.queryForList("SELECT * FROM user WHERE age > 10");
  }
}
```

**切换规则**

| 注解位置 | 数据源生效顺序 |
| -------- | -------------- |
| 方法     | 优先           |
| 类       | 次优           |
| 无 `@DS` | 默认数据源     |

---

### 4️⃣ 最快体验

1. 配置 `master` + `slave` 数据源
2. 在 Service/Repository 上加 `@DS`
3. 启动 Spring Boot 应用，即可按组名或数据源名切换

---

## 📚 文档

- 官方文档：[https://www.kancloud.cn/tracy5546/dynamic-datasource/2264611](https://www.kancloud.cn/tracy5546/dynamic-datasource/2264611)
- GitHub：[https://github.com/baomidou/dynamic-datasource](https://github.com/baomidou/dynamic-datasource)
