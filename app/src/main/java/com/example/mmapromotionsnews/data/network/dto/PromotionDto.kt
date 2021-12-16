package com.example.mmapromotionsnews.data.network.dto

import com.example.mmapromotionsnews.domain.pojo.FixtureItem
import com.example.mmapromotionsnews.domain.pojo.PoundForPoundItem
import com.example.mmapromotionsnews.domain.pojo.ResultItem
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class PromotionDto(
    @SerializedName("promotion")
    @Expose
    val promotion: String? = null,

    @SerializedName("image")
    @Expose
    val image: String? = null,

    @SerializedName("about")
    @Expose
    val about: String? = null,

    @SerializedName("rules")
    @Expose
    val rules: String? = null,

    @SerializedName("boss")
    @Expose
    val boss: String? = null,

    @SerializedName("results")
    @Expose
    val results: List<ResultItem>? = null,

    @SerializedName("fixtures")
    @Expose
    val fixtures: List<FixtureItem>? = null,

    @SerializedName("p4p")
    @Expose
    val p4p: List<PoundForPoundItem>? = null
)