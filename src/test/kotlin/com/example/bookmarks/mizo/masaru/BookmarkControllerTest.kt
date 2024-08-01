package com.example.bookmarks.mizo.masaru

import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import java.awt.PageAttributes
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BookmarkControllerTest {

    val mockBookmarkService = MockBookmarkService()

    val mockMvc: MockMvc = MockMvcBuilders
        .standaloneSetup(BookmarkController(mockBookmarkService)).build()

    @Test
    fun `should return 200 for GET all bookmarks`() {
        mockMvc.perform(get("/api/v1/bookmarks"))
            .andExpect(status().isOk)
    }

    @Test
    fun `should return bookmark response list`() {

        // you need to return a list from the mockBookmarkService

        val expectedResponse = """
             [
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
             ]
        """.trimIndent()

        mockMvc.perform(get("/api/v1/bookmarks"))
            .andExpect(MockMvcResultMatchers.content().json(expectedResponse))
    }

    @Test
    fun `should call mock bookmark service`() {
       // when a controller is called
        val bookmarkController = BookmarkController(mockBookmarkService)

        bookmarkController.getAllBookmarks()

        // assert that mockbookmarkservice.getAllBookmarks() is called
        assertTrue(mockBookmarkService.getAllBookmarksWasCalled)
    }

    @Test
    fun `should return 200 for GET single bookmark`() {
        mockMvc.perform(get("/api/v1/bookmarks/1000"))
            .andExpect(status().isOk)
    }

    @Test
    fun `should call mock single bookmark service and return single bookmark JSON`() {

        val expectedResponse = """
            {
            "id": 100,
            "title": "My First Bookmark",
            "url": "www.example.com"   
             }
        """.trimIndent()

        mockMvc.perform(get("/api/v1/bookmarks/100"))
            .andExpect(MockMvcResultMatchers.content().json(expectedResponse))

        assertTrue(mockBookmarkService.getSingleBookmarkWasCalled)
    }

    @Test
    fun `should return 200 for save bookmark and invoke bookmark service`() {
        val requestBody = """
            { "title": "sample", "url": "sample.com" }
        """.trimIndent()

        mockMvc.perform(post("/api/v1/bookmarks")
            .content(requestBody)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
     // TODO: Verify if the the response from mockMVC is equal to JSON content

        assertTrue(mockBookmarkService.saveBookmarkWasCalled)
    }

    @Test
    fun `should return status 204 for delete request and call service`(){
        // TODO
        mockMvc.perform(delete("/api/v1/bookmarks/100"))
            .andExpect(status().isNoContent)

        assertTrue(mockBookmarkService.deleteBookWasCalled)
    }

}