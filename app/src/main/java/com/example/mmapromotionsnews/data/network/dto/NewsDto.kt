package com.example.mmapromotionsnews.data.network.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class NewsDto(
    @SerializedName("image")
    @Expose
    val image: String? = null,

    @SerializedName("date")
    @Expose
    val date: String? = null,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("body")
    @Expose
    val body: String? = null
)