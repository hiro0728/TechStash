package com.example.techstash.ui

import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import com.example.techstash.data.Article

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ArticleItem(
    article: Article,
    onToggleReadStatus: (Article) -> Unit,
    onLongClick: (Article) -> Unit,
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp,
            )
            .combinedClickable(
                onClick = {
                    try {
                        val intent = Intent(Intent.ACTION_VIEW, article.url.toUri())
                        context.startActivity(intent)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                },
                onLongClick = {
                    onLongClick(article)
                }
            )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = article.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (article.isRead) Color.Gray else Color.Unspecified,
                )


                //著者が空かどうがをチェック
                val authorText = if (article.author.isNotBlank()) {
                    "by ${article.author}"
                } else {
                    "著者不明"
                }

                Text(
                    text = authorText,
                    color = if (article.isRead) Color.Gray else Color.Unspecified,
                )
            }
            Spacer(modifier = Modifier.width(16.dp))

            Checkbox(
                checked = article.isRead,
                onCheckedChange = { onToggleReadStatus(article) }
            )

        }
    }
}