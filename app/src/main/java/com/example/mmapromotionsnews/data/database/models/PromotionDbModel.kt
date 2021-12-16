package com.example.mmapromotionsnews.data.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.mmapromotionsnews.data.converters.PromotionConverter
import com.example.mmapromotionsnews.domain.pojo.FixtureItem
import com.example.mmapromotionsnews.domain.pojo.PoundForPoundItem
import com.example.mmapromotionsnews.domain.pojo.ResultItem

@Entity(tableName = "promotion_column")
@TypeConverters(PromotionConverter::class)
data class PromotionDbModel (
    @PrimaryKey
    val promotion: String,
    val image: String,
    val about: String,
    val rules: String,
    val boss: String,
    val results: List<ResultItem>,
    val fixtures: List<FixtureItem>,
    val p4p: List<PoundForPoundItem>
    )