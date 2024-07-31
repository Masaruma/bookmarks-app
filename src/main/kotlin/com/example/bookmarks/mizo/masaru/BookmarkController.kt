package com.example.bookmarks.mizo.masaru

import org.springframework.web.bind.annotation.*

@RestController
class BookmarkController(val bookmarkService: BookmarkService) {

    @GetMapping("/api/v1/bookmarks")
    fun getAllBookmarks(): List<Bookmark> {
        return bookmarkService.getAllBookmarks()

    }

    @GetMapping("/api/v1/bookmarks/{id}")
    fun getSingleBookmark(@PathVariable("id") id: Long): Bookmark {
        return bookmarkService.getSingleBookmark(id)
    }

    @PostMapping("/api/v1/bookmarks")
    fun saveBookmark(@RequestBody bookmark: Bookmark): Bookmark {
        return bookmarkService.saveBookmark(bookmark)
    }
}
