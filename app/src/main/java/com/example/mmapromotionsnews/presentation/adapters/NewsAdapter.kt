package com.example.mmapromotionsnews.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mmapromotionsnews.R
import com.example.mmapromotionsnews.databinding.ItemNewsBinding
import com.example.mmapromotionsnews.domain.pojo.News
import com.squareup.picasso.Picasso

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bind = ItemNewsBinding.bind(itemView)
        val image = bind.imageViewNews
        val date = bind.textViewNewsDate
        val title = bind.textViewNewsTitle
        val body = bind.textViewNewsBody
    }

    var list = listOf<News>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_news, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = list[position]
        with(holder){
            Picasso.get().load(item.image).into(image)
            date.text = item.date
            title.text = item.title
            body.text = item.body
        }
    }

    override fun getItemCount() = list.size
}