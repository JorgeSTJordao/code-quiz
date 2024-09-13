package com.masterjorge.codequiz.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.masterjorge.codequiz.data.SimpleStorage
import com.masterjorge.codequiz.data.usuario.UsuarioRepositorio
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val usuarioRepositorio: UsuarioRepositorio):
    ViewModel() {

    private val _uiState = MutableStateFlow(UsuarioDados())
    val uiState = _uiState.asStateFlow()

    init {

        viewModelScope.launch(Dispatchers.IO) {
            val usuario = usuarioRepositorio.lerUsuarioId(SimpleStorage.id)!!.usuario

            _uiState.update {
                it.copy(
                    id = SimpleStorage.id,
                    nome = usuario
                )
            }

            var i = 0

            //10 milhões
            while (i < 10){
                i++
                delay(1000)
            }

            _uiState.update {
                it.copy(nome = i.toString())
            }

        }
    }
}

data class UsuarioDados(
    val id: Int = 0,
    val nome: String = ""
)