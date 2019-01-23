package com.fursa.addressbook

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.fursa.addressbook.db.model.Contact
import com.fursa.addressbook.db.model.Person
import com.fursa.addressbook.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var contactListAdapter: ContactListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(bottomAppBar)

        viewModel = ViewModelProviders.of(this@MainActivity).get(MainViewModel::class.java)

        viewModel.savePerson(Person("Alex", "Ivanov", 1))
        viewModel.saveContact(Contact("+12 3821939821", "iva_al@gmail.com", "New York 23 av", "New York", 1, 1))
        viewModel.contactBook.forEach {
            Log.d("MainActivity", "First name: ${it.firstName} Last name: ${it.lastName} Phone: ${it.phone} Email: ${it.email}")
        }

        contactListAdapter = ContactListAdapter(viewModel.contactBook)
        recyclerView.layoutManager = LinearLayoutManager(baseContext)
        recyclerView.adapter = contactListAdapter
    }
}
