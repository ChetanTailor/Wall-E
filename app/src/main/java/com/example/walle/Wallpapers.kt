package com.example.walle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import org.w3c.dom.Text

class Wallpapers : AppCompatActivity() {

    val list = ArrayList<walldata>()
    lateinit var recyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wallpapers)

        recyclerView = findViewById<RecyclerView>(R.id.wallrecycler)
        recyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        val textView = findViewById<TextView>(R.id.materialTextView)
        val string = intent.getStringExtra("catstring").toString()
        textView.setText(string.toUpperCase())
        fetchwalls(string);
    }

    fun fetchwalls(string: String) {

        val queue = Volley.newRequestQueue(this)
        val key = "22923376-38c09b98913c5869870409abc"
        val url =
            "https://pixabay.com/api/?key=${key}&image_type=all&safesearch=true&orientation=vertical&per_page=200&category=${string}"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null, { response ->

                val totalres = response.get("total")
                val totalhits = response.get("totalHits")
                Toast.makeText(this,"Total Results :${totalres}  Hits :${totalhits}",Toast.LENGTH_SHORT).show()


                val jsonArray = response.getJSONArray("hits")

                for (i in 0..jsonArray.length()-1) {
                    val jsonObject = jsonArray.getJSONObject(i)
                    val previewurl = jsonObject.get("previewURL").toString()
                    val largeimage = jsonObject.get("largeImageURL").toString()

                    list.add(walldata(previewurl, largeimage))
                }
                val adapter55 = WallAdapter(list,applicationContext)
                recyclerView.adapter = adapter55
                                           },
            Response.ErrorListener {

                }
            )

        queue.add(jsonObjectRequest)

    }
}