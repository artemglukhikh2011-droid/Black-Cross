plugins {
    kotlin("jvm") version "2.4.10"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

sourceSets {
    main {
        kotlin.srcDir("src")
        resources.srcDir("resources")
    }
    test {
        kotlin.srcDir("test")
        resources.srcDir("testResources")
    }
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.14.0")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

// specify the main class (otherwise "gradlew.bat run" will fail)
application {
    mainClass.set("MainKt")
}

// configure our jar to be runnable: main class, bundle libraries
// e.g. "java -jar build/libs/Black-Cross-1.0-SNAPSHOT.jar"
tasks.jar {
    manifest {
        attributes["Main-Class"] = "MainKt"
    }

    // includes external libraries (like Kotlin runtime) into the JAR
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
