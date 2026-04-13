package com.example.nit3213finalapp.network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

data class LoginRequest(
    val username: String,
    val password: String
)

data class LoginResponse(
    val keypass: String
)

data class Entity(
    val property1: String,
    val property2: String,
    val description: String
)

data class DashboardResponse(
    val entities: List<Entity>,
    val entityTotal: Int
)

interface ApiService {

    @POST("/sydney/auth")
    suspend fun login(
        @Body request: LoginRequest
    ): Response<LoginResponse>

    @GET("/dashboard/{keypass}")
    suspend fun getDashboard(
        @Path("keypass") keypass: String
    ): Response<DashboardResponse>
}