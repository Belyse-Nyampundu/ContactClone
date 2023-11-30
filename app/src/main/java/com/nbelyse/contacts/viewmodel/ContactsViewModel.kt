package com.nbelyse.contacts.viewmodel

import android.adservices.adid.AdId
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nbelyse.contacts.model.ContactData
import com.nbelyse.contacts.repository.ContactsRepository
import kotlinx.coroutines.launch

class ContactsViewModel: ViewModel() {
    val contactsRepo = ContactsRepository()
    lateinit var contactLiveData:LiveData<ContactData>

    fun saveContact(contact:ContactData){
        viewModelScope.launch {
            contactsRepo.saveContact(contact)
        }

    }

    fun getContacts():LiveData<List<ContactData>>{
        return contactsRepo.getDbContacts()
    }
    fun getContactById(contactId: Int):LiveData<ContactData>{
         return   contactsRepo.getContactById(contactId)

    }
}