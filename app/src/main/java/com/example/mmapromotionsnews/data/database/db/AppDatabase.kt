package com.example.mmapromotionsnews.data.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mmapromotionsnews.data.database.models.PromotionDbModel
import com.example.mmapromotionsnews.domain.pojo.News

@Database(
    entities = [PromotionDbModel::class,
        News::class], version = 2, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        private var db: AppDatabase? = null
        private const val DB_NAME = "app.db"
        private val LOCK = Any()

        fun getInstance(context: Context): AppDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    DB_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()

                db = instance
                return instance
            }
        }
    }

    abstract fun dbDao(): DbDao
}