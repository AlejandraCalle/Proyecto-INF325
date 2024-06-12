package com.example.proyectopeliculas325

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListMoviesActivity : AppCompatActivity() {

    private lateinit var dbAdapter: MovieDatabaseAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_movies)

        dbAdapter = MovieDatabaseAdapter(this)
        recyclerView = findViewById(R.id.recyclerViewMovies)
        recyclerView.layoutManager = LinearLayoutManager(this)

        loadMovies()

        findViewById<Button>(R.id.btn_back).setOnClickListener {
            finish()
        }
    }

    private fun loadMovies() {
        val movies = dbAdapter.getAllMovies()
        movieAdapter = MovieAdapter(movies) { movie ->
            // A
        }
        recyclerView.adapter = movieAdapter
    }
}
