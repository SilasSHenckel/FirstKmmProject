package com.example.myfirstappkotlinmultiplataform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform