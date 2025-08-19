plugins {
    kotlin("jvm") version "1.6.10"
}

group = "co.kr"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
// jvmToolchain(11) 대신 이 부분을 추가해주세요.
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
    kotlinOptions {
        jvmTarget = "11" // 여기에 원하는 JVM 버전("8", "11", "17" 등)을 문자열로 지정합니다.
    }
}