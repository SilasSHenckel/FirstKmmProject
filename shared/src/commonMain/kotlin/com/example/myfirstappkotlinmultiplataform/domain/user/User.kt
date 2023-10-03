package com.example.myfirstappkotlinmultiplataform.domain.User

import kotlinx.serialization.Serializable

@Serializable
data class User(
    var name: String? = "",
    val age: String = "",
)



