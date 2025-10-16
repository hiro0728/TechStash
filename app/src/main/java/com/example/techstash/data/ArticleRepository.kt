package com.example.techstash.data

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRepository @Inject constructor(private val articleDao: ArticleDao) {

    fun getAllArticles(): Flow<List<Article>> = articleDao.getAllArticles()

    suspend fun insert(article: Article) {
        articleDao.insert(article)
    }

    suspend fun update(article: Article) {
        articleDao.update(article)
    }

    suspend fun delete(article: Article) {
        articleDao.delete(article)
    }

    /**
     * IDを指定して単一の記事を取得する。
     */
    fun getArticleById(id: Int): Flow<Article?> {
        return articleDao.getArticleById(id)
    }
}