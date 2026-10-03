package com.fatec.eleitoral

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {

    private lateinit var btEle : Button
    private lateinit var btRes  : Button
    private lateinit var btClr  : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btEle = findViewById(R.id.btEle)
        btRes = findViewById(R.id.btRes)
        btClr = findViewById(R.id.btClr)

        btEle.setOnClickListener { goEle() }
        btRes.setOnClickListener { goRes() }
        btClr.setOnClickListener { clear() }

    }

    private fun goEle(){
        val intent = Intent(this, EleitoresActivity::class.java)
        startActivity(intent)
    }

    private fun goRes(){
        val intent = Intent(this, ResultadoActivity::class.java)
        startActivity(intent)
    }

    private fun clear(){
        BancoDados.entrevistados.clear()
        Toast.makeText( this, "Dados limpos com sucesso...", Toast.LENGTH_SHORT).show();
    }

}