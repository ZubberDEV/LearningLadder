package com.example.learningladder.domain

import android.media.Image
import android.view.autofill.AutofillId
import java.io.Serializable

open class Activity ():Serializable {
    open var id: Int? = null
    open var type: String? = null
    open var scorePerMinute: Int? =null
    open var thumbImage: String? = null
    open var colorCode: Int? = null
}