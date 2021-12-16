package com.example.mmapromotionsnews.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.mmapromotionsnews.data.database.db.AppDatabase
import com.example.mmapromotionsnews.data.mappers.PromotionMapper
import com.example.mmapromotionsnews.data.network.retrofit.ApiFactory
import com.example.mmapromotionsnews.domain.Repository
import com.example.mmapromotionsnews.domain.pojo.PromotionItem

class RepositoryImpl(private val application: Application):Repository {

    private val dao = AppDatabase.getInstance(application).dbDao()
    private val apiService = ApiFactory.apiService
    private val promoMapper = PromotionMapper()

    override fun getPromotionUseCase(promotion:String): LiveData<PromotionItem> {
        return Transformations.map(dao.getPromotionItem(promotion)){
            promoMapper.mapDbModelToEntity(it)
        }
    }

    override fun getPromotionListUseCase(): LiveData<List<PromotionItem>> {
        return Transformations.map(dao.getPromotionList()){
            it.map { promoMapper.mapDbModelToEntity(it) }
        }
    }

    override suspend fun loadPromotionListData() {
        try{
            val dto = apiService.loadPromotionListData()
            val dbModel = dto.map { promoMapper.mapDtoToDbModel(it) }
            dao.insertPromotionList(dbModel)
        }catch (e:Exception){}
    }

}