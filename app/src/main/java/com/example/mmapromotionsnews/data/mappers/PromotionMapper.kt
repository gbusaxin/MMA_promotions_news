package com.example.mmapromotionsnews.data.mappers

import com.example.mmapromotionsnews.data.database.models.PromotionDbModel
import com.example.mmapromotionsnews.data.network.dto.PromotionDto
import com.example.mmapromotionsnews.domain.pojo.PromotionItem
import java.util.*

class PromotionMapper {

    fun mapDbModelToEntity(dbModel:PromotionDbModel) = PromotionItem(
        promotion = dbModel.promotion,
        image = dbModel.image,
        about = dbModel.about,
        rules = dbModel.rules,
        boss = dbModel.boss,
        results = dbModel.results,
        fixtures = dbModel.fixtures,
        p4p = dbModel.p4p
    )

    fun mapDtoToDbModel(dto:PromotionDto) = PromotionDbModel(
        promotion = dto.promotion?:"",
        image = dto.image?:"",
        about = dto.about?:"",
        rules = dto.rules?:"",
        boss = dto.boss?:"",
        results = dto.results?:Collections.emptyList(),
        fixtures = dto.fixtures?:Collections.emptyList(),
        p4p = dto.p4p?:Collections.emptyList()
    )

}