package com.example.proyectopeliculas325

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(
    private val movies: List<Movie>,
    private val onDeleteClick: (Movie) -> Unit
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewId: TextView = view.findViewById(R.id.textViewId)
        val textViewTitle: TextView = view.findViewById(R.id.textViewTitle)
        val textViewDescription: TextView = view.findViewById(R.id.textViewDescription)
        val textViewDirector: TextView = view.findViewById(R.id.textViewDirector)
        val textViewYear: TextView = view.findViewById(R.id.textViewYear)
        val textViewGenre: TextView = view.findViewById(R.id.textViewGenre)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.textViewId.text = movie.id.toString()
        holder.textViewTitle.text = movie.title
        holder.textViewDescription.text = movie.description
        holder.textViewDirector.text = movie.director
        holder.textViewYear.text = movie.year.toString()
        holder.textViewGenre.text = movie.genre

    }

    override fun getItemCount() = movies.size
}
