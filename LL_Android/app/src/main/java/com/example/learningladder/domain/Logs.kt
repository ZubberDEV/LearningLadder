package com.example.learningladder.domain

import com.example.learningladder.db.entity.DatabaseLogs
import com.example.learningladder.db.utils.Converter
import java.sql.Date

class Logs(
     var Id: Int,
     var activityTypeId: Int,
     var date: Date?,
     var sessionStartTime: Date?,
     var sessionEndTime: Date?,
     var description: String,
     var photos: String,
)

fun Logs.asDatabaseModel(): DatabaseLogs {
    return DatabaseLogs(Id, activityTypeId, Converter.dateToTimestamp(date)!!, Converter.dateToTimestamp(sessionStartTime)!!, Converter.dateToTimestamp(sessionEndTime)!!, description, photos)
}