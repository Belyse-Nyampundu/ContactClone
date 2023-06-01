package com.nbelyse.contacts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nbelyse.contacts.databinding.ContactListItemBinding

class ContactRvAdapter(var contactList:List<ContactData>): RecyclerView.Adapter<ContactViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var binding = ContactListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ContactViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        var contact = contactList[position]
        holder.binding.apply {
            tvContact.text = contact.contact
            tvEmail.text = contact.email
            tvName.text = contact.name
        }
    }
}
class ContactViewHolder(var binding: ContactListItemBinding): RecyclerView.ViewHolder(binding.root){

}