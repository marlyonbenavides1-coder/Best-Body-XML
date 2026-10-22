package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class PerfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        findViewById<View>(R.id.btnBack).setOnClickListener { finish() }

        // Configurar clics de las tarjetas
        findViewById<CardView>(R.id.cardNotificaciones).setOnClickListener {
            // Intent para ir a Notificaciones (ajusta si el nombre de la clase es distinto)
            val intent = Intent(this, NotificacionActivity::class.java)
            startActivity(intent)
        }

        findViewById<CardView>(R.id.cardPagos).setOnClickListener {
            // Intent para ir a Métodos de Pago
            val intent = Intent(this, MetodoPagoActivity::class.java)
            startActivity(intent)
        }

        // Configurar botón Cerrar Sesión
        findViewById<CardView>(R.id.btnLogout).setOnClickListener {
            val intent = Intent(this, WelcomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val bottomNav = findViewById<LinearLayout>(R.id.bottomNav)
        bottomNav.getChildAt(0).setOnClickListener { startActivity(Intent(this, InicioActivity::class.java)) }
        bottomNav.getChildAt(1).setOnClickListener { startActivity(Intent(this, HorarioActivity::class.java)) }
        bottomNav.getChildAt(2).setOnClickListener { startActivity(Intent(this, FavoritosActivity::class.java)) }
        bottomNav.getChildAt(3).setOnClickListener { /* Ya estamos aquí */ }
    }
}