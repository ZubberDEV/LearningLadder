package com.example.learningladder.db.utils

import java.sql.Date

object Converter {
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}