package com.example.mmapromotionsnews.domain

import androidx.lifecycle.LiveData
import com.example.mmapromotionsnews.domain.pojo.News

interface NewsRepository {
    fun getNews():LiveData<List<News>>
    suspend fun loadNews()
}