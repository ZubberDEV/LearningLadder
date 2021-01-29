package com.example.learningladder.db.entity

import android.provider.ContactsContract.Contacts.Photo
import android.view.autofill.AutofillId
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.learningladder.domain.Photos

@Entity
data class DatabasePhotos(@PrimaryKey(autoGenerate = true)
                       val logId: Int,
                          val path: String)

fun List<DatabasePhotos>.asModel(): List<Photos>{
    return map {
        Photos(it.logId, it.path)
    }
}

