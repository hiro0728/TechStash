package com.example.techstash.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article)

    @Update
    suspend fun update(article: Article)

    @Delete
    suspend fun delete(article: Article)

    @Query("SELECT * FROM articles ORDER BY isRead ASC, createdAt DESC")
    fun getAllArticles(): Flow<List<Article>>

    /**
     *指定されたIDの記事を1件だけ取得する。
     * @param id 取得したい記事のID
     * @return 該当する記事。見つからなかった場合はnullを返す。
     */
    @Query("SELECT * FROM articles WHERE id = :id")
    fun getArticleById(id: Int): Flow<Article?>

}
