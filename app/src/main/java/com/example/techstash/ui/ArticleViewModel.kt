package com.example.techstash.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.techstash.data.Article
import com.example.techstash.data.ArticleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(
    private val repository: ArticleRepository
) : ViewModel() {

    /**
     * データベースからすべての記事リストをFlowとして取得し、StateFlowへと変換する。
     */
    val allArticles: StateFlow<List<Article>> = repository.getAllArticles()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList(),
        )

    /**
     * 新しい記事をデータベースに挿入するための関数
     */
    fun insert(url: String, title: String, author: String, memo: String) {

        viewModelScope.launch {
            val now = Date()
            repository.insert(
                Article(
                    url = url,
                    title = title,
                    author = author,
                    memo = memo,
                    createdAt = now,
                    publishedAt = now
                )
            )
        }
    }

    /**
     * 既読/未読を切り替えるための関数
     */
    fun toggleReadStatus(article: Article) {
        viewModelScope.launch {
            repository.update(article.copy(isRead = !article.isRead))
        }
    }

    /**
     * 記事をデータベースから削除するための関数。
     */
    fun delete(article: Article) {
        viewModelScope.launch {
            repository.delete(article)
        }
    }
}