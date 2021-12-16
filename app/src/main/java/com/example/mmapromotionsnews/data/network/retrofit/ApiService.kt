package com.example.mmapromotionsnews.data.network.retrofit

import com.example.mmapromotionsnews.data.network.dto.PromotionDto
import retrofit2.http.GET

interface ApiService {

    @GET("MMA.json")
    suspend fun loadPromotionListData():List<PromotionDto>

}