package com.example.nit3213finalapp

import com.example.nit3213finalapp.network.LoginRequest
import com.example.nit3213finalapp.network.LoginResponse
import com.example.nit3213finalapp.network.Entity
import org.junit.Assert.*
import org.junit.Test

class ExampleUnitTest {

    @Test
    fun testLoginRequestCreation() {
        val request = LoginRequest("Dipen", "s8095318")

        assertEquals("Dipen", request.username)
        assertEquals("s8095318", request.password)
    }

    @Test
    fun testLoginResponse() {
        val response = LoginResponse("test_key")

        assertEquals("test_key", response.keypass)
    }

    @Test
    fun testEntityData() {
        val entity = Entity("value1", "value2", "description")

        assertEquals("value1", entity.property1)
        assertEquals("value2", entity.property2)
        assertEquals("description", entity.description)
    }

    @Test
    fun testEntityNotEmpty() {
        val entity = Entity("value1", "value2", "description")

        assertTrue(entity.property1.isNotEmpty())
        assertTrue(entity.property2.isNotEmpty())
        assertTrue(entity.description.isNotEmpty())
    }
}