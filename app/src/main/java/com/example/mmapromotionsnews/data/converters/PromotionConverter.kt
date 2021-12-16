package com.example.mmapromotionsnews.data.converters

import androidx.room.TypeConverter
import com.example.mmapromotionsnews.domain.pojo.FixtureItem
import com.example.mmapromotionsnews.domain.pojo.PoundForPoundItem
import com.example.mmapromotionsnews.domain.pojo.ResultItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

class PromotionConverter {

    @TypeConverter
    fun toListFixtureInfoFromJson(fixture:String):List<FixtureItem>{
        if(fixture == null) return Collections.emptyList()
        val type: Type = object : TypeToken<List<FixtureItem>>(){}.type
        return Gson().fromJson(fixture,type)
    }
    @TypeConverter
    fun fromJsonToListFixtureInfo(fixture:List<FixtureItem>):String{
        return Gson().toJson(fixture)
    }

    @TypeConverter
    fun toListP4PInfoFromJson(p4p:String):List<PoundForPoundItem>{
        if(p4p == null) return Collections.emptyList()
        val type: Type = object : TypeToken<List<PoundForPoundItem>>(){}.type
        return Gson().fromJson(p4p,type)
    }
    @TypeConverter
    fun fromJsonToListP4PInfo(p4p:List<PoundForPoundItem>):String{
        return Gson().toJson(p4p)
    }

    @TypeConverter
    fun toListResultInfoFromJson(result:String):List<ResultItem>{
        if(result == null) return Collections.emptyList()
        val type: Type = object : TypeToken<List<ResultItem>>(){}.type
        return Gson().fromJson(result,type)
    }
    @TypeConverter
    fun fromJsonToListResultInfo(result:List<ResultItem>):String{
        return Gson().toJson(result)
    }
}