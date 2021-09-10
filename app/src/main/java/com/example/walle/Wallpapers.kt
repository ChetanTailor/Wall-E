package com.example.walle

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley


class Wallpapers : AppCompatActivity() {

    val list = ArrayList<walldata>()
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallpapers)

        recyclerView = findViewById<RecyclerView>(R.id.wallrecycler)
        val filterbutton = findViewById<Button>(R.id.outlinedButton)

        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        val textView = findViewById<TextView>(R.id.materialTextView)
        val string = intent.getStringExtra("catstring")
        val searchstring = intent.getStringExtra("Search")
        val colors = intent.getStringExtra("colors")
        
        val key = "22923376-38c09b98913c5869870409abc"
        var url: String = ""

        if(string!=null){
            url =
                "https://pixabay.com/api/?key=${key}&image_type=all&safesearch=true&orientation=all&per_page=200&&category=${string}"
                 textView.setText(string?.toUpperCase())
        }
        else if(searchstring!=null){
            url =
                "https://pixabay.com/api/?key=${key}&image_type=all&orientation=all&per_page=200&q=${searchstring}"
                 textView.setText(searchstring?.toUpperCase())
        }
        else if(colors!=null){
            url =
                "https://pixabay.com/api/?key=${key}&image_type=all&safesearch=true&orientation=all&per_page=200&colors=${colors}"
            textView.setText(colors.toUpperCase())
        }


        filterbutton.setOnClickListener(View.OnClickListener {

        })

        fetchwalls(url);

        with(recyclerView) {

            if(string!=null){
                url =
                    "https://pixabay.com/api/?key=${key}&image_type=all&safesearch=true&orientation=all&per_page=200&&category=${string}"
                     textView.setText(string?.toUpperCase())
            }
            else if(searchstring!=null){
                url =
                    "https://pixabay.com/api/?key=${key}&image_type=all&orientation=all&per_page=200&q=${searchstring}"
                     textView.setText(searchstring?.toUpperCase())
            }
            else if(colors!=null){
                url =
                    "https://pixabay.com/api/?key=${key}&image_type=all&safesearch=true&orientation=all&per_page=200&colors=${colors}"
                textView.setText(colors.toUpperCase())
            }


            filterbutton.setOnClickListener(View.OnClickListener {

            })

            fetchwalls(url);


//            recyclerView.addOnScrollListener();


        }
    }

    fun fetchwalls(url:String) {

        val queue = Volley.newRequestQueue(this)
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null, { response ->

                val totalres = response.get("total")
                val totalhits = response.get("totalHits")
                Toast.makeText(
                    this,
                    "Total Results :${totalres}  Hits :${totalhits}",
                    Toast.LENGTH_SHORT
                ).show()


                val jsonArray = response.getJSONArray("hits")

                for (i in 0..jsonArray.length() - 1) {
                    val jsonObject = jsonArray.getJSONObject(i)
                    val previewurl = jsonObject.get("previewURL").toString()
                    val largeimage = jsonObject.get("largeImageURL").toString()

                    list.add(walldata(previewurl, largeimage))
                }
                val adapter55 = WallAdapter(list, applicationContext)
                recyclerView.adapter = adapter55
            },
            Response.ErrorListener {

            }
        )

        queue.add(jsonObjectRequest)

    }

}

