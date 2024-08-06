package com.example.bookmarks.mizo.masaru

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Service

@Service
class JsonPlaceholderService(val jpc: JsonPlaceHolderConfig) {

//    @Value("\${app.jsonplaceholder.host}")
//    lateinit var host: String
//
//    @Value("\${app.jsonplaceholder.port}")
//    lateinit var port: String
//
//    @Value("\${app.jsonplaceholder.user}")
//    lateinit var user: String
//
//    @Value("\${app.jsonplaceholder.password}")
//    lateinit var password: String
//
//    @Value("\${app.jsonplaceholder.items}")
//    lateinit var items: String

    fun getPostData() {
//        val url = "https://jsonplaceholder.org/posts"
        println("Fetching '${jpc.items}' post data from ${jpc.host}:${jpc.port} using '${jpc.user}' with password '${jpc.password}' ")

        // Fetching post data from https://jsonplaceholder.com:80
    }
}

@ConfigurationProperties(prefix = "app.jsonplaceholder")
data class JsonPlaceHolderConfig(val host: String, val port: String, val user: String, val password: String, val items: String)
