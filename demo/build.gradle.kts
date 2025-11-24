plugins {
    java
    `java-library`
}

dependencies {
    api(libs.muyun.core)
    implementation(libs.muyun.database.jdbi.plugin)
//    api(libs.caffeine)
}
