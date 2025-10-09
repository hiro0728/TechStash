package com.example.techstash.data

import androidx.room.TypeConverter
import java.util.Date

class Converters {

    /**
     *　Long型からDateオブジェクトへと変換する
     * @param value データベースに保存されているタイムスタンプ(ミリ秒)
     * @return 変換されたDateオブジェクト。nullの場合はnullを返す
     */
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        // valueがnullでなければ、その値を使ってDateオブジェクトを生成する
        return value?.let { Date(it) }
    }

    /**
     * DateオブジェクトからLong型に変換する
     * @param date 保存したいDateオブジェクト
     * @return 変換されたタイムスタンプ。nullの場合はnullを返す。
     */
    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        //dateがnullでなければ、その時刻をミリ秒単位のLong型で取得する。
        return date?.time
    }
}