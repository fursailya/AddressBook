package com.fursa.addressbook.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fursa.addressbook.db.model.Contact

@Dao
interface ContactDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(contact: Contact)

    @Query("DELETE FROM Contact WHERE contactId=:id")
    fun delete(id: Long)
}