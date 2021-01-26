package com.example.learningladder.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.learningladder.db.entity.DatabaseLogs

@Dao
interface LogsDao {

    @Query("SELECT * FROM databaselogs")
    fun getLog(): LiveData<List<DatabaseLogs>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(logs: List<DatabaseLogs>)
}