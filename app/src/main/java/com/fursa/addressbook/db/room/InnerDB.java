package com.fursa.addressbook.db.room;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.fursa.addressbook.db.dao.ContactDAO;
import com.fursa.addressbook.db.dao.ContactDetailsDAO;
import com.fursa.addressbook.db.dao.PersonDAO;
import com.fursa.addressbook.db.model.Contact;
import com.fursa.addressbook.db.model.Person;

@Database(entities = {Person.class, Contact.class}, version = 1, exportSchema = false)
public abstract class InnerDB extends RoomDatabase {

    private static InnerDB instance;

    public static InnerDB create(Context c, boolean inMemory) {
        if(inMemory) {
            instance = Room.inMemoryDatabaseBuilder(c.getApplicationContext(), InnerDB.class)
                    .allowMainThreadQueries()
                    .build();
        } else {
            instance = Room.databaseBuilder(c.getApplicationContext(), InnerDB.class, "contact_book.db")
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }

    public abstract PersonDAO getPersonDAO();
    public abstract ContactDAO getContactDAO();
    public abstract ContactDetailsDAO getContactDetailsDAO();
}
