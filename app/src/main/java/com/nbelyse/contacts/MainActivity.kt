package com.nbelyse.contacts

import android.content.Intent
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


         binding.fbAdd.setOnClickListener {
             val intent = Intent(this,RegisterContacts::class.java)
             startActivity(intent)
         }
    }

    override fun onResume() {
        super.onResume()
        displayContact()
    }

    fun displayContact(){
        var contact1 = ContactData("+250783239291","Belyse bebe","belysenyampundu@gmail.com","https://images.unsplash.com/photo-1524660988542-c440de9c0fde?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80")
        var contact2 = ContactData("+250787931168","Mere","racheal@gmail.com","https://images.unsplash.com/photo-1529758146491-1e11fd721f77?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTZ8fHByb2ZpbGUlMjBwaWN0dXJlJTIwYWZyaWNhbnxlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&w=500&q=60")
        var contact3 = ContactData("+250787931168","Rita","rita@gmail.com","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRjxj4WVvb8pvqwDUbrNijKsz8VWDBaGnEMRg&usqp=CAU")
        var contact4 = ContactData("+250787931168","Anitha","anitha@gmail.com","https://images.unsplash.com/photo-1524660988542-c440de9c0fde?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80")
        var contact5 = ContactData("+250787931168","Mugabo","mugabo@gmail.com","https://images.unsplash.com/photo-1524660988542-c440de9c0fde?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80")
        var contact6 = ContactData("+250787931168","Joella","mujawabera@gmail.com","https://images.unsplash.com/photo-1524660988542-c440de9c0fde?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80")
        var contact7 = ContactData("+250787931168","Janette","janette@gmail.com","https://images.unsplash.com/photo-1524660988542-c440de9c0fde?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80")
        var contact8 = ContactData("+250787931168","Sonia","sonia@gmail.com","https://images.unsplash.com/photo-1524660988542-c440de9c0fde?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80")
        var contact9 = ContactData("+250787931168","Janette","janette@gmail.com","https://images.unsplash.com/photo-1524660988542-c440de9c0fde?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80")
        var contact10 = ContactData("+250787931168","Sonia","sonia@gmail.com","https://images.unsplash.com/photo-1524660988542-c440de9c0fde?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=870&q=80")
        var contactList = listOf<ContactData>(contact1,contact2,contact3,contact4,contact5,contact6,contact7,contact8,contact9,contact10)
        binding.rvContacts.layoutManager = LinearLayoutManager(this)
        var contact = ContactRvAdapter(contactList)
        binding.rvContacts.adapter = contact


    }
    }
