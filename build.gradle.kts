plugins {
    java
}

allprojects {
    apply(plugin = "java")
    apply(plugin = "configure-jandex")

    group = "net.ximatai.muyun"
    version = "1.0-SNAPSHOT"

    java {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    repositories {
        maven { url = uri("https://mirrors.cloud.tencent.com/repository/maven") }
        maven { url = uri("https://maven.aliyun.com/repository/public") }
        maven {
            url = uri("http://192.168.3.19:8081/repository/maven-public/")
            isAllowInsecureProtocol = true
        }
        mavenCentral()
    }
}
