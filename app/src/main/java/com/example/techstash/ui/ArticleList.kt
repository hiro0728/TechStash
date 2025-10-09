package com.example.techstash.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.techstash.data.Article

@Composable
fun ArticleList(
    articles: List<Article>,
    onToggleReadStatus: (Article) -> Unit,
) {
    LazyColumn {
        items(items = articles) { article ->
            ArticleItem(
                article = article,
                onToggleReadStatus = onToggleReadStatus
            )
        }
    }
}