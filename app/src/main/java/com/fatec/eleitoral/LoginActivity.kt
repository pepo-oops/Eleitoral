package com.fatec.eleitoral

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    private lateinit var btAcc  : Button
    private lateinit var btEnd  : Button
    private lateinit var etUser : EditText
    private lateinit var etPass : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        etUser = findViewById(R.id.etUser)
        etPass = findViewById(R.id.etPass)

        btAcc = findViewById(R.id.btAcc)
        btEnd = findViewById(R.id.btEnd)

        btAcc.setOnClickListener { access() }
        btEnd.setOnClickListener { end() }

    }

    private fun access(){
        var warning : Toast
        warning = Toast.makeText( this, "Usuário ou senha incorretos, tente novamente…", Toast.LENGTH_SHORT)
        val user = etUser.text.toString()
        val pass = etPass.text.toString()

        if(user == "admin" && pass == "admin"){
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }else if(user == "entrevistador" && pass == "entrevistador"){
            val intent = Intent(this, EntrevistaActivity::class.java)
            startActivity(intent)
        }
        else{
            warning.show()
        }

    }
    private fun end(){
        finishAndRemoveTask()
    }
}