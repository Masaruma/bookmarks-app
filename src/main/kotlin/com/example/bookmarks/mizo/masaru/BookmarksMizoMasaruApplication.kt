package com.example.bookmarks.mizo.masaru

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(JsonPlaceHolderConfig::class)
class BookmarksMizoMasaruApplication

fun main(args: Array<String>) {
    var runApplication = runApplication<BookmarksMizoMasaruApplication>(*args)
    var bean = runApplication.getBean("jsonPlaceholderService", JsonPlaceholderService::class.java)
    println(bean.getPostData())
}
