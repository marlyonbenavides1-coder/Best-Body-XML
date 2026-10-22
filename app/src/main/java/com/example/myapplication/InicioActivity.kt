package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class InicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        // Configurar click en la tarjeta de nutrición
        val cardNutricion = findViewById<CardView>(R.id.cardNutricion)
        cardNutricion.setOnClickListener {
            val intent = Intent(this, NutricionActivity::class.java)
            startActivity(intent)
        }

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val bottomNav = findViewById<LinearLayout>(R.id.bottomNav)
        
        // Explorar (Inicio) - Es la pantalla actual, pero por consistencia
        bottomNav.getChildAt(0).setOnClickListener {
            // Ya estamos en Inicio
        }

        // Horario
        bottomNav.getChildAt(1).setOnClickListener {
            startActivity(Intent(this, HorarioActivity::class.java))
        }

        // Favoritos
        bottomNav.getChildAt(2).setOnClickListener {
            startActivity(Intent(this, FavoritosActivity::class.java))
        }

        // Perfil
        bottomNav.getChildAt(3).setOnClickListener {
            startActivity(Intent(this, PerfilActivity::class.java))
        }
    }
}