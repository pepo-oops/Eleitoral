package com.fatec.eleitoral

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EleitoresActivity : AppCompatActivity() {

    private lateinit var lyEleitores : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_eleitores)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lyEleitores = findViewById(R.id.lyEleitores)

        mostrarEleitores()

    }

    private fun mostrarEleitores() {

        for (entrevistado in BancoDados.entrevistados) {

            val caixa = LinearLayout(this)
            caixa.orientation = LinearLayout.VERTICAL
            caixa.setPadding(20, 20, 20, 20)
            caixa.setBackgroundColor(Color.LTGRAY)

            val nome = TextView(this)
            nome.text = "Nome: ${entrevistado.name}"
            nome.textSize = 18f
            nome.setTextColor(Color.BLACK)

            val numero = TextView(this)
            numero.text = "Número: ${entrevistado.num}"
            numero.textSize = 16f
            numero.setTextColor(Color.BLACK)

            val candidato = TextView(this)
            candidato.text = "Candidato: ${entrevistado.candidato ?: "-"}"
            candidato.textSize = 16f
            candidato.setTextColor(Color.BLACK)

            val problemas = TextView(this)
            problemas.text = "Problemas: ${entrevistado.problemas?.joinToString(", ") ?: "-"}"
            problemas.textSize = 16f
            problemas.setTextColor(Color.BLACK)

            val resposta = TextView(this)
            resposta.text = "Resposta: ${entrevistado.resp ?: "-"}"
            resposta.textSize = 16f
            resposta.setTextColor(Color.BLACK)

            val data = TextView(this)
            data.text = "Data: ${entrevistado.data}"
            data.textSize = 16f
            data.setTextColor(Color.BLACK)

            val local = TextView(this)
            local.text = "Local: ${entrevistado.local ?: "-"}"
            local.textSize = 16f
            local.setTextColor(Color.BLACK)

            caixa.addView(nome)
            caixa.addView(numero)
            caixa.addView(candidato)
            caixa.addView(problemas)
            caixa.addView(resposta)
            caixa.addView(data)
            caixa.addView(local)

            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            params.setMargins(0, 0, 0, 20)

            lyEleitores.addView(caixa, params)

        }

    }

}