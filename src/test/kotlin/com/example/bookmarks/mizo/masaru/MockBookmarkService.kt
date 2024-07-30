package com.example.bookmarks.mizo.masaru

class MockBookmarkService: BookmarkService {

    override fun getAllBookmarks(): List<Bookmark> {
        println("Mock was called")
        return listOf()
    }

}

// Use a library to mock the actual implementation