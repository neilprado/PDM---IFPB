package com.example.pistobrowser

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    private lateinit var back: ImageButton
    private lateinit var next: ImageButton
    private lateinit var update: ImageButton
    private lateinit var go: ImageButton
    private lateinit var url: EditText
    private lateinit var page: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.back = findViewById(R.id.voltar)
        this.next = findViewById(R.id.avancar)
        this.update = findViewById(R.id.atualizar)
        this.go = findViewById(R.id.ir)
        this.url = findViewById(R.id.url)
        this.page = findViewById(R.id.pagina)

        page.webViewClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?) : Boolean{
                view?.loadUrl(url)
                return true
            }
        }

        page.getSettings().setJavaScriptEnabled(true)
        page.getSettings().setSupportZoom(true)
        url.setText("http://www.ifpb.edu.br")

        page.loadUrl(url.getText().toString())

        back.setOnClickListener({voltar(it)})
        next.setOnClickListener({avancar(it)})
        update.setOnClickListener({atualizar(it)})
        go.setOnClickListener({carregar(it)})

    }

    fun voltar(view: View){
        page.goBack()
    }

    fun avancar(view: View){
        page.goForward()
    }

    fun atualizar(view: View){
        page.reload()
    }

    fun carregar(view: View){
        page.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        this.page.loadUrl(this.url.text.toString())
    }
}
