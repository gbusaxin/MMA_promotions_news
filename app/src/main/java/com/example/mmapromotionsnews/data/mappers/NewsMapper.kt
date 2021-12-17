package com.example.mmapromotionsnews.data.mappers

import com.example.mmapromotionsnews.data.network.dto.NewsDto
import com.example.mmapromotionsnews.domain.pojo.News

class NewsMapper {
    fun mapDtoToEntity(dto:NewsDto) = News(
        image = dto.image?:"",
        date = dto.date?:"",
        title = dto.title?:"",
        body = dto.body?:""
    )
}