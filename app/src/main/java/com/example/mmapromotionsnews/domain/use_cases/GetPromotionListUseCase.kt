package com.example.mmapromotionsnews.domain.use_cases

import com.example.mmapromotionsnews.domain.Repository

class GetPromotionListUseCase(private val repository: Repository) {
    operator fun invoke() = repository.getPromotionListUseCase()
}