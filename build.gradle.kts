plugins {
	id("org.springframework.boot") version "3.3.2"
	id("io.spring.dependency-management") version "1.1.6"
	kotlin("plugin.jpa") version "1.9.24"
	kotlin("jvm") version "1.9.24"
	kotlin("plugin.spring") version "1.9.24"
	id("com.diffplug.spotless") version "6.25.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.flywaydb:flyway-core")
	implementation("org.flywaydb:flyway-database-postgresql")
	runtimeOnly("com.h2database:h2")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	testImplementation("io.mockk:mockk:1.13.12")
}

// It failed because we already have some tables (bookmark) created in the database
// 1. You manually clean the database and have it as and empty - Drop all the DB tables
//	1.1 To delete all the existing tables/ indexes/  - Drop
//		Easiest way to have a fresh DB
// 1.2. you need to remove the schema.sql and put it in the flyway migration
// 2. You tell flyway, ok you can continue from here and leave the existing table as it is -- Advanced


kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.register("hello"){
	println("Hello World")
}
tasks.register("morning"){
	dependsOn("hello")
	println("Morning")
}


configure<com.diffplug.gradle.spotless.SpotlessExtension> {
	kotlin {
		ktfmt()
		ktlint()
			.editorConfigOverride(
				mapOf(
					"ktlint_standard_no-wildcard-imports" to "disabled"
				)
			)
	}
}

// TO copy the build code from frontend to backend


tasks.jar {  // build-in tasks for creating the JAR file
	dependsOn("copyFrontend")
}

tasks.register("buildFrontend") {
	// npm run build
}

tasks.register("copyFrontend"){
	dependsOn("buildFrontend")
	// copy the build folder from frontend to src/main/resources/static of backend
}

