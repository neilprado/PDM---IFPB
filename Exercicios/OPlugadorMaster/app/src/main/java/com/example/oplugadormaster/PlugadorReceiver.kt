package com.example.oplugadormaster

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class PlugadorReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "Plugou segurando o tchan!!", Toast.LENGTH_SHORT).show()
    }
}