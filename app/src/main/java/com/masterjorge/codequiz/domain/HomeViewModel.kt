package com.masterjorge.codequiz.domain

import androidx.lifecycle.ViewModel
import com.masterjorge.codequiz.data.SimpleStorage
import com.masterjorge.codequiz.data.usuario.UsuarioRepositorio
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val usuarioRepositorio: UsuarioRepositorio):
    ViewModel() {

    private val _uiState = MutableStateFlow(UsuarioDados())
    val uiState = _uiState.asStateFlow()

    init {

        val usuario = usuarioRepositorio.lerUsuarioId(SimpleStorage.id)!!.usuario

        _uiState.update {
            it.copy(
                id = SimpleStorage.id,
                nome = usuario
            )
        }
    }
}

data class UsuarioDados(
    val id: Int = 0,
    val nome: String = ""
)