package com.fursa.addressbook.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Person")
data class Person(
    val firstName: String,
    val lastName: String,

    @PrimaryKey(autoGenerate = true)
    val personId: Long

)