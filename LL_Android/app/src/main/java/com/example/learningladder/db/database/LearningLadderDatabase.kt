package com.example.learningladder.db.database

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.learningladder.db.dao.ActivityDao
import com.example.learningladder.db.dao.LogDao
import com.example.learningladder.db.dao.PhotoDao
import com.example.learningladder.db.entity.DatabaseActivity
import com.example.learningladder.db.entity.DatabaseLog
import com.example.learningladder.db.entity.DatabasePhoto
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [DatabaseActivity::class, DatabaseLog::class, DatabasePhoto::class], version = 1, exportSchema = false)
abstract class LearningLadderDatabase: RoomDatabase(){
    abstract fun activityDao(): ActivityDao
    abstract fun logDao(): LogDao
    abstract fun photoDao(): PhotoDao

    companion object {

        private var instance: LearningLadderDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): LearningLadderDatabase {
            if(instance == null)
                instance = Room.databaseBuilder(ctx.applicationContext, LearningLadderDatabase::class.java,
                        "note_database")
                        .fallbackToDestructiveMigration()
                        .addCallback(roomCallback)
                        .build()

            return instance!!

        }

        private val roomCallback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)


            }
        }
    }
}

//private lateinit var INSTANCE: LearningLadderDatabase
//
//@InternalCoroutinesApi
//fun getDatabase(context: Context): LearningLadderDatabase {
//    synchronized(LearningLadderDatabase::class.java) {
//        if (!::INSTANCE.isInitialized) {
//            INSTANCE = Room.databaseBuilder(
//                context.applicationContext,
//                LearningLadderDatabase::class.java,
//                "learning_ladder"
//            ).build()
//        }
//    }
//    return INSTANCE
//}