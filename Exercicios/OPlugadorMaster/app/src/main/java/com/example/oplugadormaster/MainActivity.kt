package com.example.oplugadormaster

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var status : TextView
    private lateinit var receiver: PlugadorReceiver
    private lateinit var itf: IntentFilter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.status = findViewById(R.id.tvStatus)

        this.receiver = PlugadorReceiver()
        this.itf = IntentFilter()
        this.itf.addAction(Intent.ACTION_HEADSET_PLUG)
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(this.receiver, this.itf)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(this.receiver)
    }

    inner class PlugadorReceiver : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            if(intent?.action == Intent.ACTION_HEADSET_PLUG) {
                status.text = "Êta mainha que plugada de fone maravilhosa!!"
                Toast.makeText(context, "Eita, plugou segurando o tchan!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}