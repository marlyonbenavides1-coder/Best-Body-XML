package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class VerificaCorreoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verifica_correo)

        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        val btnNext = findViewById<Button>(R.id.btnNext)

        btnBack?.setOnClickListener {
            finish()
        }

        btnNext?.setOnClickListener {
            // Según tu solicitud, siguiente en verificar correo va a inicio
            val intent = Intent(this, InicioActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}