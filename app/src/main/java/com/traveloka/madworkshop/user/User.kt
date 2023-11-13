package com.traveloka.madworkshop.user

class User(
    val gender: String,
    val name: Name,
    val location: Location,
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

class Location(
    val street: Street,
    val city: String,
    val state: String,
    val country: String,
    val postcode: Int,
    val coordinates: Coordinates,
)
class Street(
    val number: Int,
    val name: String
)

class Coordinates(
    val latitude: String,
    val longitude: String
)

class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
)