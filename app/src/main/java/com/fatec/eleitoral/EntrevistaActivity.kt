package com.fatec.eleitoral

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EntrevistaActivity : AppCompatActivity() {

    private lateinit var btEsp  : Button
    private lateinit var btEst  : Button
    private lateinit var btPro  : Button
    private lateinit var btEnd1 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_entrevista)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btEsp  = findViewById(R.id.btEsp)
        btEst  = findViewById(R.id.btEst)
        btPro  = findViewById(R.id.btPro)
        btEnd1 = findViewById(R.id.btEnd1)

        btEsp.setOnClickListener { goEsp() }
        btEst.setOnClickListener { goEst() }
        btPro.setOnClickListener { goPro() }
        btEnd1.setOnClickListener { end() }

    }

    private fun goEsp(){
        val intent = Intent(this, EspontaneaActivity::class.java)
        startActivity(intent)
    }

    private fun goEst(){
        val intent = Intent(this, CandidatoActivity::class.java)
        startActivity(intent)
    }

    private fun goPro(){
        val intent = Intent(this, ProblemasActivity::class.java)
        startActivity(intent)
    }

    private fun end(){
        finishAndRemoveTask()
    }

}