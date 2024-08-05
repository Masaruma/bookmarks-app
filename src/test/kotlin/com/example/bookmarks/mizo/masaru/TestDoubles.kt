package com.example.bookmarks.mizo.masaru

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

// We have a car and it has two methods and we will try to demonstrate test doubles by using Mock, Spy and Stub
// ここでは、モック、スパイ、スタブを使って、テスト・ダブルを試してみます。
open class Car {
    open fun drive() = println("Car is driving")

    open fun speed() = 100
}

/**
 *  What: A mock car will pretend to drive and let us check if drive() was called during our tests
 *  What: モックカーが走るふりをして、テスト中にdrive()が呼ばれたかどうかをチェックする。
 *  When: Mocks are used when you want to verify that certain interactions happened
 *  When: いつ モックは、特定のインタラクションが起こったことを検証したいときに使用します。
 */
class MockCar : Car() {
    var driveWasCalled = false

    override fun drive() {
        driveWasCalled = true
    }
}

/**
 *  What: A spy Car will actually drive and also like mock keep track of whether drive() was called
 *  What: スパイ・カーが実際に走行し、drive()が呼ばれたかどうかをモックが追跡する。
 */
class SpyCar(val realCar: Car) : Car() {
    var driveWasCalled = false

    override fun drive() {
        realCar.drive() // Calling the real implementation
        driveWasCalled = true
    }

    override fun speed() = realCar.speed()
}

/**
 * What: A stub car will always return a specific speed when speed() is called
 * When:
 *  - When you need to control the return values of methods to test different scenarios
 *  - Verify the methods are called with the correct parameters
 *
 *   - 3rd Party API - You stub a response for the 3rd party API
 */
class StubCar : Car() {
    override fun speed(): Int {
        return 999
    }
}

class TestDoubles {

    @Test
    fun `mock test`() {
        val mockCar = MockCar()

        mockCar.drive()

        assertTrue(mockCar.driveWasCalled)
    }

    @Test
    fun `spy test`() {
        val realCar = Car() // real instance, actual production code
        val spyCar = SpyCar(realCar)

        spyCar.drive()

        assertTrue(spyCar.driveWasCalled)
        // A spy will verify if one of the method is called and leave the other methods
        assertEquals(spyCar.speed(), 100)
    }

    @Test
    fun `stub test`() {
        val stubCar = StubCar()

        assertEquals(stubCar.speed(), 999)
    }
}
