rootProject.name = "price-notifications"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("spring-boot", "3.4.2")
            version("disruptor", "4.0.0")

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

            bundle("spring-boot", listOf("spring-boot-starter-webflux", "spring-boot-starter-log4j2"))
        }
    }
}