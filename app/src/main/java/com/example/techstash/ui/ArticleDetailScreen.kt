package com.example.techstash.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArticleDetailScreen(
    viewModel: ArticleViewModel = hiltViewModel(),
    articleId: Int
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("記事詳細") })
        }
    ) { paddingValues ->
        Text(text = "表示する記事のID: $articleId")
    }
}