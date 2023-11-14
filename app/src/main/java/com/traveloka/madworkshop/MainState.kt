package com.traveloka.madworkshop

import androidx.compose.runtime.mutableStateListOf
import com.traveloka.madworkshop.user.User

class MainState {
    val users = mutableStateListOf<User>()
}