package com.example.profile.ui.profile


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profile.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserProfileViewModel : ViewModel() {

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    init {
        loadUserData()
    }

    private fun loadUserData() {
        // Cargar los datos del usuario desde la base de datos o servicio API
        viewModelScope.launch {
            _user.value = User(name = "Hugo Lozano", email = "hugo_lozano@gmail.com")
        }
    }

    fun logout() {
        // Implementar la lógica para cerrar sesión
    }
}
