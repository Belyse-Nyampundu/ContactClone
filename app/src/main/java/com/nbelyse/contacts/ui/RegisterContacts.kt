package com.nbelyse.contacts.ui

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.content.FileProvider
import com.nbelyse.contacts.R
import com.nbelyse.contacts.databinding.ActivityRegisterContactsBinding
import com.nbelyse.contacts.model.ContactData
import com.nbelyse.contacts.viewmodel.ContactsViewModel
import java.io.File

class   RegisterContacts : AppCompatActivity() {
    lateinit var binding: ActivityRegisterContactsBinding
    private val contactsViewModel: ContactsViewModel by viewModels()
    lateinit var photoFile:File

//    lateinit var fusedLocationCLient:FusedLocationProviderClient
//    lateinit var


    val cameraLauncher=registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){ result->
        if (result.resultCode == Activity.RESULT_OK){
            val photo= BitmapFactory.decodeFile(photoFile.absolutePath)
            binding.ivImage.setImageBitmap(photo)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterContactsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        fusedLocationCLient = LOCATION_SERVICE.getFusedLocationProviderClient()
    }

    override fun onResume() {
        super.onResume()
        binding.btnSave.setOnClickListener {
            validateRegisterContacts()
        }
        clearErrorOnType()
        binding.ivImage.setOnClickListener {
            capturePhoto()
        }
    }
      private fun capturePhoto(){
          val photoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
          photoFile = getPhotoFile("photo_${System.currentTimeMillis()}")
          val fileUri = FileProvider.getUriForFile(this,"nbelyse.contacts.provider",photoFile)
          photoIntent.putExtra(MediaStore.EXTRA_OUTPUT,fileUri)
          cameraLauncher.launch(photoIntent)
      }

    private fun getPhotoFile(fileName: String):File{
        val folder = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val tempFile = File.createTempFile(fileName,".jpeg",folder)
        return tempFile
    }

    fun clearErrorOnType(){
        binding.etName2.addTextChangedListener ( object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilName2.error = null
            }

            override fun afterTextChanged(s: Editable?) {

            }
        } )
        binding.etContact2.addTextChangedListener ( object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilContact2.error = null

            }

            override fun afterTextChanged(s: Editable?) {

            }
        } )
        binding.etEmail2.addTextChangedListener ( object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.tilEmail2.error = null
            }

            override fun afterTextChanged(s: Editable?) {

            }
        } )
    }


    fun validateRegisterContacts(){
        val name =binding. etName2.text.toString()
        val contacts = binding.etContact2.text.toString()
        val email =binding. etEmail2.text.toString()

        var error = false

        if (name.isBlank()){
            binding. tilName2.error = getString(R.string.name_is_required)
            error = true
        }

        if (contacts.isBlank()){
            binding.    tilContact2.error = getString(R.string.contacts_is_required)


            error = true
        }

        if (email.isBlank()){
            binding.tilEmail2.error = getString(R.string.email_is_required)

            error = true
        }


        if (!error){
            val newContact = ContactData(contactId = 0,name = name,email = email, phoneNumber = contacts, avatar = "",image=photoFile.absolutePath)
            contactsViewModel.saveContact(newContact)
           Toast.makeText(this,"successufully saved",Toast.LENGTH_LONG).show()

            finish()
        }

    }
}