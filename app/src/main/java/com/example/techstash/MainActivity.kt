package com.example.techstash


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.techstash.ui.ArticleDetailScreen
import com.example.techstash.ui.MainScreen
import com.example.techstash.ui.navigation.Screen
import com.example.techstash.ui.theme.TechStashTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var initialUrl: String? = null
        var initialTitle: String? = null

        if (intent?.action == Intent.ACTION_SEND && intent.type == "text/plain") {
            initialUrl = intent.getStringExtra(Intent.EXTRA_TEXT)
            initialTitle = intent.getStringExtra(Intent.EXTRA_SUBJECT)
        }

        setContent {
            TechStashTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Screen.MainScreen.route
                ) {
                    composable(
                        route = Screen.MainScreen.route
                    ) {
                        MainScreen(
                            navController = navController,
                            initialUrl = initialUrl,
                            initialTitle = initialTitle
                        )
                    }

                    composable(
                        route = Screen.DetailScreen.route
                    ) { backStackEntry ->
                        val articleId =
                            backStackEntry.arguments?.getString("articleId")?.toIntOrNull() ?: 0

                        ArticleDetailScreen(
                            viewModel = hiltViewModel(),
                            articleId = articleId,
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}

