package com.traveloka.madworkshop

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.traveloka.madworkshop.core.buildRetrofit
import com.traveloka.madworkshop.user.gateway.UserService
import com.traveloka.madworkshop.user.repository.UserRepository
import com.traveloka.madworkshop.user.repository.UserRepositoryImpl
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainViewModel : ViewModel() {
    private val retrofit = buildRetrofit("https://randomuser.me/")
    private val userRepository: UserRepository =
        UserRepositoryImpl(retrofit.create(UserService::class.java))
    val state = MainState()

    fun fetch() {
        userRepository.getUsers(3)
            .onEach {
                state.users.add(it)
            }
            .launchIn(viewModelScope)
    }
}