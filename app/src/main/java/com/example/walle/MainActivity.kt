package com.example.walle

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.Toast.makeText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.datepicker.MaterialTextInputPicker
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerid)

        val list:ArrayList<catdata> = ArrayList<catdata>()

        list.add(catdata("backgrounds",R.drawable.backgrounds))
        list.add(catdata("nature",R.drawable.nature))
        list.add(catdata("religion",R.drawable.religion))
        list.add(catdata("computer",R.drawable.computer))
        list.add(catdata("industry",R.drawable.industry))
        list.add(catdata("travel",R.drawable.travel))
        list.add(catdata("animals",R.drawable.animals))
        list.add(catdata("health",R.drawable.health))
        list.add(catdata("people",R.drawable.people))
        list.add(catdata("transportation",R.drawable.transportation))
        list.add(catdata("buildings",R.drawable.buildings))
        list.add(catdata("places",R.drawable.places))
        list.add(catdata("fashion",R.drawable.fasion))
        list.add(catdata("food",R.drawable.food))
        list.add(catdata("science",R.drawable.science))
        list.add(catdata("business",R.drawable.business))
        list.add(catdata("sports",R.drawable.sports))
        list.add(catdata("education",R.drawable.education))


        val adapter = catAdapter(list,applicationContext)
        recyclerView.adapter = adapter
        recyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)


        val editText = findViewById<TextInputLayout>(R.id.outlinedTextField)
        val searchbutton = findViewById<Button>(R.id.outlinedButton)

        searchbutton.setOnClickListener(View.OnClickListener {

        })

    }
}

