plugins {
    java
    `java-library`
}

dependencies {
    api(libs.muyun.core)
    api(libs.muyun.database.std)
    api("io.quarkus:quarkus-scheduler")

//    api(libs.caffeine)
}

configurations.all {
    resolutionStrategy.cacheChangingModulesFor(0, "seconds")
}
