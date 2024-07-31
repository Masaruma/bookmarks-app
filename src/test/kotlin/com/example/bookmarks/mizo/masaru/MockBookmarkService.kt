package com.example.bookmarks.mizo.masaru

class MockBookmarkService: BookmarkService {
    var getAllBookmarksWasCalled = false
    var getSingleBookmarkWasCalled = false
    var saveBookmarkWasCalled = false
    override fun getAllBookmarks(): List<Bookmark> {
        println("Mock was called")
        getAllBookmarksWasCalled = true
        return listOf(
            Bookmark(1, "My First Bookmark", "www.example.com"),
            Bookmark(2, "Spring Boot Overview", "www.spring-boot.com")
        )
    }

    override fun getSingleBookmark(id: Long): Bookmark {
        getSingleBookmarkWasCalled = true
        return Bookmark(100, "My First Bookmark", "www.example.com")
    }

    override fun saveBookmark(bookmark: Bookmark): Bookmark {
        saveBookmarkWasCalled = true
        return Bookmark(1,"","")
    }


}

// Use a library to mock the actual implementation