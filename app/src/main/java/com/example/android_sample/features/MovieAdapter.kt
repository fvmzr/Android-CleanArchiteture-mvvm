package com.example.android_sample.features

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_sample.R
import com.example.android_sample.core.extension.inflate
import com.example.android_sample.core.extension.loadFromUrl
import kotlinx.android.synthetic.main.row_movie.view.*
import javax.inject.Inject
import kotlin.properties.Delegates

class MovieAdapter
@Inject constructor() : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    internal var collection: List<SearchModel> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.inflate(R.layout.row_movie))

    override fun getItemCount(): Int {
        return collection.size

    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(collection[position], position)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(searchModel: SearchModel, position: Int) {
            val a = itemView.moviePoster.loadFromUrl(searchModel.Poster)

        }

    }
}