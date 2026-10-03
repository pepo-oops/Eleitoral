package com.fatec.eleitoral

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultadoActivity : AppCompatActivity() {

    private lateinit var tvTotal : TextView
    private lateinit var lyResultados : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvTotal = findViewById(R.id.tvTotal)
        lyResultados = findViewById(R.id.lyResultados)

        show()

    }

    private fun show() {

        val total = BancoDados.entrevistados.size

        tvTotal.text = "Pesquisas Coletadas: $total"

        val candidatos = listOf(
            "LULA",
            "RENAN SANTOS",
            "FLÁVIO BOLSONARO",
            "SAMARA MARTINS",
            "RONALDO CAIADO",
            "NULO",
            "BRANCO",
            "NÃO SABE/ABSTEU"
        )

        var maior = 0

        for (candidato in candidatos) {

            val quantidade = BancoDados.entrevistados.count {
                it.candidato == candidato
            }

            if (quantidade > maior) {
                maior = quantidade
            }

        }

        for (candidato in candidatos) {

            val quantidade = BancoDados.entrevistados.count {
                it.candidato == candidato
            }

            val nome = TextView(this)
            nome.text = "$candidato: $quantidade"
            nome.textSize = 17f

            val barra = ProgressBar(
                this,
                null,
                android.R.attr.progressBarStyleHorizontal
            )

            barra.max = if (maior == 0) 1 else maior
            barra.progress = quantidade

            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                30
            )

            params.setMargins(0, 0, 0, 25)

            lyResultados.addView(nome)
            lyResultados.addView(barra, params)

        }

        var problemaMaisVotado = "-"
        var maiorProblema = 0

        for (entrevistado in BancoDados.entrevistados) {

            for (problema in entrevistado.problemas ?: arrayListOf()) {

                val quantidade = BancoDados.entrevistados.count {
                    it.problemas?.contains(problema) == true
                }

                if (quantidade > maiorProblema) {
                    maiorProblema = quantidade
                    problemaMaisVotado = problema
                }

            }

        }

        val tvProblema = TextView(this)
        tvProblema.text = "Problema mais votado: $problemaMaisVotado ($maiorProblema votos)"
        tvProblema.textSize = 18f

        lyResultados.addView(tvProblema)

    }

}