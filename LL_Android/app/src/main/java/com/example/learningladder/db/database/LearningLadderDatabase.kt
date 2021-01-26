package com.example.learningladder.db.database

import android.content.Context
import androidx.room.*
import com.example.learningladder.db.dao.ActivityDao
import com.example.learningladder.db.dao.LogsDao
import com.example.learningladder.db.dao.PhotosDao
import com.example.learningladder.db.entity.DatabaseActivity
import com.example.learningladder.db.entity.DatabaseLogs
import com.example.learningladder.db.entity.DatabasePhotos
import com.example.learningladder.db.utils.Converters
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [DatabaseActivity::class, DatabaseLogs::class, DatabasePhotos::class], version = 1, exportSchema = false)
abstract class LearningLadderDatabase: RoomDatabase(){
    abstract val activityDao: ActivityDao
    abstract val logsDao: LogsDao
    abstract val photosDao: PhotosDao
}

private lateinit var INSTANCE: LearningLadderDatabase

@InternalCoroutinesApi
fun getDatabase(context: Context): LearningLadderDatabase {
    synchronized(LearningLadderDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                LearningLadderDatabase::class.java,
                "learning_ladder"
            ).build()
        }
    }
    return INSTANCE
}