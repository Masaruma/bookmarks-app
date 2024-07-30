package com.example.bookmarks.mizo.masaru

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SampleJunitTests {

    @BeforeEach  // Runs before each test
    fun setup() {
        // Initialize any test object - you want to create a new object for every test
        // テスト・オブジェクトの初期化 - テストごとに新しいオブジェクトを作成したい。
        println("Before Each...")
    }

    @Test
    fun `test 1`() {
        println("Test 1..")
    }

    @Test
    fun `test 2`() {
        println("Test 2..")
    }

    @AfterEach // Runs after each test
    fun tearDown() {
        // Destroy the object after each test. Clear the database after each test
        // 各テスト後にオブジェクトを破棄する。各テスト後にデータベースをクリアする
        print("After Each...")
    }
}