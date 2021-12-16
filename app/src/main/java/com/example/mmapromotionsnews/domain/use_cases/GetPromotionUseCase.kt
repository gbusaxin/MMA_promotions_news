package com.example.mmapromotionsnews.domain.use_cases

import com.example.mmapromotionsnews.domain.Repository

class GetPromotionUseCase(private val repository: Repository) {
    operator fun invoke(promotion:String) = repository.getPromotionUseCase(promotion)
}