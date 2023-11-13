package com.traveloka.madworkshop

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.traveloka.madworkshop.core.buildRetrofit
import com.traveloka.madworkshop.user.gateway.UserService
import com.traveloka.madworkshop.user.repository.UserRepository
import com.traveloka.madworkshop.user.repository.UserRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val retrofit = buildRetrofit("https://randomuser.me/")
    private val userRepository: UserRepository = UserRepositoryImpl(retrofit.create(UserService::class.java))
    val state = MainState()

    fun fetch() {
        viewModelScope.launch(Dispatchers.IO) {
            state.user.value = userRepository.getUser()
        }
    }
}