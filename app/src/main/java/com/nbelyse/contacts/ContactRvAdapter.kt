package com.nbelyse.contacts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nbelyse.contacts.databinding.ActivityContactDetailBinding
import com.nbelyse.contacts.databinding.ContactListItemBinding
import com.nbelyse.contacts.model.ContactData
import com.nbelyse.contacts.ui.ContactDetailsActivity
//import com.nbelyse.contacts.ui.ContactDetailActivity
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ContactRvAdapter(var contactList: List<ContactData>, val context: Context) :
    RecyclerView.Adapter<ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var binding = ContactListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        var contact = contactList.get(position)

        var binding = holder.binding
        binding.tvContact.text = contact.phoneNumber
        binding.tvEmail.text = contact.email
        binding.tilName.text = contact.name
        if (contact.avatar.isNotBlank()) {


            Picasso
                .get()
                .load(contact.avatar)
                .resize(80, 80)
                .centerCrop()
                .transform(CropCircleTransformation())
                .into(binding.ivAvatar)
        }
        binding.cvContact.setOnClickListener {
            val intent = Intent(context, ContactDetailsActivity::class.java)
            intent.putExtra("CONTACT_ID", contact.contactId)
            context.startActivity(intent)
        }

    }
}

class ContactViewHolder(var binding: ContactListItemBinding) : RecyclerView.ViewHolder(binding.root)

