package com.nbelyse.contacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nbelyse.contacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        displayContact()
    }

    fun displayContact(){
        var contact1 = ContactData("+250783239291","Belyse bebe","belysenyampundu@gmail.com")
        var contact2 = ContactData("+250787931168","Racheal","racheal@gmail.com")
        var contact3 = ContactData("+250787931168","Rita","rita@gmail.com")
        var contact4 = ContactData("+250787931168","Anitha","anitha@gmail.com")
        var contact5 = ContactData("+250787931168","Mugabo","mugabo@gmail.com")
        var contact6 = ContactData("+250787931168","Joella","mujawabera@gmail.com")
        var contact7 = ContactData("+250787931168","Janette","janette@gmail.com")
        var contact8 = ContactData("+250787931168","Sonia","sonia@gmail.com")

        var contactList = listOf<ContactData>(contact1,contact2,contact3,contact4,contact5,contact6,contact7,contact8)
        binding.rvContacts.layoutManager = LinearLayoutManager(this)
        var contact = ContactRvAdapter(contactList)
        binding.rvContacts.adapter = contact


    }
    }
