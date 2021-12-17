package com.example.mmapromotionsnews.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mmapromotionsnews.R
import com.example.mmapromotionsnews.databinding.ItemP4pBinding
import com.example.mmapromotionsnews.domain.pojo.PoundForPoundItem
import com.squareup.picasso.Picasso

class Pound4PAdapter : RecyclerView.Adapter<Pound4PAdapter.P4pViewHolder>() {
    inner class P4pViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemP4pBinding.bind(itemView)
        val weight = binding.textViewP4pWeight
        val image = binding.imageP4p
        val name = binding.textViewNameP4p
    }

    var list = listOf<PoundForPoundItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): P4pViewHolder {
        return P4pViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_p4p, parent, false)
        )
    }

    override fun onBindViewHolder(holder: P4pViewHolder, position: Int) {
        val item = list[position]
        with(holder){
            Picasso.get().load(item.image).into(image)
            weight.text = item.weight
            name.text = item.name
        }
    }

    override fun getItemCount() = list.size
}