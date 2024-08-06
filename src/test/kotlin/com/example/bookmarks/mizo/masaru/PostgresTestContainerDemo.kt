package com.example.bookmarks.mizo.masaru

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import

@SpringBootTest
@Import(PostgresqlTestContainerConfiguration::class)
class PostgresTestContainerDemo {

    @Autowired
    lateinit var bookmarkRepository: BookmarkRepository

    @Test
    fun `connect to db`() {
        val bookmark = Bookmark(title = "sample", url = "sample.org")
        println(bookmarkRepository.save(bookmark))
    }
}
