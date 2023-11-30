package com.nbelyse.contacts.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.nbelyse.contacts.ContactRvAdapter
import com.nbelyse.contacts.databinding.ActivityMainBinding
import com.nbelyse.contacts.model.ContactData
import com.nbelyse.contacts.viewmodel.ContactsViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val contactsViewModel:ContactsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


         binding.fbAdd.setOnClickListener {
             val intent = Intent(this, RegisterContacts::class.java)
             startActivity(intent)
         }
   contactsViewModel.getContacts()
       .observe(this, Observer { contactListItem->
           displayContact(contactListItem)
       })
    }

    override fun onResume() {
        super.onResume()
        contactsViewModel.getContacts().observe(this
        ) { contacts -> displayContact(contacts) }


    }

    fun displayContact(contactList:List<ContactData>){

        binding.rvContacts.layoutManager = LinearLayoutManager(this)
        var contact = ContactRvAdapter(contactList,this)
        binding.rvContacts.adapter = contact



    }
    }
