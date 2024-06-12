package com.example.proyectopeliculas325

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class DeleteMovieActivity : AppCompatActivity() {

    private lateinit var dbAdapter: MovieDatabaseAdapter
    private lateinit var editTextTitle: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_movie)

        dbAdapter = MovieDatabaseAdapter(this)
        editTextTitle = findViewById(R.id.editTextTitle)

        findViewById<Button>(R.id.buttonDelete).setOnClickListener {
            deleteMovie()
        }

        findViewById<Button>(R.id.btn_back).setOnClickListener {
            finish()
        }
    }

    private fun deleteMovie() {
        val title = editTextTitle.text.toString()
        if (title.isNotBlank()) {
            dbAdapter.deleteMovieByTitle(title)
            finish()  // Close the activity and return to the main screen
        }
    }
}
