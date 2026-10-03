package com.fatec.eleitoral

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Geocoder
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import java.time.LocalDateTime
import java.util.Locale

class DadosActivity : AppCompatActivity() {

    private lateinit var etName : EditText
    private lateinit var etNum  : EditText
    private lateinit var btSend : Button
    private lateinit var btCanc : Button

    private lateinit var fusedLocationClient : FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dados)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etName = findViewById(R.id.etName)
        etNum = findViewById(R.id.etNum)
        btSend = findViewById(R.id.btSend)
        btCanc = findViewById(R.id.btCanc)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        btSend.setOnClickListener { send() }
        btCanc.setOnClickListener { cancel() }

    }

    private fun send() {

        val name = etName.text.toString()
        val num = etNum.text.toString()

        val candidato = intent.getStringExtra("candidato")
        val resposta = intent.getStringExtra("resposta")
        val problemas = intent.getStringArrayListExtra("problemas")

        val data = LocalDateTime.now()

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION), 100)
            return
        }

        fusedLocationClient.lastLocation.addOnSuccessListener { location -> var local : String? = null

            if (location != null) {

                val geocoder = Geocoder(this, Locale.getDefault())
                val endereco = geocoder.getFromLocation(
                    location.latitude,
                    location.longitude,
                    1
                )

                if (!endereco.isNullOrEmpty()) {

                    val cidade = endereco[0].locality
                    val estado = endereco[0].adminArea

                    local = "$cidade - $estado"
                }
            }

            val entrevistado = Entrevistado(
                name = name,
                num = num,
                candidato = candidato,
                problemas = problemas,
                resp = resposta,
                data = data,
                local = local
            )

            BancoDados.entrevistados.add(entrevistado)
            val intent = Intent(this, EntrevistaActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            Toast.makeText( this, "Entrevista registrada com sucesso!", Toast.LENGTH_LONG).show();
            finish()

        }

    }

    private fun cancel() {
        val intent = Intent(this, EntrevistaActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
    }

}