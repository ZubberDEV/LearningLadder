package com.example.learningladder.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.learningladder.db.entity.DatabaseLog

@Dao
interface LogDao {

    @Query("SELECT * FROM DatabaseLog")
    fun getLog(): LiveData<List<DatabaseLog>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(log: DatabaseLog)
}