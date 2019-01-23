package com.fursa.addressbook.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.fursa.addressbook.db.model.ContactBook

@Dao
interface ContactDetailsDAO {

    @Query("SELECT Person.firstName, Person.lastName, Contact.phone, Contact.email, Contact.address, Contact.city FROM Person, Contact WHERE Person.personId = Contact.personId")
    fun getContactDetails(): List<ContactBook>
}