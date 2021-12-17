package com.example.mmapromotionsnews.data

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.mmapromotionsnews.data.database.db.AppDatabase
import com.example.mmapromotionsnews.data.mappers.NewsMapper
import com.example.mmapromotionsnews.data.network.retrofit.ApiFactory
import com.example.mmapromotionsnews.domain.NewsRepository
import com.example.mmapromotionsnews.domain.pojo.News

class NewsRepositoryImpl(private val application: Application) : NewsRepository {

    private val dao = AppDatabase.getInstance(application).dbDao()
    private val apiService = ApiFactory.apiService
    private val newsMapper = NewsMapper()

    override fun getNews(): LiveData<List<News>> {
        return dao.getNewsList()
    }

    override suspend fun loadNews() {
        try {
            val dto = apiService.loadNewsList()
            val entity = dto.map { newsMapper.mapDtoToEntity(it) }
            dao.insertNewsList(entity)
        } catch (e: Exception) {
        }
    }


}