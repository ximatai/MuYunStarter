plugins {
    java
    id("org.kordamp.gradle.jandex") version "2.1.0"
}

allprojects {
    apply {
        plugin("java")
        plugin("org.kordamp.gradle.jandex")
    }

    group = "net.ximatai.muyun.starter"
    version = "1.0-SNAPSHOT"

    java {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    repositories {
        mavenLocal()
//        maven { url = uri("https://mirrors.cloud.tencent.com/repository/maven") }
//        maven { url = uri("https://maven.aliyun.com/repository/public") }
        mavenCentral()
    }

    configurations.all {
        resolutionStrategy.cacheChangingModulesFor(0, "seconds")
    }

    tasks.withType<Test> {
        maxHeapSize = "2g"
    }
}
