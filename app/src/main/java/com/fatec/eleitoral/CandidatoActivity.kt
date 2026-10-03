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

    private lateinit var cvGrievous   : CardView
    private lateinit var cvPalp  : CardView
    private lateinit var cvNute : CardView
    private lateinit var cvPadme : CardView
    private lateinit var cvJar : CardView

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

        cvGrievous   = findViewById(R.id.cvGrievous)
        cvPalp  = findViewById(R.id.cvPalp)
        cvNute = findViewById(R.id.cvNute)
        cvPadme = findViewById(R.id.cvPadme)
        cvJar = findViewById(R.id.cvJar)

        btNulo  = findViewById(R.id.btNulo)
        btBranco = findViewById(R.id.btBranco)
        btNsei = findViewById(R.id.btNsei)

        cvGrievous.setOnClickListener { nextCandidato("GRIEVOUS") }
        cvPalp.setOnClickListener { nextCandidato("PALPATINE") }
        cvNute.setOnClickListener { nextCandidato("NUTE GUNRAY") }
        cvPadme.setOnClickListener { nextCandidato("PADMÉ AMIDALA") }
        cvJar.setOnClickListener { nextCandidato("JAR JAR BINKS") }

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