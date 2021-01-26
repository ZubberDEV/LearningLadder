package com.example.learningladder.domain

import android.view.autofill.AutofillId
import java.io.Serializable
import java.util.*

open class Logs (): Serializable {
    open var Id: Int? = null
    open var activityTypeId: Int? = null
    open var date: Date? = null
    open var sessionStartTime: Date? = null
    open var sessionEndTime: Date? = null
    open var description: String? = null
    open var photos: String? = null
}