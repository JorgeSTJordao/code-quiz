package com.masterjorge.codequiz.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.masterjorge.codequiz.Routes
import com.masterjorge.codequiz.domain.LoginViewModel

@Composable
fun LoginActivity(navController: NavController){

    //Configurações da ViewModel
    val loginViewModel = hiltViewModel<LoginViewModel>()
    val uiState = loginViewModel.uiState.collectAsStateWithLifecycle()

    Surface (
        modifier = Modifier.fillMaxSize(),
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(text = "Bem-vindo de volta", fontSize = 40.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(60.dp))

            //Atualiza o campo de texto em relação ao nome
            OutlinedTextField(
                value =  uiState.value.nome,
                onValueChange = { nome ->
                    loginViewModel.mudarNome(nome)
                },
                label = { Text(text = "Usuário") }
            )

            Spacer(modifier = Modifier.height(5.dp))

            //Atualiza o campo de texto em relação à senha
            OutlinedTextField(
                value = uiState.value.senha,
                onValueChange = { senha ->
                    loginViewModel.mudarSenha(senha)
                },
                label = { Text(text = "Senha") }
            )

            Spacer(modifier = Modifier.height(5.dp))

            Button(onClick = {
                loginViewModel.logar()
            }) {
                Text(text = "Login")
            }

            Spacer(modifier = Modifier.height(10.dp))

            //Cadastro
            TextButton(onClick = {
                navController.navigate(Routes.SIGNUP) }
            ) {
                Text(text = "Sign Up")
            }
        }
    }
}