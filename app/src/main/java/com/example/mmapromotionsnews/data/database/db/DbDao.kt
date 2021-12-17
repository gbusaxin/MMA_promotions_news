package com.example.mmapromotionsnews.data.database.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mmapromotionsnews.data.database.models.PromotionDbModel
import com.example.mmapromotionsnews.data.network.dto.NewsDto
import com.example.mmapromotionsnews.domain.pojo.News

@Dao
interface DbDao {

    @Query("SELECT * FROM promotion_column")
    fun getPromotionList():LiveData<List<PromotionDbModel>>

    @Query("SELECT * FROM promotion_column WHERE promotion ==:promotion")
    fun getPromotionItem(promotion:String):LiveData<PromotionDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPromotionList(promotionList:List<PromotionDbModel>)

    @Query("SELECT * FROM news_info")
    fun getNewsList():LiveData<List<News>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewsList(news:List<News>)

}