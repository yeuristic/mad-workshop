package com.traveloka.madworkshop.user

class User(
    val gender: String,
    val name: Name,
    val email: String,
    val phone: String,
    val picture: Picture
) {
    fun fullName(): String {
        return "${name.title}. ${name.first} ${name.last}"
    }
}

class Name(
    val title: String,
    val first: String,
    val last: String
)

class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
)