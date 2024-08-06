package com.example.bookmarks.mizo.masaru

import org.junit.jupiter.api.Test
import org.springframework.web.client.RestClient
import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

// When you start TestContainers - it has it own container called `ryuk` is used to manage the lifecycle of the other container

@Testcontainers
class TestContainer {

//    1 container per each test
//    @Container
//    val httpbinContainer = GenericContainer("kennethreitz/httpbin")

    // 1 container per test file
    companion object {
        @Container
        @JvmStatic
        val container = GenericContainer("kennethreitz/httpbin")
            .withExposedPorts(80) // container port

        @Container
        @JvmStatic
        val postgresqlContainer = PostgreSQLContainer("postgres:16.3") // No exposed ports
    }

    private val restClient = RestClient.create()

    @Test fun test1() {
        // The recommendation from Spring team is to use the new RestClient. RestTemplate will not be updated for new features

        println("Container is running on localhost port: ${container.firstMappedPort}")

        var body = restClient.get()
            .uri("http://${container.host}:${container.firstMappedPort}/uuid")
            .retrieve()
            .body(String::class.java)

        println(body)

        println(postgresqlContainer.jdbcUrl)
    }
}
