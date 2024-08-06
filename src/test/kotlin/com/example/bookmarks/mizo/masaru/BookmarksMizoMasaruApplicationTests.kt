package com.example.bookmarks.mizo.masaru

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import

@SpringBootTest
@Import(PostgresqlTestContainerConfiguration::class)
class BookmarksMizoMasaruApplicationTests {

    @Test
    fun contextLoads() {
    }
}
