package com.example.mmapromotionsnews.domain

import androidx.lifecycle.LiveData
import com.example.mmapromotionsnews.domain.pojo.PromotionItem

interface Repository {

    fun getPromotionUseCase(promotion:String):LiveData<PromotionItem>
    fun getPromotionListUseCase():LiveData<List<PromotionItem>>
    suspend fun loadPromotionListData()
}