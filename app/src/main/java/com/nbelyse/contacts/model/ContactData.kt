package com.nbelyse.contacts.model

import androidx.room.Entity
import androidx.room.PrimaryKey

//Here  is when you want to change the nameof the table  and when you add @entity it means the space of the table is reserved
@Entity(tableName = "Contacts")
data class ContactData(
    @PrimaryKey(autoGenerate = true) var contactId: Int,
    var phoneNumber : String,
    var name : String,
    var email:String,
    var avatar:String,
    var image:String
)













