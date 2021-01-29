package com.example.learningladder.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.learningladder.db.utils.Converter
import com.example.learningladder.domain.Logs

@Entity
data class DatabaseLogs(@PrimaryKey(autoGenerate = true)
                        val Id: Int,
                        val activityTypeId: Int,
                        val date: Long,
                        val sessionStartTime: Long,
                        val sessionEndTime: Long,
                        val description: String,
                        val photos: String)

fun List<DatabaseLogs>.asModel(): List<Logs>{
    return map {
        Logs(it.Id, it.activityTypeId, Converter.fromTimestamp(it.date), Converter.fromTimestamp(it.sessionStartTime), Converter.fromTimestamp(it.sessionEndTime))
    }
}