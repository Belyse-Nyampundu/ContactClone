package com.nbelyse.contacts.repository

import android.adservices.adid.AdId
import androidx.lifecycle.LiveData
import com.nbelyse.contacts.MyContactCloneApp
import com.nbelyse.contacts.database.ContactsDb
import com.nbelyse.contacts.model.ContactData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class ContactsRepository {

    val database =  ContactsDb.getDatabase(MyContactCloneApp.appContext)
    suspend fun saveContact(contact: ContactData){
        return withContext(Dispatchers.IO){
            database.contactDao().insertContact(contact)
        }
    }

    fun getDbContacts(): LiveData<List<ContactData>>{
        return database.contactDao().getAllContacts()
    }
    fun getContactById(contactId: Int):LiveData<ContactData>{
        return database.contactDao().getContactById(contactId)
    }
}