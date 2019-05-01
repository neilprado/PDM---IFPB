package com.example.oapertador

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var status: TextView
    private lateinit var receiver: CameraReceiver
    private lateinit var itf: IntentFilter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.status = findViewById(R.id.tvStatus)
        this.receiver = CameraReceiver()
        this.itf = IntentFilter()
        this.itf.addAction(Intent.ACTION_USER_PRESENT)
    }

    override fun onResume() {
        super.onResume()
        unregisterReceiver(this.receiver)
    }

    inner class CameraReceiver: BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            status.text = "Eita que foto bonita!"
            Toast.makeText(context, "Eita!!", Toast.LENGTH_SHORT).show()
        }
    }
}
