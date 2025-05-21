rootProject.name = "price-notifications"

include("app", "client", "data")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {

            // plugins
            version("kotlin-plugin-spring", "1.9.25")
            version("springframework-boot", "3.4.2")
            version("openapi-generator", "7.11.0")
            version("docker-run", "0.36.0")
            version("liquibase-gradle", "3.0.2")

            plugin("kotlin-plugin-spring", "org.jetbrains.kotlin.plugin.spring").versionRef("kotlin-plugin-spring")
            plugin("springframework-boot", "org.springframework.boot").versionRef("springframework-boot")
            plugin("openapi-generator", "org.openapi.generator").versionRef("openapi-generator")
            plugin("docker-run", "com.palantir.docker-run").versionRef("docker-run")
            plugin("liquibase-gradle", "org.liquibase.gradle").versionRef("liquibase-gradle")

            // dependencies
            version("spring-boot", "3.4.2")
            version("disruptor", "4.0.0")
            version("kotlin-jvm-gradle-plugin", "1.9.25")
            version("jackson-module-kotlin", "2.18.2")

            library(
                "spring-boot-starter-webflux",
                "org.springframework.boot",
                "spring-boot-starter-webflux"
            ).versionRef("spring-boot")
            library(
                "spring-boot-starter-log4j2",
                "org.springframework.boot",
                "spring-boot-starter-log4j2"
            ).versionRef("spring-boot")
            library("disruptor", "com.lmax", "disruptor").versionRef("disruptor")
            library(
                "jackson-module-kotlin",
                "com.fasterxml.jackson.module",
                "jackson-module-kotlin"
            ).versionRef("jackson-module-kotlin")

            bundle("spring-boot", listOf("spring-boot-starter-webflux", "spring-boot-starter-log4j2"))

            // dependencies for liquibase plugin
            version("liquibase-core", "4.31.1")
            version("liquibase-groovy-dsl", "4.0.1")
            version("picocli", "4.7.7")
            version("postgresql", "42.1.4")

            library("liquibase-core", "org.liquibase", "liquibase-core").versionRef("liquibase-core")
            library("liquibase-groovy-dsl", "org.liquibase", "liquibase-groovy-ds").versionRef("liquibase-groovy-dsl")
            library("picocli", "info.picocli", "picocli").versionRef("picocli")
            library("postgresql", "org.postgresql", "postgresql").versionRef("postgresql")

            bundle(
                "liquibase",
                listOf("liquibase-core", "liquibase-groovy-dsl", "picocli", "postgresql")
            )
        }
    }
}