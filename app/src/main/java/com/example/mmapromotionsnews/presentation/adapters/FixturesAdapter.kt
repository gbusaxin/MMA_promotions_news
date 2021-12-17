package com.example.mmapromotionsnews.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mmapromotionsnews.R
import com.example.mmapromotionsnews.databinding.ItemFightBinding
import com.example.mmapromotionsnews.domain.pojo.FixtureItem
import com.squareup.picasso.Picasso

class FixturesAdapter : RecyclerView.Adapter<FixturesAdapter.FixtureVieHolder>() {
    inner class FixtureVieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemFightBinding.bind(itemView)
        val image1 = binding.imageViewEnemy1
        val image2 = binding.imageViewEnemy2
        val enemy1 = binding.textViewEnemyName1
        val enemy2 = binding.textViewEnemyName2
        val weight = binding.textViewPromotionWeight
        val number = binding.textViewFightNumber
    }

    var list = listOf<FixtureItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixtureVieHolder {
        return FixtureVieHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_fight, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FixtureVieHolder, position: Int) {
        val item = list[position]
        with(holder){
            Picasso.get().load(item.enemy1image).into(image1)
            Picasso.get().load(item.enemy2image).into(image2)
            enemy1.text = item.enemy1
            enemy2.text = item.enemy2
            weight.text = item.weight
            number.text = item.number
        }
    }

    override fun getItemCount() = list.size
}