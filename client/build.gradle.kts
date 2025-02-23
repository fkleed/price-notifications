plugins {
    id(BuildConstants.KOTLIN_CONVENTIONS_PLUGIN)
    alias(libs.plugins.openapi.generator)
}

dependencies {
    compileOnly(libs.spring.boot.starter.webflux)
    compileOnly(libs.jackson.module.kotlin)
}

version = "1.0"

val apiSpecDir = layout.projectDirectory.dir("src/main/resources/api")

openApiGenerate {
    inputSpec.set(apiSpecDir.file("posts.yml").asFile.path)
    generatorName.set("kotlin")
    library.set("jvm-spring-webclient")
    configOptions.set(
        mutableMapOf(
            "useSpringBoot3" to "true",
        )
    )
    additionalProperties.set(
        mutableMapOf(
            "serializationLibrary" to "jackson"
        )
    )
    outputDir.set(layout.buildDirectory.dir("generated").get().asFile.path)
    packageName.set("${BuildConstants.BASE_PACKAGE_NAME}.client")
    generateApiTests.set(false)
    generateModelTests.set(false)
}

sourceSets {
    main {
        kotlin {
            srcDir(layout.buildDirectory.dir("generated/src/main/kotlin").get())
        }
    }
}

tasks.compileKotlin{
    dependsOn("openApiGenerate")
}