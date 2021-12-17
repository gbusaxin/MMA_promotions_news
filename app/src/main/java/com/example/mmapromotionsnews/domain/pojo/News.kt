package com.example.mmapromotionsnews.domain.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_info")
data class News (
    val image: String,
    val date: String,
    @PrimaryKey
    val title: String,
    val body: String
)