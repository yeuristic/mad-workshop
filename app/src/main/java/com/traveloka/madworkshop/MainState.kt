package com.traveloka.madworkshop

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.traveloka.madworkshop.user.User

class MainState {
    val user: MutableState<User?> = mutableStateOf(null)
}