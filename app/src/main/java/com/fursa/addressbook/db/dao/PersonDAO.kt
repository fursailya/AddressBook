package com.fursa.addressbook.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fursa.addressbook.db.model.Person

@Dao
interface PersonDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(person: Person)

    @Query("DELETE FROM Person WHERE personId=:id")
    fun delete(id: Long)
}