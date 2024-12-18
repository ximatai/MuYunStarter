plugins {
    java
    alias(libs.plugins.quarkus)
}

dependencies {
    implementation(enforcedPlatform(libs.quarkus.platform.bom))
    implementation("io.quarkus:quarkus-config-yaml")

    implementation(libs.muyun.core)
    implementation(libs.muyun.database.std)
    implementation(libs.muyun.proxy)
//    implementation(libs.muyun.fileserver)
//    implementation(libs.muyun.platform)
//    implementation(libs.muyun.runtime.session)
//    implementation(libs.muyun.log)
    implementation(project(":demo"))

    testImplementation("io.quarkus:quarkus-junit5")
    testImplementation("io.rest-assured:rest-assured")

    testImplementation("io.quarkus:quarkus-agroal")
    testImplementation("io.quarkus:quarkus-jdbc-postgresql")
    testImplementation(libs.testcontainers.postgresql)
}

tasks.test {
    useJUnitPlatform()
}

tasks.named("quarkusDependenciesBuild") {
    mustRunAfter(tasks.named("jandex"))
}
