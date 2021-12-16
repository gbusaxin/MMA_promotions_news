package com.example.mmapromotionsnews.data.database.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mmapromotionsnews.data.database.models.PromotionDbModel

@Dao
interface DbDao {

    @Query("SELECT * FROM promotion_column")
    fun getPromotionList():LiveData<List<PromotionDbModel>>

    @Query("SELECT * FROM promotion_column WHERE promotion ==:promotion")
    fun getPromotionItem(promotion:String):LiveData<PromotionDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPromotionList(promotionList:List<PromotionDbModel>)
}