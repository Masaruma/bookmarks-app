package com.example.bookmarks.mizo.masaru

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Bookmark(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
    val title: String,
    val url: String,
)
