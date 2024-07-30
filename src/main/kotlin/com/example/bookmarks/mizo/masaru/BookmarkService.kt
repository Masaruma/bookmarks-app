package com.example.bookmarks.mizo.masaru

import org.springframework.stereotype.Service

interface BookmarkService {
    fun getAllBookmarks(): List<Bookmark>
}

@Service
class DefaultBookmarkService: BookmarkService {
    override fun getAllBookmarks(): List<Bookmark> {
        TODO("Not yet implemented")
    }

}