package com.example.learningladder.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.learningladder.db.entity.DatabasePhotos

@Dao
interface PhotosDao {

    @Query("SELECT * FROM databasephotos")
    fun gatPhoto(): LiveData<List<DatabasePhotos>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(photo: DatabasePhotos)
}