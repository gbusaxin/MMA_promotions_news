package com.example.mmapromotionsnews.data.network.retrofit

import androidx.lifecycle.LiveData
import com.example.mmapromotionsnews.data.network.dto.NewsDto
import com.example.mmapromotionsnews.data.network.dto.PromotionDto
import retrofit2.http.GET

interface ApiService {

    @GET("MMA.json")
    suspend fun loadPromotionListData():List<PromotionDto>

    @GET("mma_news.json")
    suspend fun loadNewsList():List<NewsDto>

}