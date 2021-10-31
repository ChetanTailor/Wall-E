package com.example.walle

import android.app.WallpaperManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import android.graphics.Bitmap
import android.widget.Toast
import android.os.Handler
import android.widget.ProgressBar
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.postDelayed
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BigImagePrev : AppCompatActivity() {

    lateinit var bitmap:Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_big_image_prev)


        val button = findViewById<Button>(R.id.outlinedButton)
        val imageview = findViewById<ShapeableImageView>(R.id.largeimageView)
        val progressBar = findViewById<ProgressBar>(R.id.horizontalpb)
        val largeurl = intent.getStringExtra("largeurl").toString()


        progressBar.progress = 60
        Handler().postDelayed({
            progressBar.progress = 80
            Handler().postDelayed({
                progressBar.progress = 100
            }, 1000)
        },1000)

        Glide.with(applicationContext).load(largeurl).transition(DrawableTransitionOptions.withCrossFade(200)).into(imageview)


        fun setwallpaper(){
            button.setClickable(false);
            val drawable = imageview.drawable
            var bitmap = drawable.toBitmap()
            val wallpaperManager = WallpaperManager.getInstance(baseContext)
            wallpaperManager.setBitmap(bitmap)
        }

        button.setOnClickListener(View.OnClickListener {
            if(!this::bitmap.isInitialized) {
                 CoroutineScope(Dispatchers.IO).launch {
                     setwallpaper()
                 }
                Toast.makeText(this, "Wallpaper set!", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
