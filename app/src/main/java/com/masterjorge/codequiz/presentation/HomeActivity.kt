package com.masterjorge.codequiz.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.masterjorge.codequiz.R
import com.masterjorge.codequiz.domain.HomeViewModel
import com.masterjorge.codequiz.domain.LoginViewModel

@Composable
fun HomeActivity(navController: NavController) {

    //Configurações da ViewModel
    val homeViewModel = hiltViewModel<HomeViewModel>()
    val uiState = homeViewModel.uiState.collectAsStateWithLifecycle()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.blue_background)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),

            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.Start
        ) {
            Row {
                Text(text = uiState.value.nome, fontSize = 30.sp)
            }
            Row {
                Card {
                    Text(text = "python")
                }
                Card {
                    Text(text = "kotlin")
                }
            }

            Spacer(modifier = Modifier.size(30.dp))
            
            Row {
                Text(text = "Histórico", fontSize = 30.sp)
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewA(){
    val navController = rememberNavController()
    HomeActivity(navController = navController)
}