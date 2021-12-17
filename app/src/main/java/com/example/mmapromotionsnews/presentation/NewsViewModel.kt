package com.example.mmapromotionsnews.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.mmapromotionsnews.data.NewsRepositoryImpl
import com.example.mmapromotionsnews.data.database.db.AppDatabase
import com.example.mmapromotionsnews.domain.use_cases.GetNewsUseCase
import com.example.mmapromotionsnews.domain.use_cases.LoadNewsUseCase
import kotlinx.coroutines.launch

class NewsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = NewsRepositoryImpl(application)
    private val loadNews = LoadNewsUseCase(repository)
    private val getNews = GetNewsUseCase(repository)

    val news = getNews()

    init {
        viewModelScope.launch {
            loadNews()
        }
    }


}