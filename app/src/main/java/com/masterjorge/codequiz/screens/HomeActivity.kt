package com.masterjorge.codequiz.screens


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.masterjorge.codequiz.R
import com.masterjorge.codequiz.data.Question
import com.masterjorge.codequiz.data.Routes
import com.masterjorge.codequiz.data.questionsKotlin
import com.masterjorge.codequiz.data.questionsPython
import com.masterjorge.codequiz.domain.SurveyViewModel

@Composable
fun HomeActivity(navController: NavController, viewModel: SurveyViewModel) {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)

    ){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = "Selecione um Quiz",
                fontSize = 30.sp
            )

            Row() {
                Card(
                    text = "Kotlin",
                    url = R.drawable.kotlin_icon,
                    route = Routes.quiz,
                    navController = navController,
                    listQuestions = questionsKotlin,
                    viewModel = viewModel
                )
                Card(
                    text = "Python",
                    url = R.drawable.python_icon,
                    route = Routes.quiz,
                    navController = navController,
                    listQuestions = questionsPython,
                    viewModel = viewModel
                )
            }
        }
    }
}

@Composable
fun Card(
    text: String,
    url: Int,
    route: String,
    navController: NavController,
    listQuestions: List<Question>,
    viewModel: SurveyViewModel
){

    Column(
        modifier = Modifier
            .size(170.dp)
            .clickable {
                viewModel.getNewList(listQuestions)
                navController.navigate(route)
                Log.d("TAG", "Card: ${viewModel.listQuestions}")
            }
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = url),
            modifier = Modifier
                .height(100.dp),
            contentDescription = null)

        Text(
            modifier = Modifier
                .padding(10.dp),
            text = text,
            fontSize = 20.sp
        )
    }
}

@Preview
@Composable
fun QuizActivityPreview() {
    HomeActivity(rememberNavController(), SurveyViewModel())
}