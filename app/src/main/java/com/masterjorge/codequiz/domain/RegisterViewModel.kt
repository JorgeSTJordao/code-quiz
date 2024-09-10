package com.masterjorge.codequiz.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masterjorge.codequiz.data.usuario.Usuario
import com.masterjorge.codequiz.data.usuario.UsuarioDao
import com.masterjorge.codequiz.data.usuario.UsuarioRepositorio
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val usuarioRepositorio: UsuarioRepositorio):
    ViewModel() {

    private val _uiState = MutableStateFlow(RegisterState())
    val uiState = _uiState.asStateFlow()

    fun mudarNome(nome: String){
        _uiState.update {
            it.copy(nome = nome)
        }
    }

    fun mudarSenha(senha: String){
        _uiState.update {
            it.copy(senha = senha)
        }
    }

    fun mudarSegundaSenha(confirmarSenha: String){
        _uiState.update {
            it.copy(segundaSenha = confirmarSenha)
        }
    }

    fun cadastrar(){

        viewModelScope.launch(Dispatchers.IO) {
            usuarioRepositorio.inserirUsuario(
                Usuario(
                    usuario = uiState.value.nome,
                    senha = uiState.value.senha
                )
            )
        }    }
}

data class RegisterState(
    var nome: String = "",
    var senha: String = "",
    var segundaSenha: String = "",
    var senhasIguais: Boolean = false
)