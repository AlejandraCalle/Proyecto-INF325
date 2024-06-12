package com.example.proyectopeliculas325

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddMovieActivity : AppCompatActivity() {

    private lateinit var dbAdapter: MovieDatabaseAdapter
    private lateinit var editTextTitle: EditText
    private lateinit var editTextDescription: EditText
    private lateinit var editTextDirector: EditText
    private lateinit var editTextYear: EditText
    private lateinit var editTextGenre: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)

        dbAdapter = MovieDatabaseAdapter(this)

        editTextTitle = findViewById(R.id.editTextTitle)
        editTextDescription = findViewById(R.id.editTextDescription)
        editTextDirector = findViewById(R.id.editTextDirector)
        editTextYear = findViewById(R.id.editTextYear)
        editTextGenre = findViewById(R.id.editTextGenre)

        findViewById<Button>(R.id.buttonAdd).setOnClickListener {
            addMovie()
        }

        findViewById<Button>(R.id.btn_back).setOnClickListener {
            finish()
        }
    }

    private fun addMovie() {
        val title = editTextTitle.text.toString()
        val description = editTextDescription.text.toString()
        val director = editTextDirector.text.toString()
        val year = editTextYear.text.toString().toIntOrNull() ?: 0
        val genre = editTextGenre.text.toString()

        if (title.isNotBlank() && description.isNotBlank() && director.isNotBlank() && year > 0 && genre.isNotBlank()) {
            val movie = Movie(title = title, description = description, director = director, year = year, genre = genre)
            dbAdapter.addMovie(movie)
            finish()  // Close the activity and return to the main screen
        }
    }
}
