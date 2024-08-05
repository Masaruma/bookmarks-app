package com.example.bookmarks.mizo.masaru

import org.springframework.data.jpa.repository.JpaRepository

// JPA Repository -
// Entity class - class which maps to a single database table
// Primary key or the ID of the entity class

// Because you are implementing a Spring JPA interface, and that interface has an annotation you dont need to specify
// for class
interface BookmarkRepository : JpaRepository<Bookmark, Long>
