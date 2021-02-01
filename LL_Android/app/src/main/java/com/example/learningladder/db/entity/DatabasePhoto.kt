package com.example.learningladder.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.learningladder.domain.Photo

@Entity
data class DatabasePhoto(@PrimaryKey(autoGenerate = true)
                       val logId: Int,
                          val path: String)

fun List<DatabasePhoto>.asModel(): List<Photo>{
    return map {
        Photo(it.logId, it.path)
    }
}

