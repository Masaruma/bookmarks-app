package com.example.bookmarks.mizo.masaru

import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders

class BookmarkControllerTest {

    val mockMvc: MockMvc = MockMvcBuilders
        .standaloneSetup(BookmarkController()).build()

    @Test
    fun `should return 200 for GET all bookmarks`() {
        mockMvc.perform(get("/api/v1/bookmarks"))
            .andExpect(status().isOk)
    }

    @Test
    fun `should return bookmark response list`() {
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
}