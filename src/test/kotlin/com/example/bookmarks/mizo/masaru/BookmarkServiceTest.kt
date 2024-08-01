package com.example.bookmarks.mizo.masaru

import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.server.ResponseStatusException
import kotlin.test.assertEquals

class BookmarkServiceTest {

    val mockBookmarkRepository: BookmarkRepository = mockk()
    val bookmarkService = DefaultBookmarkService(mockBookmarkRepository)

    @Test
    fun `should call bookmark repository for get all bookmarks`(){
        // Arrange
        every { mockBookmarkRepository.findAll() } returns listOf(Bookmark(1, "Title", "Url"))

        //Act
        var allBookmarks = bookmarkService.getAllBookmarks()

        //Assert
        assertEquals(allBookmarks.size, 1)
        assertEquals(allBookmarks[0].title, "Title")
        assertEquals(allBookmarks[0].url, "Url")
        verify (exactly = 1){mockBookmarkRepository.findAll() }
    }

    @Test
    fun `should call bookmark repository for single bookmark` () {
        // Arrange
        every { mockBookmarkRepository.findByIdOrNull(10)} returns Bookmark(10,"Title2","url2")

        // Act
        var singleBookmark = bookmarkService.getSingleBookmark(10)

        // Assert
        assertEquals(singleBookmark.id,10)
        assertEquals(singleBookmark.title,"Title2")
        assertEquals(singleBookmark.url,"url2")
        verify ( exactly = 1){mockBookmarkRepository.findByIdOrNull(10)}
    }

    @Test
    fun `should throw ResponseStatusException when id not found`(){
        // Arrange
        every { mockBookmarkRepository.findByIdOrNull(-100) } returns null

        // Act/Assert
        assertThrows<ResponseStatusException> { bookmarkService.getSingleBookmark(-100) }
    }

    @Test
    fun `should invoke bookmark service save method `(){
        // Arrange
        var bookmarkRequest = Bookmark(title = "Title", url = "Url")
        every { mockBookmarkRepository.save(any()) } returns Bookmark(1,"Title","Url")

        // Act
        var bookmark = bookmarkService.saveBookmark(bookmarkRequest)

        // Assert
        assertEquals(bookmark.title,"Title")
        assertEquals(bookmark.url,"Url")
        assertEquals(bookmark.id,1)
        verify (exactly = 1){mockBookmarkRepository.save(bookmarkRequest)}
    }

    @Test
    fun `should call repository delete `(){
        every { mockBookmarkRepository.findByIdOrNull(10) } returns Bookmark(10,"Title","Url")
        every { mockBookmarkRepository.delete(any()) } returns Unit
        bookmarkService.deleteBookmark(10)

        verify(exactly = 1) { mockBookmarkRepository.findByIdOrNull(10) }
        verify(exactly = 1) { mockBookmarkRepository.delete(any()) }
    }

    @Test
    fun `should throw ResponseStatusException for delete when id not found` (){
        // In addition to check the exception type, also check the status code and message
        every { mockBookmarkRepository.findByIdOrNull(1) } returns null


        val throwable = assertThrows<ResponseStatusException> { bookmarkService.deleteBookmark(1) }
        assertEquals(throwable.reason, "Id not found")
    }
}

