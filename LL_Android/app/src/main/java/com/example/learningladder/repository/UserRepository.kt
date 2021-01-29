package com.example.learningladder.repository

import android.os.AsyncTask
import com.example.learningladder.db.dao.ActivityDao
import com.example.learningladder.db.dao.LogsDao
import com.example.learningladder.db.dao.PhotosDao
import com.example.learningladder.domain.Activity
import com.example.learningladder.domain.Logs
import com.example.learningladder.domain.Photos
import com.example.learningladder.domain.asDatabaseModel

class UserRepository {

    private lateinit var activityDao: ActivityDao
    private lateinit var logsDao: LogsDao
    private lateinit var photoDao: PhotosDao
    


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

