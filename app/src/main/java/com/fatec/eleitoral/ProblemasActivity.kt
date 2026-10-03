package com.fatec.eleitoral

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProblemasActivity : AppCompatActivity() {

    private lateinit var ckSaude   : CheckBox
    private lateinit var ckEdu     : CheckBox
    private lateinit var ckTrans   : CheckBox
    private lateinit var ckSeg     : CheckBox
    private lateinit var ckEmprego : CheckBox
    private lateinit var ckHab     : CheckBox
    private lateinit var ckAmb     : CheckBox
    private lateinit var ckInfra   : CheckBox
    private lateinit var ckCult    : CheckBox
    private lateinit var ckTec     : CheckBox

    private lateinit var btSendPb  : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_problemas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        ckSaude   = findViewById(R.id.ckSaude)
        ckEdu     = findViewById(R.id.ckEdu)
        ckTrans   = findViewById(R.id.ckTrans)
        ckSeg     = findViewById(R.id.ckSeg)
        ckEmprego = findViewById(R.id.ckEmprego)
        ckHab     = findViewById(R.id.ckHab)
        ckAmb     = findViewById(R.id.ckAmb)
        ckInfra   = findViewById(R.id.ckInfra)
        ckCult    = findViewById(R.id.ckCult)
        ckTec     = findViewById(R.id.ckTec)

        btSendPb = findViewById(R.id.btSendPb)

        ckSaude.setOnCheckedChangeListener { _, _ -> checked() }
        ckEdu.setOnCheckedChangeListener { _, _ -> checked() }
        ckTrans.setOnCheckedChangeListener { _, _ -> checked() }
        ckSeg.setOnCheckedChangeListener { _, _ -> checked() }
        ckEmprego.setOnCheckedChangeListener { _, _ -> checked() }
        ckHab.setOnCheckedChangeListener { _, _ -> checked() }
        ckAmb.setOnCheckedChangeListener { _, _ -> checked() }
        ckInfra.setOnCheckedChangeListener { _, _ -> checked() }
        ckCult.setOnCheckedChangeListener { _, _ -> checked() }
        ckTec.setOnCheckedChangeListener { _, _ -> checked() }

        btSendPb.setOnClickListener { nextDados() }

    }

    private fun checked() {

        var check = 0

        if (ckSaude.isChecked) check++
        if (ckEdu.isChecked) check++
        if (ckTrans.isChecked) check++
        if (ckSeg.isChecked) check++
        if (ckEmprego.isChecked) check++
        if (ckHab.isChecked) check++
        if (ckAmb.isChecked) check++
        if (ckInfra.isChecked) check++
        if (ckCult.isChecked) check++
        if (ckTec.isChecked) check++

        if (check > 3) {

            if (ckSaude.isChecked) ckSaude.isChecked = false
            else if (ckEdu.isChecked) ckEdu.isChecked = false
            else if (ckTrans.isChecked) ckTrans.isChecked = false
            else if (ckSeg.isChecked) ckSeg.isChecked = false
            else if (ckEmprego.isChecked) ckEmprego.isChecked = false
            else if (ckHab.isChecked) ckHab.isChecked = false
            else if (ckAmb.isChecked) ckAmb.isChecked = false
            else if (ckInfra.isChecked) ckInfra.isChecked = false
            else if (ckCult.isChecked) ckCult.isChecked = false
            else if (ckTec.isChecked) ckTec.isChecked = false

        }

    }

    private fun nextDados() {

        val problemas = ArrayList<String>()

        if (ckSaude.isChecked) problemas.add("Saúde")
        if (ckEdu.isChecked) problemas.add("Educação")
        if (ckTrans.isChecked) problemas.add("Transporte")
        if (ckSeg.isChecked) problemas.add("Segurança pública")
        if (ckEmprego.isChecked) problemas.add("Emprego e renda")
        if (ckHab.isChecked) problemas.add("Habitação")
        if (ckAmb.isChecked) problemas.add("Meio ambiente")
        if (ckInfra.isChecked) problemas.add("Infraestrutura")
        if (ckCult.isChecked) problemas.add("Cultura")
        if (ckTec.isChecked) problemas.add("Tecnologia")

        val intent = Intent(this, DadosActivity::class.java)

        intent.putStringArrayListExtra("problemas", problemas)

        startActivity(intent)
    }

}