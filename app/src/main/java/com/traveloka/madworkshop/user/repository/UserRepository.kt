package com.traveloka.madworkshop.user.repository

import com.traveloka.madworkshop.user.User

interface UserRepository {
    suspend fun getUser(): User
}