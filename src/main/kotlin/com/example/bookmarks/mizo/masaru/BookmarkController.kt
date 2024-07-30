package com.example.bookmarks.mizo.masaru

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BookmarkController {

    @GetMapping("/api/v1/bookmarks")
    fun getAllBookmarks(): String{
        return """[
            {
                "id": 1,
                "title": "My First Bookmark",
                "url": "www.example.com"
            },
            {
                "id": 2,
                "title": "Spring Boot Overview",
                "url": "www.spring-boot.com"
            }
        ]"""
    }
}