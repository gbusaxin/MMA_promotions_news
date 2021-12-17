package com.example.mmapromotionsnews.domain.use_cases

import com.example.mmapromotionsnews.domain.NewsRepository

class LoadNewsUseCase(private val repository: NewsRepository) {
    suspend operator fun invoke() = repository.loadNews()
}