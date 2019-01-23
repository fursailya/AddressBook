package com.fursa.addressbook.db.repository;

import android.app.Application;
import com.fursa.addressbook.db.dao.ContactDAO;
import com.fursa.addressbook.db.dao.ContactDetailsDAO;
import com.fursa.addressbook.db.dao.PersonDAO;
import com.fursa.addressbook.db.model.Contact;
import com.fursa.addressbook.db.model.ContactBook;
import com.fursa.addressbook.db.model.Person;
import com.fursa.addressbook.db.room.InnerDB;

import java.util.List;

public class ContactBookRepository {
    private PersonDAO personDAO;
    private ContactDAO contactDAO;
    private ContactDetailsDAO contactDetailsDAO;
    private List<ContactBook> contactBookList;
    private InnerDB db;

    public ContactBookRepository(Application app) {
        db = InnerDB.create(app, false);
        personDAO = db.getPersonDAO();
        contactDAO = db.getContactDAO();
        contactDetailsDAO = db.getContactDetailsDAO();

        contactBookList = contactDetailsDAO.getContactDetails();
    }

    public void savePerson(Person person) { personDAO.save(person); }

    public void deletePerson(long id) { personDAO.delete(id); }

    public void saveContact(Contact contact) { contactDAO.save(contact); }

    public void deleteContact(long id) { contactDAO.delete(id); }

    public List<ContactBook> getContactBook() { return contactDetailsDAO.getContactDetails(); }
}
