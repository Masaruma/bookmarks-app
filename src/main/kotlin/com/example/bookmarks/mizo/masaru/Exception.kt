package com.example.bookmarks.mizo.masaru

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler

// Custom Exception - When there was no bookmark found in the database when you getByID, deletebyId
class BookmarkNotFoundException(message: String): Exception(message){
}