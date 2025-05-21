plugins {
    id(BuildConstants.KOTLIN_CONVENTIONS_PLUGIN)
    alias(libs.plugins.docker.run)
//    alias(libs.plugins.liquibase.gradle.plugin)
}

dependencies {
    runtimeOnly(libs.bundles)
}


val pgPort = 6542
val pgsUser = "user"
val pgPassword = "password"
val pgDb = "db"

dockerRun {
    name = "pg-gradle"
    image = "postgres:17.4-alpine3.21"
    ports("$pgPort:5432")
    clean = true
    env(mapOf("POSTGRES_USER" to pgsUser, "POSTGRES_PASSWORD" to pgPassword, "POSTGRES_DB" to pgDb))
}