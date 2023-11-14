package com.traveloka.madworkshop.user.repository

import com.traveloka.madworkshop.user.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUser(): User
    fun getUsers(n: Int): Flow<User>
}