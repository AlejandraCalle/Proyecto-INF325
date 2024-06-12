package com.example.proyectopeliculas325

import android.content.ContentValues
import android.content.Context
import android.database.Cursor

class MovieDatabaseAdapter(context: Context) {

    private val dbHelper = MovieDatabaseHelper(context)

    fun addMovie(movie: Movie) {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(MovieDatabaseHelper.COLUMN_TITLE, movie.title)
            put(MovieDatabaseHelper.COLUMN_DESCRIPTION, movie.description)
            put(MovieDatabaseHelper.COLUMN_DIRECTOR, movie.director)
            put(MovieDatabaseHelper.COLUMN_YEAR, movie.year)
            put(MovieDatabaseHelper.COLUMN_GENRE, movie.genre)
        }
        db.insert(MovieDatabaseHelper.TABLE_NAME, null, values)
        db.close()
    }

    fun getAllMovies(): List<Movie> {
        val movies = mutableListOf<Movie>()
        val db = dbHelper.readableDatabase
        val cursor: Cursor = db.query(
            MovieDatabaseHelper.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            "${MovieDatabaseHelper.COLUMN_ID} ASC"
        )
        with(cursor) {
            while (moveToNext()) {
                val movie = Movie(
                    id = getLong(getColumnIndexOrThrow(MovieDatabaseHelper.COLUMN_ID)),
                    title = getString(getColumnIndexOrThrow(MovieDatabaseHelper.COLUMN_TITLE)),
                    description = getString(getColumnIndexOrThrow(MovieDatabaseHelper.COLUMN_DESCRIPTION)),
                    director = getString(getColumnIndexOrThrow(MovieDatabaseHelper.COLUMN_DIRECTOR)),
                    year = getInt(getColumnIndexOrThrow(MovieDatabaseHelper.COLUMN_YEAR)),
                    genre = getString(getColumnIndexOrThrow(MovieDatabaseHelper.COLUMN_GENRE))
                )
                movies.add(movie)
            }
            close()
        }
        db.close()
        return movies
    }

    fun updateMovie(movie: Movie) {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(MovieDatabaseHelper.COLUMN_TITLE, movie.title)
            put(MovieDatabaseHelper.COLUMN_DESCRIPTION, movie.description)
            put(MovieDatabaseHelper.COLUMN_DIRECTOR, movie.director)
            put(MovieDatabaseHelper.COLUMN_YEAR, movie.year)
            put(MovieDatabaseHelper.COLUMN_GENRE, movie.genre)
        }
        db.update(
            MovieDatabaseHelper.TABLE_NAME,
            values,
            "${MovieDatabaseHelper.COLUMN_ID} = ?",
            arrayOf(movie.id.toString())
        )
        db.close()
    }

    fun deleteMovieByTitle(title: String) {
        val db = dbHelper.writableDatabase
        db.delete(
            MovieDatabaseHelper.TABLE_NAME,
            "${MovieDatabaseHelper.COLUMN_TITLE} = ?",
            arrayOf(title)
        )
        db.close()
    }
}
