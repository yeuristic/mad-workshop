package com.traveloka.madworkshop.user.repository

import com.traveloka.madworkshop.user.User
import com.traveloka.madworkshop.user.gateway.UserService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map

class UserRepositoryImpl(
    private val userService: UserService
): UserRepository {
    override suspend fun getUser(): User {
        return userService.getRandomUser().results.first()
    }

    override fun getUsers(n: Int): Flow<User> {
        return (0 until n).asFlow().map {
            getUser()
        }
    }
}