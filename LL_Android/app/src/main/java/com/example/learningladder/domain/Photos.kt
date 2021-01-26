package com.example.learningladder.domain

import android.media.Image
import android.view.autofill.AutofillId
import java.io.Serializable
import java.sql.Time
import java.util.*

open class Photos (): Serializable {
    open var logId: Int? = null
    open var path: String? = null
}