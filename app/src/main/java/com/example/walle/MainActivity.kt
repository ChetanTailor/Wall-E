package com.example.walle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    val cetegories = mutableListOf<String>("backgrounds","nature","religion","computer","industry","travel","animals","health"
        ,"people","transportation","buildings","places","fashion","food","science","business","sports","education",)

    val imgcatag = mutableListOf(R.drawable.backgrounds,R.drawable.nature,R.drawable.religion,R.drawable.computer
            ,R.drawable.industry,R.drawable.travel,R.drawable.animals,R.drawable.health,R.drawable.people,R.drawable.transportation
        ,R.drawable.buildings,R.drawable.places,R.drawable.fasion,R.drawable.food,R.drawable.science,R.drawable.business,R.drawable.sports
        ,R.drawable.education)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val list:ArrayList<catdata> = ArrayList()
        for(i in 0..cetegories.size-1){
            list.add(catdata(cetegories[i],imgcatag[i]))
        }

        //init recyclerview and adapter
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerid)
        val adapter = catAdapter(list,applicationContext)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)


        //for search query only
        val editText = findViewById<TextInputLayout>(R.id.outlinedTextField)
        val searchbutton = findViewById<Button>(R.id.outlinedButton)
        searchbutton.setOnClickListener {
            val intent = Intent(applicationContext, Wallpapers::class.java)
            intent.putExtra("Search", editText.editText?.text.toString())
            startActivity(intent)
        }
    }

    fun grayscale(view:View) {
        val intent = Intent(applicationContext,Wallpapers::class.java)
        intent.putExtra("colors", "grayscale" )
        startActivity(intent)
    }
    fun red(view:View) {
        val intent = Intent(applicationContext,Wallpapers::class.java)
        intent.putExtra("colors", "red" )
        startActivity(intent)
    }
    fun orange(view:View) {
        val intent = Intent(applicationContext,Wallpapers::class.java)
        intent.putExtra("colors", "orange" )
        startActivity(intent)
    }
    fun green(view:View) {
        val intent = Intent(applicationContext,Wallpapers::class.java)
        intent.putExtra("colors", "green" )
        startActivity(intent)
    }
    fun yellow(view:View) {
        val intent = Intent(applicationContext,Wallpapers::class.java)
        intent.putExtra("colors", "yellow" )
        startActivity(intent)
    }
    fun blue(view:View) {
        val intent = Intent(applicationContext,Wallpapers::class.java)
        intent.putExtra("colors", "blue" )
        startActivity(intent)
    }
    fun lilac(view:View) {
        val intent = Intent(applicationContext,Wallpapers::class.java)
        intent.putExtra("colors", "lilac" )
        startActivity(intent)
    }
    fun turquoise(view:View) {
        val intent = Intent(applicationContext,Wallpapers::class.java)
        intent.putExtra("colors", "turquoise" )
        startActivity(intent)
    }
    fun pink(view:View) {
        val intent = Intent(applicationContext,Wallpapers::class.java)
        intent.putExtra("colors", "pink" )
        startActivity(intent)
    }
    fun white(view:View) {
        val intent = Intent(applicationContext,Wallpapers::class.java)
        intent.putExtra("colors", "white" )
        startActivity(intent)
    }
    fun black(view:View) {
        val intent = Intent(applicationContext,Wallpapers::class.java)
        intent.putExtra("colors", "black" )
        startActivity(intent)
    }
    fun brown(view:View) {
        val intent = Intent(applicationContext,Wallpapers::class.java)
        intent.putExtra("colors", "brown" )
        startActivity(intent)
    }

}

