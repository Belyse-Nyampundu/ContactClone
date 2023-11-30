package com.nbelyse.contacts.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nbelyse.contacts.model.ContactData

//Here is to give the space our database which has table called antities
@Database(entities = arrayOf(ContactData::class), version = 1)
 abstract class ContactsDb:RoomDatabase() {
     abstract fun contactDao(): ContactDao


     companion object{
         private var database:ContactsDb? = null
         fun getDatabase(context: Context):ContactsDb{
             if(database==null){
                 database = Room
                     .databaseBuilder(context, ContactsDb::class.java,"ContactsDb")
                     .fallbackToDestructiveMigration()
                     .build()
             }
             return database as ContactsDb
         }

     }

}