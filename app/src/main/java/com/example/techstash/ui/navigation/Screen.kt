package com.example.techstash.ui.navigation

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object DetailScreen : Screen("detail_screen/{articleId}") {
        fun createRoute(articleId: Int) = "detail_screen/$articleId"
    }
}