package com.example.walle

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target


class WallAdapter(val list: List<walldata>,val context: Context) : RecyclerView.Adapter<viewholder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.imgprevres,parent,false)
        return viewholder(view)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        Glide.with(context)
            .load(list[position].smallimg)
            .into(holder.previmgview11)

        holder.previmgview11.setOnClickListener(View.OnClickListener {

            val intent = Intent(context?.applicationContext,BigImagePrev::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("largeurl",list[position].largeimg)
            context.startActivity(intent)

        })


    }

    override fun getItemCount(): Int {
        return list.size
    }

}

class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val previmgview11 = itemView.findViewById<ImageView>(R.id.previmg)
}