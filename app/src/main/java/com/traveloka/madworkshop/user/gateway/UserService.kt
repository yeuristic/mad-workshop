package com.traveloka.madworkshop.user.gateway

import com.traveloka.madworkshop.user.UserResponse
import retrofit2.http.GET

interface UserService {
    @GET("api")
    suspend fun getRandomUser(): UserResponse
}