package com.example.ochamadormaster

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btHtml: Button
    private lateinit var btDiscar: Button
    private lateinit var btLigar: Button
    private lateinit var btEmail: Button
    private lateinit var btSMS: Button
    private lateinit var btCompartilharTexto: Button
    private lateinit var btPonto: Button
    private lateinit var btRota: Button
    private lateinit var btYoutube: Button
    private lateinit var btFoto: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btHtml = findViewById(R.id.btHTML)
        this.btCompartilharTexto = findViewById(R.id.btCompartilharTexto)
        this.btDiscar = findViewById(R.id.btDiscar)
        this.btEmail = findViewById(R.id.btEmail)
        this.btFoto = findViewById(R.id.btFoto)
        this.btLigar = findViewById(R.id.btLigar)
        this.btPonto = findViewById(R.id.btPonto)
        this.btRota = findViewById(R.id.btRota)
        this.btSMS = findViewById(R.id.btSMS)
        this.btYoutube = findViewById(R.id.btYoutube)
    }

    fun html(view: View){
        val uri = Uri.parse("http://pdm.valeriacavalcanti.com.br")
        val it = Intent(Intent.ACTION_VIEW, uri)
        startActivity(it)
    }

    fun discar(view: View){
        val uri = Uri.parse("tel: 996544986")
        val it = Intent(Intent.ACTION_DIAL, uri)
        startActivity(it)
    }

    fun ligar(view: View){
        val uri = Uri.parse("tel: 996544986")
        val it = Intent(Intent.ACTION_CALL, uri)
        val call = android.Manifest.permission.CALL_PHONE
        val granted = PackageManager.PERMISSION_GRANTED
    }

    fun email(view: View){
        val uri = Uri.parse("mailto: neiljohn17@gmail.com")
        val it = Intent(Intent.ACTION_SENDTO, uri)
        it.putExtra(Intent.EXTRA_SUBJECT, "Assunto")
        it.putExtra(Intent.EXTRA_TEXT, "Texto")
        startActivity(it)
    }

    fun sms(view: View){
        val uri = Uri.parse("sms:996544986")
        val it = Intent(Intent.ACTION_SENDTO, uri)
        it.putExtra("sms_body", "Mensagem")
        startActivity(it)
    }

    fun compartilharTexto(view: View){
        val it = Intent(Intent.ACTION_SEND)
        it.setType("text/plain")
        it.putExtra(Intent.EXTRA_TEXT, "Texto para compartilhar")
        startActivity(Intent.createChooser(it, "Compartilhar"))
    }

    fun ponto(view: View){
        val uri = Uri.parse("geo:-7.1356496, -34.8760932")
        val it = Intent(Intent.ACTION_VIEW, uri)
        startActivity(it)
    }

    fun rota(view: View){
        val origem = "-7.1356496, -34.8760932"
        val destino = "-7.1181836,-34.8730402"
        val url = "http://maps.google.com/maps"

        val uri = Uri.parse("${url}?f=&saddr=${origem}+&daddr=${destino}")
        val it = Intent(Intent.ACTION_VIEW, uri)
        startActivity(it)
    }

    fun youtube(view: View){
        val uri = Uri.parse("vnd.youtube.com://H0Z7ewOXCKw")
        val it = Intent(Intent.ACTION_VIEW, uri)
        startActivity(it)
    }

    fun foto(view: View){
        val it = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivity(it)
    }
}
