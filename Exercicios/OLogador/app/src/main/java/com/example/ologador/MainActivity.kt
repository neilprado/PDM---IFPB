package com.example.ologador

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var etLogin: EditText
    private lateinit var etSenha: EditText
    private lateinit var btOk: Button
    private lateinit var btCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.etLogin = findViewById(R.id.etLogin)
        this.etSenha = findViewById(R.id.etSenha)
        this.btOk = findViewById(R.id.btOk)
        this.btCancelar = findViewById(R.id.btCancelar)

        this.btCancelar.setOnClickListener({cancelar(it)})
        this.btOk.setOnClickListener({logar(it)})
        setContentView(R.layout.activity_main)
    }

    fun cancelar(view: View){
        finish()
    }

    fun logar(view: View){
        var login = this.etLogin.text.toString()
        var senha = this.etSenha.text.toString()
        if(login.equals("admin") && senha.equals("123456")){
            val it = Intent()
            it.putExtra("LOGIN", login)
            setResult(Activity.RESULT_OK, it)
            finish()
        }else{
            Toast.makeText(this, "Login não autorizado", Toast.LENGTH_SHORT).show()
        }
    }
}
