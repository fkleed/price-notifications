plugins {
    id(BuildConstants.KOTLIN_CONVENTIONS_PLUGIN)
    alias(libs.plugins.docker.run)
    alias(libs.plugins.liquibase.gradle)
}

dependencies {
    liquibaseRuntime(libs.bundles.liquibase)
}

val pgPort = 6542
val pgUser = "user"
val pgPassword = "password"
val pgDb = "db"

dockerRun {
    name = "pg-gradle"
    image = "postgres:17.4-alpine3.21"
    ports("$pgPort:5432")
    clean = true
    env(mapOf("POSTGRES_USER" to pgUser, "POSTGRES_PASSWORD" to pgPassword, "POSTGRES_DB" to pgDb))
    network = "pn-db-network"
}

val resourceDir = layout.projectDirectory.dir("src/main/resources")

liquibase {
    val dbUrl = "jdbc:postgresql://localhost:$pgPort/$pgDb"
    activities.register("main") {
        this.arguments = mapOf(
            "logLevel" to "info",
            "changeLogFile" to resourceDir.file("changelog.groovy").asFile.path,
            "url" to dbUrl,
            "username" to pgUser,
            "password" to pgPassword
        )
    }
    runList = "main"
}
