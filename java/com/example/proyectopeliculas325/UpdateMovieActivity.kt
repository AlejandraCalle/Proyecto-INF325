package com.example.proyectopeliculas325

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class UpdateMovieActivity : AppCompatActivity() {

    private lateinit var dbAdapter: MovieDatabaseAdapter
    private lateinit var editTextId: EditText
    private lateinit var editTextTitle: EditText
    private lateinit var editTextDescription: EditText
    private lateinit var editTextDirector: EditText
    private lateinit var editTextYear: EditText
    private lateinit var editTextGenre: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_movie)

        dbAdapter = MovieDatabaseAdapter(this)

        editTextId = findViewById(R.id.editTextId)
        editTextTitle = findViewById(R.id.editTextTitle)
        editTextDescription = findViewById(R.id.editTextDescription)
        editTextDirector = findViewById(R.id.editTextDirector)
        editTextYear = findViewById(R.id.editTextYear)
        editTextGenre = findViewById(R.id.editTextGenre)

        findViewById<Button>(R.id.buttonUpdate).setOnClickListener {
            updateMovie()
        }

        findViewById<Button>(R.id.btn_back).setOnClickListener {
            finish()  // Close the activity and return to the main screen
        }
    }

    private fun updateMovie() {
        val id = editTextId.text.toString().toLongOrNull() ?: return
        val title = editTextTitle.text.toString()
        val description = editTextDescription.text.toString()
        val director = editTextDirector.text.toString()
        val year = editTextYear.text.toString().toIntOrNull() ?: 0
        val genre = editTextGenre.text.toString()

        if (title.isNotBlank() && description.isNotBlank() && director.isNotBlank() && year > 0 && genre.isNotBlank()) {
            val movie = Movie(id = id, title = title, description = description, director = director, year = year, genre = genre)
            dbAdapter.updateMovie(movie)
            finish()  // Close the activity and return to the main screen
        }
    }
}
