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

liquibase {
    val dbUrl = "jdbc:postgresql://localhost:$pgPort/$pgDb?currentSchema=public&user=$pgUser&password=$pgPassword"
    val mainChangelog = "src/main/resources/changelog/main.yml"
    activities.register("main") {
        this.arguments = mapOf(
            "logLevel" to "info",
            "changeLogFile" to mainChangelog,
            "url" to dbUrl,
            "reference-url" to dbUrl,
            "driver" to "org.postgresql.Driver",
        )
    }
    runList = "main"
}
