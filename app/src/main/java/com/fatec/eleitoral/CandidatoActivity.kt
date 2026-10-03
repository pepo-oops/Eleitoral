package com.fatec.eleitoral

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CandidatoActivity : AppCompatActivity() {

    private lateinit var cvLula   : CardView
    private lateinit var cvRenan  : CardView
    private lateinit var cvFlavio : CardView
    private lateinit var cvSamara : CardView
    private lateinit var cvCaiado : CardView

    private lateinit var btNulo  : Button
    private lateinit var btBranco : Button
    private lateinit var btNsei : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_candidato)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        cvLula   = findViewById(R.id.cvLula)
        cvRenan  = findViewById(R.id.cvRenan)
        cvFlavio = findViewById(R.id.cvFlavio)
        cvSamara = findViewById(R.id.cvSamara)
        cvCaiado = findViewById(R.id.cvCaiado)

        btNulo  = findViewById(R.id.btNulo)
        btBranco = findViewById(R.id.btBranco)
        btNsei = findViewById(R.id.btNsei)

        cvLula.setOnClickListener { nextCandidato("LULA") }
        cvRenan.setOnClickListener { nextCandidato("RENAN SANTOS") }
        cvFlavio.setOnClickListener { nextCandidato("FLÁVIO BOLSONARO") }
        cvSamara.setOnClickListener { nextCandidato("SAMARA MARTINS") }
        cvCaiado.setOnClickListener { nextCandidato("RONALDO CAIADO") }

        btNulo.setOnClickListener { nextCandidato("NULO") }
        btBranco.setOnClickListener { nextCandidato("BRANCO") }
        btNsei.setOnClickListener { nextCandidato("NÃO SABE/ABSTEU") }

    }

    private fun nextCandidato(cand: String) {
        val intent = Intent(this, DadosActivity::class.java)

        intent.putExtra("candidato", cand)

        startActivity(intent)
    }

}