package com.example.bookmarks.mizo.masaru

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BookmarkController {

    @GetMapping("/api/v1/bookmarks")
    fun getAllBookmarks(){

    }
}