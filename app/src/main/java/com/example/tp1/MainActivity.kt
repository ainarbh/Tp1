package com.example.tp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rclNames = findViewById<RecyclerView>(R.id.rclNames)
        val btnUpdateList = findViewById<Button>(R.id.btnUpdateList)
        // If size of the all items are equal and won't change for a better performance

        rclNames.setHasFixedSize(true)
        //rclNames.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rclNames.layoutManager = LinearLayoutManager(this)
        val nameList = getListOfNames()
        val namesAdapter = NameAdapter(nameList)
        rclNames.adapter = namesAdapter

        btnUpdateList.setOnClickListener {
            nameList[nameList.size - 1] = "Hello! I've been updated right now :)"
            namesAdapter.notifyDataSetChanged()
        }

        namesAdapter.itemClickListener = { position, name ->
            Toast.makeText(this, "position: $position - name: $name", Toast.LENGTH_SHORT)
                .show()
        }




        // Setting our RecyclerView's layout manager equal to LinearLayoutManager

    }
    // This function just creates a list of names for us
    private fun getListOfNames(): MutableList<String> {
        val nameList = mutableListOf<String>()
        nameList.add("ahmed")
        nameList.add("yassine")
        nameList.add("sonia")
        nameList.add("mariem")
        nameList.add("taha")
        nameList.add("oussema")
        nameList.add("fatma")
        nameList.add("haythem")
        nameList.add("ayoub")
        nameList.add("aya")
        nameList.add("houda")
        return nameList
    }
}
