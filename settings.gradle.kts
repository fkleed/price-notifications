rootProject.name = "price-notifications"

include("app", "client")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {

            // plugins
            version("kotlin-plugin-spring", "1.9.25")
            version("springframework-boot", "3.4.2")
            version("openapi-generator", "7.11.0")

            plugin("kotlin-plugin-spring", "org.jetbrains.kotlin.plugin.spring").versionRef("kotlin-plugin-spring")
            plugin("springframework-boot", "org.springframework.boot").versionRef("springframework-boot")
            plugin("openapi-generator", "org.openapi.generator").versionRef("openapi-generator")

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
        }
    }
}