package com.nbelyse.contacts.database

import android.adservices.adid.AdId
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nbelyse.contacts.model.ContactData


@Dao
interface ContactDao {
//    Here it is possible to insert the value which exist ,so in case there is a confilict where tere is deplicated this code will replace the it
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(contactData: ContactData)
      @Query("SELECT * FROM  Contacts")
    fun getAllContacts(): LiveData<List<ContactData>>

    @Query("SELECT * FROM Contacts WHERE contactId = :contactId")
    fun getContactById(contactId: Int):LiveData<ContactData>
}