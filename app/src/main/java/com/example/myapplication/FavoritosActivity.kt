package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class FavoritosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favoritos)

        findViewById<ImageButton>(R.id.btnBack).setOnClickListener { finish() }
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val bottomNav = findViewById<LinearLayout>(R.id.bottomNav)
        bottomNav.getChildAt(0).setOnClickListener { startActivity(Intent(this, InicioActivity::class.java)) }
        bottomNav.getChildAt(1).setOnClickListener { startActivity(Intent(this, HorarioActivity::class.java)) }
        bottomNav.getChildAt(2).setOnClickListener { /* Ya estamos aquí */ }
        bottomNav.getChildAt(3).setOnClickListener { startActivity(Intent(this, PerfilActivity::class.java)) }
    }
}