package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnBack.setOnClickListener {
            finish()
        }

        btnRegister.setOnClickListener {
            val intent = Intent(this, VerificaCorreoActivity::class.java)
            startActivity(intent)
        }
    }
}