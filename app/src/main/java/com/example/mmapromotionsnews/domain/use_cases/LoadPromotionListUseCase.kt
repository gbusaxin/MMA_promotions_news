package com.example.mmapromotionsnews.domain.use_cases

import com.example.mmapromotionsnews.domain.Repository

class LoadPromotionListUseCase(private val repository: Repository) {
    suspend operator fun invoke() = repository.loadPromotionListData()
}