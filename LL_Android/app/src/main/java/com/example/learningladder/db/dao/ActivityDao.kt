package com.example.learningladder.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.learningladder.db.entity.DatabaseActivity

@Dao
interface ActivityDao {

    @Query("SELECT * FROM databaseactivity")
    fun getActivity(): LiveData<List<DatabaseActivity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(activity: DatabaseActivity)
}