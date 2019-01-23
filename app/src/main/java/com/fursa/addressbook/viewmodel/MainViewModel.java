package com.fursa.addressbook.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import com.fursa.addressbook.db.model.Contact;
import com.fursa.addressbook.db.model.ContactBook;
import com.fursa.addressbook.db.model.Person;
import com.fursa.addressbook.db.repository.ContactBookRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private ContactBookRepository repository;
    private List<ContactBook> contactBookList;

    public MainViewModel(Application application) {
        super(application);
        repository = new ContactBookRepository(application);
        contactBookList = repository.getContactBook();
    }

    public void savePerson(Person person) { repository.savePerson(person); }

    public void deletePerson(long id) { repository.deletePerson(id); }

    public void saveContact(Contact contact) { repository.saveContact(contact); }

    public void deleteContact(long id) { repository.deleteContact(id); }

    public List<ContactBook> getContactBook() { return repository.getContactBook(); }
}
