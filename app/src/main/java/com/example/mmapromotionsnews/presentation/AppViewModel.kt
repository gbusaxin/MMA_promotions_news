package com.example.mmapromotionsnews.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.mmapromotionsnews.data.RepositoryImpl
import com.example.mmapromotionsnews.domain.use_cases.GetPromotionListUseCase
import com.example.mmapromotionsnews.domain.use_cases.GetPromotionUseCase
import com.example.mmapromotionsnews.domain.use_cases.LoadPromotionListUseCase
import kotlinx.coroutines.launch

class AppViewModel(application: Application):AndroidViewModel(application) {
    private val repository = RepositoryImpl(application)

    private val getPromotionUseCase = GetPromotionUseCase(repository)
    private val getPromotionListUseCase = GetPromotionListUseCase(repository)

    private val loadPromotionListUseCase = LoadPromotionListUseCase(repository)

    val promotionList = getPromotionListUseCase()

    fun getPromotion(promotion:String) = getPromotionUseCase(promotion)

    init {
        viewModelScope.launch{
            loadPromotionListUseCase
        }
    }
}