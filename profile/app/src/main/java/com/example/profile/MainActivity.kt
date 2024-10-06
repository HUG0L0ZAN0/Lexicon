package com.example.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.profile.ui.profile.UserProfileScreen
import com.example.profile.ui.theme.ProfileTheme
import com.example.profile.ui.profile.UserProfileScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfileTheme {
                // Usamos Scaffold si tienes un diseño estructurado con más elementos
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Reemplazar la función Greeting con la pantalla de perfil
                    UserProfileScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
