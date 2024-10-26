package com.example.task_015

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    var notes: MutableList<User> = mutableListOf()

    private lateinit var userViewModel: UserViewModel
    private lateinit var listViewLV: ListView
    private lateinit var nameET: EditText
    private lateinit var ageET: EditText
    private lateinit var saveBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        listViewLV = findViewById(R.id.listViewLV)

        nameET = findViewById(R.id.nameET)
        ageET = findViewById(R.id.ageET)
        saveBTN = findViewById(R.id.saveBTN)

        userViewModel.mListUsers.observe(this, {
            notes.clear()
            notes = it.toMutableList()
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, notes)
            listViewLV.adapter = adapter
            adapter.notifyDataSetChanged()
        })

        saveBTN.setOnClickListener{
            if (nameET.text.toString() != "" && ageET.text.toString() != "")
            {
                userViewModel.listUsers.add(User(nameET.text.toString(), ageET.text.toString().toInt()))
                userViewModel.mListUsers.value = userViewModel.listUsers

                nameET.text.clear()
                ageET.text.clear()
            }
        }
    }
}
