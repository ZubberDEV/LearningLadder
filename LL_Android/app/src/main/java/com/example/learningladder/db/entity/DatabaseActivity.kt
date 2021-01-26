package com.example.learningladder.db.entity

import android.app.Activity
import android.media.Image
import android.view.autofill.AutofillId
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DatabaseActivity(@PrimaryKey(autoGenerate = true)
                            val id: Int,
                            val type: String,
                            val scorePerMinute: Int,
                            val thumbImage: String,
                            val colorCode: Int)

fun List<DatabaseActivity>.asModel(): List<Activity>{
    return map {
        Activity()
    }
}
