package com.nbelyse.contacts.ui

import android.adservices.adid.AdId
import android.annotation.SuppressLint
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.LiveData
import com.nbelyse.contacts.R
import com.nbelyse.contacts.databinding.ActivityContactDetailBinding
import com.nbelyse.contacts.model.ContactData
import com.nbelyse.contacts.viewmodel.ContactsViewModel
import com.squareup.picasso.Picasso


class ContactDetailsActivity : AppCompatActivity() {
    private var contactId = 0
    private lateinit var viewModel: ContactsViewModel
    private lateinit var binding: ActivityContactDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(ContactsViewModel::class.java)

        contactId = intent.getIntExtra("CONTACT_ID", 0)
        viewModel.getContactById(contactId).observe(this, Observer { contact: ContactData? ->
            if (contact != null) {
                contactDetails(contact)
            } else {
                Toast.makeText(this, "contact not found", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun contactDetails(contact: ContactData) {
        binding.tvNameDeatail.text = contact.name
        binding.tvEmailDetails.text = contact.email
//        binding.ivImageDetail = contact.image
        if (!contact.image.isNullOrEmpty()) {
            Picasso.get()
                .load(contact.image)
                .into(binding.tvCall)
        }
    }
}

//    private fun deleteContact(contact: ContactData) {
//        viewModel.deleteContact(contact)
//        finish()


