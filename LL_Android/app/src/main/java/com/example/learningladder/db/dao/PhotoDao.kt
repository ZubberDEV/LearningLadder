package com.example.learningladder.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.learningladder.db.entity.DatabasePhoto

@Dao
interface PhotoDao {

    @Query("SELECT * FROM DatabasePhoto")
    fun gatPhoto(): LiveData<List<DatabasePhoto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(photo: DatabasePhoto)
}