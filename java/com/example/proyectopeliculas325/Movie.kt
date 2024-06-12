package com.example.proyectopeliculas325

data class Movie(
    val id: Long = 0,
    val title: String,
    val description: String,
    val director: String,
    val year: Int,
    val genre: String
)
