plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.25"
    id("org.jetbrains.kotlin.plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.4.2"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
}

dependencies {

    configurations.all {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
    }

//    implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
    implementation(libs.bundles.spring.boot)
    implementation(libs.disruptor)


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

kotlin {
    compilerOptions {
        freeCompilerArgs.add("-Xjsr305=strict")
    }
}