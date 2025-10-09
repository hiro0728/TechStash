package com.example.techstash.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.techstash.data.Article

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ArticleList(
    articles: List<Article>,
    onToggleReadStatus: (Article) -> Unit,
) {
    LazyColumn {
        items(
            items = articles,
            key = { it.id }
        ) { article ->
            ArticleItem(
                article = article,
                onToggleReadStatus = onToggleReadStatus,
                modifier = Modifier.animateItem()
            )
        }
    }
}


