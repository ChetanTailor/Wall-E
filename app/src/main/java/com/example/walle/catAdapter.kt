package com.example.walle

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import android.content.Intent as Intent



class catAdapter(val mainitems:List<catdata>, val context: Context) : RecyclerView.Adapter<catViewholder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): catViewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item,parent,false)
        return catViewholder(view)
    }

    override fun onBindViewHolder(holder: catViewholder, position: Int) {

        holder.textview.text = mainitems[position].category
        Glide.with(context)
            .load(mainitems[position].resource)
            .into(holder.imgview)

        holder.imgview.setOnClickListener(View.OnClickListener {
            val intent = Intent(context?.applicationContext, Wallpapers::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("catstring",mainitems[position].category)
            context.startActivity(intent)
        })


    }

    override fun getItemCount(): Int {
        return mainitems.size
    }


}

class catViewholder(view: View): RecyclerView.ViewHolder(view){
    val textview = view.findViewById<TextView>(R.id.textviewid)
    val imgview = view.findViewById<ImageView>(R.id.imageViewid)

}
