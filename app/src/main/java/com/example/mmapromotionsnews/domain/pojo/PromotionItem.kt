package com.example.mmapromotionsnews.domain.pojo


data class PromotionItem(
    val promotion: String,
    val image: String,
    val about: String,
    val rules: String,
    val boss: String,
    val results: List<ResultItem>,
    val fixtures: List<FixtureItem>,
    val p4p: List<PoundForPoundItem>
)