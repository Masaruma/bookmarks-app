package com.example.bookmarks.mizo.masaru

import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatusCode
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

interface BookmarkService {
    fun getAllBookmarks(): List<Bookmark>
    fun getSingleBookmark(id: Long): Bookmark
    fun saveBookmark(bookmark: Bookmark): Bookmark
    fun deleteBookmark(id: Long) : Unit
}

@Service
class DefaultBookmarkService(val bookmarkRepository: BookmarkRepository): BookmarkService {
    override fun getAllBookmarks(): List<Bookmark> {
        return bookmarkRepository.findAll()
    }

    override fun getSingleBookmark(id: Long): Bookmark {
        return bookmarkRepository.findByIdOrNull(id) ?:
                throw ResponseStatusException(HttpStatusCode.valueOf(404),"Id not found")
    }

    override fun saveBookmark(bookmark: Bookmark): Bookmark {
        return bookmarkRepository.save(bookmark)
    }

    override fun deleteBookmark(id: Long) {
        // Options 1: If ID exists return void or ID does not exist throw error
        var bookmark =
            bookmarkRepository.findByIdOrNull(id) ?: throw ResponseStatusException(HttpStatusCode.valueOf(404), "Id not found")

        bookmarkRepository.delete(bookmark)

//        // Option 2:  You return Void/Unit if id exists or does not exists
//        return bookmarkRepository.deleteById(id) // Less verbose

    }

}