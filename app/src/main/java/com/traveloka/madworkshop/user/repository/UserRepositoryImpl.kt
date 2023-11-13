package com.traveloka.madworkshop.user.repository

import com.traveloka.madworkshop.user.User
import com.traveloka.madworkshop.user.gateway.UserService

class UserRepositoryImpl(
    private val userService: UserService
): UserRepository {
    override suspend fun getUser(): User {
        TODO()
    }
}