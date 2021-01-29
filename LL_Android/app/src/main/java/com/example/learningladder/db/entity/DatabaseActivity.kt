package com.example.learningladder.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.learningladder.domain.Activity

@Entity
data class DatabaseActivity(@PrimaryKey(autoGenerate = true)
                            val id: Int,
                            val type: String,
                            val scorePerMinute: Int,
                            val thumbImage: String,
                            val colorCode: Int)

fun List<DatabaseActivity>.asModel(): List<Activity>{
    return map {
        Activity(it.id, it.type, it.scorePerMinute, it.thumbImage, it.colorCode)
    }
}
