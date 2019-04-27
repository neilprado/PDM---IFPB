package com.example.obuscadordologador

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val LOGADOR = 1
    private lateinit var login: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.login = findViewById(R.id.etLogin)
        val it = Intent("O_LOGADOR")
        startActivityForResult(it, LOGADOR)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            if(requestCode == LOGADOR){
                var text = data?.getStringExtra("Login")
                this.login.text = text
            }
        }
    }
}
