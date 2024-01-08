package com.abhishek.showrecyclerviewdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.abhishek.showrecyclerviewdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter:UserAdapter
     private var userlist = ArrayList<UserData>()
    private lateinit var recyclerView: RecyclerView
    var position: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = UserAdapter(userlist)
        recyclerView = binding.recyclerview
        userlist= arrayListOf<UserData>()
//        binding.recyclerview.adapter = adapter

        binding.btnclick.setOnClickListener {
            val firstname = binding.edtfirstname.text.toString()
            val lastname = binding.edtlastname.text.toString()
            val phone = binding.edtphone.text.toString()

            binding.edtfirstname.setText("")
            binding.edtlastname.setText("")
            binding.edtphone.setText("")

            if (firstname.isEmpty() || lastname.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this@MainActivity, "Update record", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            } else {
                val user = UserData(firstname, lastname, phone)

                if (position >= 0 && position < userlist.size) {
                    userlist[position] = user
                } else {
                    userlist.add(user)
                }
                recyclerView.adapter = UserAdapter(userlist)
            }
        }

    }
}