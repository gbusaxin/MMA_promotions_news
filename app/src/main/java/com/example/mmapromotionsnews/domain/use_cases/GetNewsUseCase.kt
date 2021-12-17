package com.example.mmapromotionsnews.domain.use_cases

import com.example.mmapromotionsnews.domain.NewsRepository

class GetNewsUseCase(private val repository: NewsRepository) {
    operator fun invoke() = repository.getNews()
}