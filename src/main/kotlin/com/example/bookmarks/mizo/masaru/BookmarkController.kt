package com.example.bookmarks.mizo.masaru

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class BookmarkController(val bookmarkService: BookmarkService) {

    @GetMapping("/api/v1/bookmarks")
    fun getAllBookmarks(): List<Bookmark> {
        return listOf(
            Bookmark(1, "My First Bookmark", "www.example.com"),
            Bookmark(2, "Spring Boot Overview", "www.spring-boot.com")
        )
    }

    @GetMapping("/api/v1/bookmarks/{id}")
    fun  getSingleBookmark(@PathVariable("id") id: Long):Bookmark{
        return Bookmark(100,"My First Bookmark", "www.example.com")
    }
}
