package com.example.oapertador

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class CameraReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action == Intent.ACTION_CAMERA_BUTTON){
            Toast.makeText(context, "Eita, que bom!!!", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "Erooooou!!", Toast.LENGTH_SHORT).show()
        }
    }
}