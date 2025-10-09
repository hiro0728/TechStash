package com.example.techstash.di

import android.app.Application
import androidx.room.Room
import com.example.techstash.data.ArticleDao
import com.example.techstash.data.TechStashDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    /**
     * TechStashDatabaseのインスタンスを生成する方法をHiltに教える
     */
    @Provides
    @Singleton
    fun provideDatabase(app: Application): TechStashDatabase {
        return Room.databaseBuilder(
            app,
            TechStashDatabase::class.java,
            "tech_stash_db",
        ).build()
    }

    /**
     * ArticleDaoのインスタンスを生成する方法をHiltに教える
     */
    @Provides
    fun provideArticleDao(database: TechStashDatabase): ArticleDao {
        return database.articleDao()
    }
}