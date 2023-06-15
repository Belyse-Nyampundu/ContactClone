package com.nbelyse.contacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.Toast
import com.nbelyse.contacts.databinding.ActivityRegisterContactsBinding

class RegisterContacts : AppCompatActivity() {
    lateinit var binding: ActivityRegisterContactsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterContactsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)





    }


//    lateinit var tvPrev: Button
//    tvPrev =findViewById(R.id.btnPrevv)
//    tvPrev.setOnClickListener {
//        val intent=Intent(this,MainActivity::class.java)
//        startActivity(intent)
//    }



    override fun onResume() {
        super.onResume()
        validateRegisterContacts()
        clearErrorOnType()
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
            binding. tilName2.error = "name is required"
            error = true
        }

        if (contacts.isBlank()){
            binding.    tilContact2.error = "contacts is required"
            error = true
        }

        if (email.isBlank()){
            binding.     tilEmail2.error = "Email is required"
            error = true
        }


        if (!error){
            Toast.makeText(this,"$name,$contacts, $email", Toast.LENGTH_LONG).show()
        }

    }
}