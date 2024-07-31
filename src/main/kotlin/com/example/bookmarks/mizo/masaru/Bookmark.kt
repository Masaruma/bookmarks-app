package com.example.bookmarks.mizo.masaru

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
data class Bookmark(@Id @GeneratedValue val id: Long? = null, val title: String, val url: String)
