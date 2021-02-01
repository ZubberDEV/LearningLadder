package com.example.learningladder.domain

import com.example.learningladder.db.entity.DatabasePhoto


class Photo (
    var logId: Int,
    var path: String,
)

fun Photo.asDatabaseModel(): DatabasePhoto {
    return DatabasePhoto(logId, path)
}