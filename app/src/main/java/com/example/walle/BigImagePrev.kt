package com.example.walle

import android.app.WallpaperManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.widget.Toast
import java.lang.Exception
import java.net.URL
import android.view.WindowManager

import android.util.DisplayMetrics

import android.graphics.drawable.BitmapDrawable
import android.util.Log
import androidx.core.graphics.drawable.toDrawable
import android.graphics.drawable.Drawable
import androidx.core.graphics.drawable.toBitmap

class BigImagePrev : AppCompatActivity() {

    lateinit var bitmap:Bitmap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_big_image_prev)


        val button = findViewById<Button>(R.id.outlinedButton)
        val imageview = findViewById<ShapeableImageView>(R.id.largeimageView)

        val largeurl = intent.getStringExtra("largeurl").toString()

        Glide.with(applicationContext).load(largeurl).into(imageview)

        val thread = Thread {
            try {
                button.setClickable(false);
                val drawable = imageview.drawable
                var bitmap = drawable.toBitmap()
                val wallpaperManager = WallpaperManager.getInstance(baseContext)
                wallpaperManager.setBitmap(bitmap)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        button.setOnClickListener(View.OnClickListener {
            if(!this::bitmap.isInitialized) {
                thread.start()
                Toast.makeText(this, "Wallpaper set!", Toast.LENGTH_SHORT).show()
            }
        })
    }


}
