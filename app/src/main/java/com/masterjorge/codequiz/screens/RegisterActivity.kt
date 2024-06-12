package com.masterjorge.codequiz.screens

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun RegisterActivity(navController: NavController){

    var username by remember { mutableStateOf("")}
    var senha by remember { mutableStateOf("")}
    var confirmar_senha by remember { mutableStateOf("")}

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

            OutlinedTextField(
                value = username,
                onValueChange = {
                    username = it
                },
                label = { Text(text = "Username") }
            )
            Spacer(modifier = Modifier.height(5.dp))

            OutlinedTextField(
                value = "",
                onValueChange = {
                                senha = it
                },
                label = { Text(text = "Senha") }
            )
            Spacer(modifier = Modifier.height(5.dp))

            OutlinedTextField(
                value = "",
                onValueChange = {
                    confirmar_senha = it
                },
                label = { Text(text = "Confirmar Senha") }
            )
            Spacer(modifier = Modifier.height(5.dp))

            Button(onClick ={
                navController.navigate("main")
            }) {
                Text(text = "Cadastrar")
            }

            Spacer(modifier = Modifier.height(10.dp))

            TextButton(onClick = {
                navController.navigate("login")
            }) {
                Text(text = "Voltar para o login?")
            }
        }
    }
}

@Preview
@Composable
fun RegisterActivityPreview(){
    RegisterActivity(navController = rememberNavController())
}