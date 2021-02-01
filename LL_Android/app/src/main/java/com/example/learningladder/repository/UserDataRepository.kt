package com.example.learningladder.repository

import android.app.Application
import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.learningladder.db.dao.ActivityDao
import com.example.learningladder.db.dao.LogDao
import com.example.learningladder.db.dao.PhotoDao
import com.example.learningladder.db.database.LearningLadderDatabase
import com.example.learningladder.db.entity.asModel
import com.example.learningladder.domain.Activity
import com.example.learningladder.domain.Log
import com.example.learningladder.domain.Photo
import com.example.learningladder.domain.asDatabaseModel

class UserDataRepository(ctx: Context) {

    private val database = LearningLadderDatabase.getInstance(ctx)

    private var activityDao: ActivityDao
    private var logDao: LogDao
    private var photoDao: PhotoDao

    private var allActivity: LiveData<List<Activity>>

    init {
        activityDao = database.activityDao()
        logDao = database.logDao()
        photoDao = database.photoDao()
        allActivity = Transformations.map(activityDao.getActivity()){
            it.asModel()
        }
    }

    val logList: LiveData<List<Log>> = Transformations.map(logDao.getLog()){
        it.asModel()
    }

    val photoList: LiveData<List<Photo>> = Transformations.map(photoDao.gatPhoto()){
        it.asModel()
    }

    @Throws(Exception::class)
    fun insert(activity: Activity) {
        activityDao.insert(activity.asDatabaseModel())
    }

    @Throws(Exception::class)
    fun insert(log: Log) {
        logDao.insert(log.asDatabaseModel())
    }

    @Throws(Exception::class)
    fun insert(photos: Photo) {
        photoDao.insert(photos.asDatabaseModel())
    }

    fun getAllActivity(): LiveData<List<Activity>> {
        allActivity = Transformations.map(activityDao.getActivity()){
            it.asModel()
        }
        return allActivity
    }

}

