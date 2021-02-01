package com.example.learningladder.ui.type

import android.app.Activity
import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class TypeViewModel(application: Application) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is type Fragment"
    }
    val text: LiveData<String> = _text

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(TypeViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return TypeViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }

}