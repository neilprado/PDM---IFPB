package com.example.ochamadormaster

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView

class FotoMainActivity: AppCompatActivity() {
    private lateinit var img : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foto_main)
        this.img = findViewById(R.id.ImageView)
        val it = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(it, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && data != null){
            this.img.setImageBitmap(data.extras.get("data") as Bitmap)
        }
    }
}