plugins {
    java
    `java-library`
}

dependencies {
    api(libs.muyun.core)
    api(libs.muyun.database.std)
//    api(libs.caffeine)
    api("io.quarkus:quarkus-scheduler")

}
