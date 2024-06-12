package com.example.proyectopeliculas325

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonAddMovie).setOnClickListener {
            startActivity(Intent(this, AddMovieActivity::class.java))
        }

        findViewById<Button>(R.id.buttonDeleteMovie).setOnClickListener {
            startActivity(Intent(this, DeleteMovieActivity::class.java))
        }

        findViewById<Button>(R.id.buttonListMovies).setOnClickListener {
            startActivity(Intent(this, ListMoviesActivity::class.java))
        }

        findViewById<Button>(R.id.buttonUpdateMovie).setOnClickListener {
            startActivity(Intent(this, UpdateMovieActivity::class.java))
        }
    }
}
