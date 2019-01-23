package com.fursa.addressbook.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contact")
data class Contact(
    val phone: String,
    val email: String,
    val address: String,
    val city: String,

    @PrimaryKey(autoGenerate = true)
    val contactId: Long,

    @ColumnInfo(name = "personId")
    val personId: Long
)