package com.example.learningladder

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.learningladder.domain.Activity
import com.example.learningladder.repository.UserDataRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ActivityTest {

    private val context = ApplicationProvider.getApplicationContext<Context>()
    lateinit var userDataRepository: UserDataRepository

    @Before
    fun initialize() {
        userDataRepository = UserDataRepository(context)
    }

    @Test
    fun testAddingActivity() {
        val activityId = 12
        val type = "Jogging"
        val scorePerMinute = 10
        val thumbImage = ""
        val colorCode = 100
        val activity = Activity(activityId, type, scorePerMinute, thumbImage, colorCode)

        userDataRepository.insert(activity)

        val allActivity = userDataRepository.getAllActivity()
        val list = allActivity.value
       //assert(allActivity.value!!.size == 1)
    }
}