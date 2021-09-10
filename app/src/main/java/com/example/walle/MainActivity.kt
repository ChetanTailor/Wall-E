package com.example.walle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
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


        //for search query only
        val editText = findViewById<TextInputLayout>(R.id.outlinedTextField)
        val searchbutton = findViewById<Button>(R.id.outlinedButton)
        searchbutton.setOnClickListener(View.OnClickListener {
            val intent = Intent(applicationContext,Wallpapers::class.java)
            intent.putExtra("Search", editText.editText?.text.toString() )
            startActivity(intent);
        })
    }

    fun grayscale(view: android.view.View) {
        val intent = Intent(applicationContext,Wallpapers::class.java)
        intent.putExtra("colors", "grayscale" )
        startActivity(intent);
    }
    fun red(view: android.view.View) {
        val intent = Intent(applicationContext,Wallpapers::class.java)
        intent.putExtra("colors", "red" )
        startActivity(intent);
    }
    fun orange(view: android.view.View) {
        val intent = Intent(applicationContext,Wallpapers::class.java)
        intent.putExtra("colors", "orange" )
        startActivity(intent);
    }
    fun green(view: android.view.View) {
        val intent = Intent(applicationContext,Wallpapers::class.java)
        intent.putExtra("colors", "green" )
        startActivity(intent);
    }
    fun yellow(view: android.view.View) {
        val intent = Intent(applicationContext,Wallpapers::class.java)
        intent.putExtra("colors", "yellow" )
        startActivity(intent);
    }
    fun blue(view: android.view.View) {
        val intent = Intent(applicationContext,Wallpapers::class.java)
        intent.putExtra("colors", "blue" )
        startActivity(intent);
    }
    fun lilac(view: android.view.View) {
        val intent = Intent(applicationContext,Wallpapers::class.java)
        intent.putExtra("colors", "lilac" )
        startActivity(intent);
    }
    fun turquoise(view: android.view.View) {
        val intent = Intent(applicationContext,Wallpapers::class.java)
        intent.putExtra("colors", "turquoise" )
        startActivity(intent);
    }
    fun pink(view: android.view.View) {
        val intent = Intent(applicationContext,Wallpapers::class.java)
        intent.putExtra("colors", "pink" )
        startActivity(intent);
    }
    fun white(view: android.view.View) {
        val intent = Intent(applicationContext,Wallpapers::class.java)
        intent.putExtra("colors", "white" )
        startActivity(intent);
    }
    fun black(view: android.view.View) {
        val intent = Intent(applicationContext,Wallpapers::class.java)
        intent.putExtra("colors", "black" )
        startActivity(intent);
    }
    fun brown(view: android.view.View) {
        val intent = Intent(applicationContext,Wallpapers::class.java)
        intent.putExtra("colors", "brown" )
        startActivity(intent);
    }

}

