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
import com.masterjorge.codequiz.domain.RegisterViewModel

@Composable
fun RegisterActivity(navController: NavController){

    //Configurações da ViewModel
    val registerViewModel = hiltViewModel<RegisterViewModel>()
    val uiState = registerViewModel.uiState.collectAsStateWithLifecycle()

    Surface(
        modifier = Modifier
            .fillMaxSize(),
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Text(text = "Seja bem-vindo", fontSize = 40.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(60.dp))

            //Mudar nome
            OutlinedTextField(
                value = uiState.value.nome,
                onValueChange = { nome ->
                    registerViewModel.mudarNome(nome)
                },
                label = { Text(text = "Username") }
            )
            Spacer(modifier = Modifier.height(5.dp))

            //Mudar senha
            OutlinedTextField(
                value = uiState.value.senha,
                onValueChange = { senha ->
                    registerViewModel.mudarSenha(senha)
                },
                label = { Text(text = "Senha") }
            )
            Spacer(modifier = Modifier.height(5.dp))

            //Mudar segunda senha
            OutlinedTextField(
                value = uiState.value.segundaSenha,
                onValueChange = { segundaSenha ->
                    registerViewModel.mudarSegundaSenha(segundaSenha)
                },
                label = { Text(text = "Confirmar Senha") }
            )

            Spacer(modifier = Modifier.height(5.dp))


            Button(onClick ={
                registerViewModel.cadastrar()
            }) {
                Text(text = "Cadastrar")
            }

            Spacer(modifier = Modifier.height(10.dp))

            TextButton(onClick = {
                navController.navigate(Routes.SIGNIN)
            }) {
                Text(text = "Voltar para o login?")
            }
        }
    }
}