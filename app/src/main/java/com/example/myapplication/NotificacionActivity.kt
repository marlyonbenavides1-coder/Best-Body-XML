package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class NotificacionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notificacion)

        findViewById<View>(R.id.btnBack).setOnClickListener { finish() }

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val bottomNav = findViewById<LinearLayout>(R.id.bottomNav)
        bottomNav.getChildAt(0).setOnClickListener { startActivity(Intent(this, InicioActivity::class.java)) }
        bottomNav.getChildAt(1).setOnClickListener { startActivity(Intent(this, HorarioActivity::class.java)) }
        bottomNav.getChildAt(2).setOnClickListener { startActivity(Intent(this, FavoritosActivity::class.java)) }
        bottomNav.getChildAt(3).setOnClickListener { startActivity(Intent(this, PerfilActivity::class.java)) }
    }
}
