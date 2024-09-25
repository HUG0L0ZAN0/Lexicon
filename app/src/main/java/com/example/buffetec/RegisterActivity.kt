package com.example.buffetec

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.buffetec.data.AppDatabase
import com.example.buffetec.model.User
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Obtener la instancia de la base de datos
        val db = AppDatabase.getDatabase(this)

        // Referencias a los EditText del formulario
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextSurname = findViewById<EditText>(R.id.editTextSurname)
        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val editTextAddress = findViewById<EditText>(R.id.editTextAddress)
        val editTextNeighborhood = findViewById<EditText>(R.id.editTextNeighborhood)
        val editTextCity = findViewById<EditText>(R.id.editTextCity)
        val editTextState = findViewById<EditText>(R.id.editTextState)
        val editTextPostalCode = findViewById<EditText>(R.id.editTextPostalCode)

        // Botón de registro
        findViewById<Button>(R.id.buttonRegister).setOnClickListener {
            // Obtener los valores introducidos por el usuario
            val name = editTextName.text.toString().trim()
            val surname = editTextSurname.text.toString().trim()
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()
            val address = editTextAddress.text.toString().trim()
            val neighborhood = editTextNeighborhood.text.toString().trim()
            val city = editTextCity.text.toString().trim()
            val state = editTextState.text.toString().trim()
            val postalCode = editTextPostalCode.text.toString().trim().toIntOrNull() ?: 0

            // Verificar que los campos no estén vacíos
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos obligatorios", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Crear el objeto User con los datos del usuario
            val user = User(
                name = name,
                surname = surname,
                email = email,
                pwd = password,
                address = address,
                neighborhood = neighborhood,
                city = city,
                state = state,
                cp = postalCode,
                tipo_usuario = "usuario" // Se establece el tipo de usuario como "usuario"
            )

            // Insertar el usuario en la base de datos utilizando coroutines
            lifecycleScope.launch {
                db.userDao().insertUser(user)

                // Mostrar mensaje de éxito
                Toast.makeText(this@RegisterActivity, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show()

                // Redirigir a MainActivity
                val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                startActivity(intent)
                finish() // Finaliza RegisterActivity para que no regrese a ella al pulsar "Atrás"
            }
        }
    }
}
