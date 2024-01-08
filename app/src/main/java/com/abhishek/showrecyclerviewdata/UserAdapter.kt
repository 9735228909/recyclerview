package com.abhishek.showrecyclerviewdata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(val list: ArrayList<UserData>):RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(itemViem:View):RecyclerView.ViewHolder(itemViem){
        val firstname = itemViem.findViewById<TextView>(R.id.txtfirstname)
        val lastname = itemViem.findViewById<TextView>(R.id.txtlastname)
        val phone = itemViem.findViewById<TextView>(R.id.txtphone)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list,parent,false)
       return UserViewHolder(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
       val currentuser = list[position]

        holder.firstname.text = currentuser.firstname
        holder.lastname.text = currentuser.lastname
        holder.phone.text = currentuser.phone
    }

}