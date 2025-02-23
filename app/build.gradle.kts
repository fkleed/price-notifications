plugins {
    id(BuildConstants.KOTLIN_CONVENTIONS_PLUGIN)
    alias(libs.plugins.kotlin.plugin.spring)
    alias(libs.plugins.springframework.boot)
}

dependencies {

    configurations.all {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
    }

//    implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
    implementation(libs.bundles.spring.boot)
    implementation(libs.disruptor)
    implementation(libs.jackson.module.kotlin)
    implementation(project(":client"))


//    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
//    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
//    implementation("org.jetbrains.kotlin:kotlin-reflect")
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")


//    testImplementation("org.springframework.boot:spring-boot-starter-test")
//    testImplementation("io.projectreactor:reactor-test")
//    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
//    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test")
//    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

version = "1.0"