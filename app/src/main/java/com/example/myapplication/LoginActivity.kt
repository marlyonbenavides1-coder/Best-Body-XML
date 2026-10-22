package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        val btnBack = findViewById<ImageButton>(R.id.btnBack)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val footer = findViewById<TextView>(R.id.footer)
        val etUser = findViewById<EditText>(R.id.etUser)
        val etPass = findViewById<EditText>(R.id.etPass)
        val btnForgotPass = findViewById<TextView>(R.id.btnForgotPass)

        btnBack.setOnClickListener {
            finish()
        }

        btnLogin.setOnClickListener {
            val email = etUser.text.toString().trim()
            val password = etPass.text.toString().trim()

            if (email.isEmpty()) {
                etUser.error = "Ingresa tu correo electrónico"
                etUser.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                etPass.error = "Ingresa tu contraseña"
                etPass.requestFocus()
                return@setOnClickListener
            }

            // Autenticación con Firebase
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "¡Inicio de sesión exitoso!", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, InicioActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(
                            this,
                            "Error de autenticación: ${task.exception?.localizedMessage ?: "Verifica tus credenciales"}",
                            Toast.LENGTH_LONG,
                        ).show()
                    }
                }
        }

        footer.setOnClickListener {
            val intent = Intent(this, RegistroActivity::class.java)
            startActivity(intent)
        }

        btnForgotPass?.setOnClickListener {
            val email = etUser.text.toString().trim()
            if (email.isNotEmpty()) {
                auth.sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this, "Se envió un correo para restablecer la contraseña a $email", Toast.LENGTH_LONG).show()
                        } else {
                            Toast.makeText(this, "Error: ${task.exception?.localizedMessage}", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                etUser.error = "Ingresa tu correo para restablecer la contraseña"
                etUser.requestFocus()
            }
        }
    }
}
