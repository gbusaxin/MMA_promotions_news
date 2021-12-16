package com.example.mmapromotionsnews.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.mmapromotionsnews.R
import com.example.mmapromotionsnews.databinding.ItemPromotionBinding
import com.example.mmapromotionsnews.domain.pojo.PromotionItem
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.collections.ArrayList

class PromotionAdapter(var list: ArrayList<PromotionItem>) :
    RecyclerView.Adapter<PromotionAdapter.PromotionViewHolder>(), Filterable {
    inner class PromotionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemPromotionBinding.bind(itemView)
        val promotion = binding.textViewPromotion
        val image = binding.imageViewPromotionImage
    }

    private var filteredList = ArrayList<PromotionItem>()

    init {
        filteredList = list
    }

    var onPromotionClickListener: ((PromotionItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromotionViewHolder {
        return PromotionViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_promotion,parent,false))
    }

    override fun onBindViewHolder(holder: PromotionViewHolder, position: Int) {
        val item = filteredList[position]
        with(holder){
            Picasso.get().load(item.image).into(image)
            promotion.text = item.promotion
        }
        holder.itemView.setOnClickListener {
            onPromotionClickListener?.invoke(item)
        }
    }

    override fun getItemCount() = filteredList.size

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val charSearch = p0.toString()
                if (charSearch.isEmpty()){
                    filteredList = list
                }else{
                    val result = ArrayList<PromotionItem>()
                    for (item in list){
                        if (item.promotion.lowercase(Locale.ROOT)
                                .trim()
                                .contains(charSearch.lowercase(Locale.ROOT))){
                            result.add(item)
                        }
                    }
                    filteredList = result
                }
                val filterResult = FilterResults()
                filterResult.values = filteredList
                return filterResult
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                filteredList = p1?.values as ArrayList<PromotionItem>
                notifyDataSetChanged()
            }

        }
    }
}