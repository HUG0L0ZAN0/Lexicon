package com.example.buffetec

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Encontrar el botón por su ID
        val buttonOpenRegister = findViewById<Button>(R.id.buttonOpenRegister)

        // Configurar el evento de clic del botón
        buttonOpenRegister.setOnClickListener {
            // Redirigir a RegisterActivity
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
