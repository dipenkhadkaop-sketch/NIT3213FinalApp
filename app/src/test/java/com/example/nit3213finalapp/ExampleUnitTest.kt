package com.example.nit3213finalapp

import com.example.nit3213finalapp.network.Entity
import com.example.nit3213finalapp.network.LoginRequest
import com.example.nit3213finalapp.network.LoginResponse
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {

    @Test
    fun loginRequestStoresCorrectValues() {
        val request = LoginRequest("Dipen", "s8095318")

        assertEquals("Dipen", request.username)
        assertEquals("s8095318", request.password)
    }

    @Test
    fun loginResponseStoresKeypass() {
        val response = LoginResponse("demo_keypass")

        assertEquals("demo_keypass", response.keypass)
    }

    @Test
    fun entityStoresCorrectValues() {
        val entity = Entity(
            property1 = "Item 1",
            property2 = "Property 2 for item 1",
            description = "This is the description for item 1."
        )

        assertEquals("Item 1", entity.property1)
        assertEquals("Property 2 for item 1", entity.property2)
        assertEquals("This is the description for item 1.", entity.description)
    }

    @Test
    fun entityFieldsAreNotEmpty() {
        val entity = Entity(
            property1 = "Item 2",
            property2 = "Property 2 for item 2",
            description = "This is the description for item 2."
        )

        assertTrue(entity.property1.isNotEmpty())
        assertTrue(entity.property2.isNotEmpty())
        assertTrue(entity.description.isNotEmpty())
    }
}