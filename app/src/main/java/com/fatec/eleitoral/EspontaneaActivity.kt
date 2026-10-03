package com.fatec.eleitoral

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EspontaneaActivity : AppCompatActivity() {

    private lateinit var etEsp     : EditText
    private lateinit var btSendEsp : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_espontanea)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etEsp = findViewById(R.id.etEsp)
        btSendEsp = findViewById(R.id.btSendEsp)

        btSendEsp.setOnClickListener { nextDados() }

    }

    private fun nextDados() {

        val resp = etEsp.text.toString()
        val intent = Intent(this, DadosActivity::class.java)

        intent.putExtra("resposta", resp)

        startActivity(intent)
    }

}