package com.example.bookmarks.mizo.masaru

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpStatusCode
import org.springframework.http.MediaType
import org.springframework.web.client.RestClient
import org.springframework.web.client.body

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookmarkIntegrationTest {
    val defaultClient = RestClient.create()

    @LocalServerPort
    val port: Int = 0

    @Autowired
    lateinit var bookmarkRepository: BookmarkRepository

    @BeforeEach
    fun setup() {
        bookmarkRepository.deleteAll()
    }

    @Test
    fun `should save bookmark to database`() {
        val bookmarkResponse =
            defaultClient.post()
                .uri("http://localhost:$port/api/v1/bookmarks")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Bookmark(title = "test1", url = "www.test1.com"))
                .retrieve()
                .body<Bookmark>()

        assertEquals(bookmarkResponse?.title, "test1")
        assertEquals(bookmarkResponse?.url, "www.test1.com")

        val bookmarks = bookmarkRepository.findAll()

        assertEquals(bookmarks.size, 1)
        assertEquals(bookmarks[0].title, "test1")
        assertEquals(bookmarks[0].url, "www.test1.com")
    }

    @Test
    fun `should delete bookmark from database `() {
        val savedBookmark = bookmarkRepository.save(Bookmark(title = "test1", url = "www.test1.com"))
        val entity = defaultClient.delete()
            .uri("http://localhost:$port/api/v1/bookmarks/${savedBookmark.id}")
            .retrieve()
            .toEntity(Unit::class.java)

        val bookmarks = bookmarkRepository.findAll()

        assertEquals(entity.statusCode, HttpStatusCode.valueOf(204))
        assertEquals(bookmarks.size, 0)
    }

    @Test
    fun `should get all bookmarks from database `() {
        val bookmarks = bookmarkRepository.saveAll(
            listOf(
                Bookmark(title = "test1", url = "www.test1.com"),
                Bookmark(title = "test2", url = "www.test2.com"),
            ),
        )

        val allBookmarks = defaultClient.get()
            .uri("http://localhost:$port/api/v1/bookmarks")
            .retrieve()
            .toEntity(Array<Bookmark>::class.java)

        assertEquals(allBookmarks.statusCode, HttpStatusCode.valueOf(200))
        assertEquals(allBookmarks.body?.size, bookmarks.size)
        assertEquals(allBookmarks.body?.get(0), bookmarks[0])
        assertEquals(allBookmarks.body?.get(1), bookmarks.get(1))
    }

    @Test
    fun `should get a single bookmark from database`() {
        val bookmark = bookmarkRepository.save(Bookmark(title = "test1", url = "www.test1.com"))

        val getBookmark = defaultClient.get()
            .uri("http://localhost:$port/api/v1/bookmarks/${bookmark.id}")
            .retrieve()
            .toEntity(Bookmark::class.java)

        assertEquals(getBookmark.statusCode, HttpStatusCode.valueOf(200))
        assertEquals(getBookmark.body, bookmark)
    }
}
