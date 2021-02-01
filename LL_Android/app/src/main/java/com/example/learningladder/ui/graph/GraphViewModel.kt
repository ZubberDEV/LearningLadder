package com.example.learningladder.ui.graph

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GraphViewModel (application: Application): ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is graph Fragment"
    }
    val text: LiveData<String> = _text

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(GraphViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return GraphViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}