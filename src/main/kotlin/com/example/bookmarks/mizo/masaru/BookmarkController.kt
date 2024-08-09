package com.example.bookmarks.mizo.masaru

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class BookmarkController(val bookmarkService: BookmarkService) {

    @GetMapping("/api/v1/bookmarks")
    fun getAllBookmarks(): List<Bookmark> {
        throw IllegalArgumentException("There was a a problem")
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

    @DeleteMapping("/api/v1/bookmarks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBookmark(@PathVariable("id") id: Long) {
        return bookmarkService.deleteBookmark(id)
    }

    @ExceptionHandler
    fun catchException(e: IllegalArgumentException): ResponseEntity<String> {
        println("=====")
        println(e)
        return ResponseEntity.badRequest().build()
    }

    @ExceptionHandler
    fun catchBookmarkNotFoundException(e: BookmarkNotFoundException): ResponseEntity<String> {
        println("=====")
        println(e)
        println(e::class.qualifiedName)

        return ResponseEntity.notFound().build()
    }
}
