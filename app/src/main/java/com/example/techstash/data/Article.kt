package com.example.techstash.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "articles")
data class Article(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    //保存する記事のＵＲＬ
    val url: String,

    //記事のタイトル
    val title: String,

    //ユーザが自由に追加するメモ
    val memo: String,

    //既読かどうかを示すフラグ。デフォルトはfalse(未読)
    val isRead: Boolean = false,

    //著者名
    val author: String,

    //登録日時
    val createdAt: Date,

    //記事の公開日時
    val publishedAt: Date,
)