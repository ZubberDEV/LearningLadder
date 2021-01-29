package com.example.learningladder.domain

import com.example.learningladder.db.entity.DatabaseActivity
import com.example.learningladder.db.utils.Converter

class Activity(
    var id: Int,
    var type: String,
    var scorePerMinute: Int,
    var thumbImage: String,
    var colorCode: Int
)

fun Activity.asDatabaseModel(): DatabaseActivity {
    return DatabaseActivity(id, type, scorePerMinute, thumbImage, colorCode)
}