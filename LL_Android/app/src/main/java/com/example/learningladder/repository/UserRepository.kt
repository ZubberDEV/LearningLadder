package com.example.learningladder.repository

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.learningladder.db.dao.ActivityDao
import com.example.learningladder.db.dao.LogsDao
import com.example.learningladder.db.dao.PhotosDao
import com.example.learningladder.db.database.LearningLadderDatabase
import com.example.learningladder.db.entity.asModel
import com.example.learningladder.domain.Activity
import com.example.learningladder.domain.Logs
import com.example.learningladder.domain.Photos
import com.example.learningladder.domain.asDatabaseModel

class UserRepository {

    private lateinit var activityDao: ActivityDao
    private lateinit var logsDao: LogsDao
    private lateinit var photoDao: PhotosDao

    val activityList: LiveData<List<Activity>> = Transformations.map(LearningLadderDatabase.activityDao.getActivity()){
        it.asModel()
    }
    val logList: LiveData<List<Logs>> = Transformations.map(LearningLadderDatabase.logsDao.getLogs()){
        it.asModel()
    }
    val PhotosList: LiveData<List<Photos>> = Transformations.map(LearningLadderDatabase.PhotosDao.getLogs()){
        it.asModel()
    }


    fun insert(activity: Activity) {
        activityDao.insert(activity.asDatabaseModel())
    }

    fun insert(log: Logs) {
        logsDao.insert(log.asDatabaseModel())
    }

    fun insert(photos: Photos) {
        photoDao.insert(photos.asDatabaseModel())
    }


}

