package com.masterjorge.codequiz.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.masterjorge.codequiz.Routes

@Composable
fun LeaderboardActivity(navController: NavController){

    /*
    var listUsers = users

    Surface(
        modifier = Modifier.fillMaxSize()
    ){
        Column (
            modifier = Modifier.padding(top = 40.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row (
                modifier = Modifier
                    .padding(start = 20.dp, bottom = 16.dp)
                    .fillMaxWidth()
            ) {
                IconButton(
                    onClick = {},
                    Modifier.background(Color.Black),
                )
                {
                    Icon(
                        Icons.Rounded.ArrowBack,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }

            Text(text = "LeaderBoard", fontSize = 40.sp)

            listUsers = listUsers.sortedByDescending { it.score }

            if (listUsers.size > 10){
                listUsers = listUsers.slice(listOf(0, 10))
            }

            val tableLeaderBoard = (0..listUsers.size.minus(1)).mapIndexed()
            { index, item ->
                val score = listUsers[index].score
                listUsers[index].username to "Score $score"
            }

            val column1Weight = .3f
            val column2Weight = .7f

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                item {
                    Row(modifier = Modifier.background(Color.Gray)) {
                        Celula(text = "Nome", weight = column1Weight)
                    }
                }
                items(tableLeaderBoard) {
                    val (nome, score) = it
                    Row(Modifier.fillMaxWidth()) {
                        Celula(text = nome, weight = column1Weight)
                        Celula(text = score, weight = column2Weight)
                    }
                }
            }
        }
    }*/
}

/*
@Composable
fun RowScope.Celula(text: String, weight: Float){
    Text(text = text,
        modifier = Modifier
            .border(1.dp, Color.Black)
            .weight(weight)
            .padding(8.dp)
    )
}*/