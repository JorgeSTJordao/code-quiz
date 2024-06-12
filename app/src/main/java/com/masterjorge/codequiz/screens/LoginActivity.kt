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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.masterjorge.codequiz.data.Routes
import com.masterjorge.codequiz.data.users
import com.masterjorge.codequiz.domain.SurveyViewModel
import com.masterjorge.codequiz.domain.UserViewModel

@Composable
fun LoginActivity(
    navController: NavController,
    viewModel: SurveyViewModel
){
    var username by remember { mutableStateOf("")}
    var password by remember { mutableStateOf("")}
    val user by viewModel.user.collectAsState()

    val listUsers = users

    Surface (
        modifier = Modifier.fillMaxSize(),
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(text = "Bem-vindo de volta", fontSize = 40.sp, fontWeight = FontWeight.Bold)

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
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Senha") }
            )

            Spacer(modifier = Modifier.height(5.dp))

            Button(onClick = {
                listUsers.forEach {
                    if (it.username == username && it.senha.toString() == password) {
                        viewModel.getMainUser(it)
                        viewModel.setScore(it.score)
                        navController.navigate(Routes.home)
                    }
                }
            }) {
                Text(text = "Login")
            }
            Spacer(modifier = Modifier.height(10.dp))
            TextButton(onClick = {
                navController.navigate(Routes.register)
            }) {
                Text(text = "Fazer cadastro")
            }
        }
    }
}