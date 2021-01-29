package com.example.learningladder.domain

import com.example.learningladder.db.entity.DatabasePhotos


class Photos (
    var logId: Int,
    var path: String,
)

fun Photos.asDatabaseModel(): DatabasePhotos {
    return DatabasePhotos(logId, path)
}