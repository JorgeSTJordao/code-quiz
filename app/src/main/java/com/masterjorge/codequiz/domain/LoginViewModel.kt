package com.masterjorge.codequiz.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masterjorge.codequiz.data.SimpleStorage
import com.masterjorge.codequiz.data.usuario.UsuarioRepositorio
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val usuarioRepositorio: UsuarioRepositorio):
    ViewModel() {

    private val _uiState = MutableStateFlow(LoginState())
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

    fun logar(){

        viewModelScope.launch(Dispatchers.IO){
            if (usuarioRepositorio.lerUsuario(uiState.value.nome, uiState.value.senha) != null )
            {
                _uiState.update {
                    it.copy(aceito =  true)
                }

                val id = usuarioRepositorio.lerUsuario(uiState.value.nome, uiState.value.senha)!!.id

                SimpleStorage.setNovoId(id)

            }
        }
    }
}

data class LoginState(
    var nome: String = "",
    var senha: String = "",
    var aceito: Boolean = false
)