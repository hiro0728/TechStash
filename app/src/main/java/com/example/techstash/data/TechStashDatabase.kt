package com.example.techstash.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [Article::class],
    version = 1,
    exportSchema = false,
)
@TypeConverters(Converters::class)
abstract class TechStashDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
}