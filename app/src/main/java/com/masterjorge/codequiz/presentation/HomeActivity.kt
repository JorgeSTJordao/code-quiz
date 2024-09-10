package com.masterjorge.codequiz.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Modifier

@Composable
fun HomeActivity(navController: NavController) {

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Kotlin")
        Text(text = "Python")
    }
}