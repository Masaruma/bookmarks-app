package com.example.bookmarks.mizo.masaru

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BookmarkController {

    @GetMapping("/api/v1/bookmarks")
    fun getAllBookmarks(): List<Bookmark> {
        return listOf(
            Bookmark(1, "My First Bookmark", "www.example.com"),
            Bookmark(2, "Spring Boot Overview", "www.spring-boot.com")
        )
    }
}
