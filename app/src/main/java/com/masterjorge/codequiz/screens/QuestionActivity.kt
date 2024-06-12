package com.masterjorge.codequiz.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Matrix.Companion.ScaleX
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.masterjorge.codequiz.data.Routes
import com.masterjorge.codequiz.data.User
import com.masterjorge.codequiz.domain.SurveyViewModel

@Composable
fun QuestionActivity(navController: NavController, viewModel: SurveyViewModel){

    val lista by viewModel.listQuestions.collectAsState()
    val index by viewModel.index.collectAsState()
    val user by viewModel.user.collectAsState()

    val options = lista[index].options.shuffled()

    Surface (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column (
            modifier = Modifier
                .padding(30.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ){
            Image(painter = painterResource(id = lista[index].image),
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth(),
            contentDescription = null)

            Text(
                text = lista[index].description,
                fontSize = 20.sp,
            )

            LazyColumn (
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ){
                items(options.size){
                    CardOption(
                        text = options[it].text,
                        options[it].correct,
                        options[it].score,
                        user!!,
                        viewModel,
                        navController
                    )
                }
            }
        }
    }
}

@Composable
fun CardOption(
    text: String,
    correct: Boolean,
    score: Int,
    user: User,
    viewModel: SurveyViewModel,
    navController: NavController
){

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val sizeScale by animateFloatAsState( if (isPressed) 0.5f else 1f)

    OutlinedButton(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .graphicsLayer(
                scaleX = sizeScale,
                scaleY = sizeScale
            ),
        interactionSource = interactionSource,
        onClick = {
            if (correct){
                viewModel.incrementScore(score)
            }

            if (viewModel.index.value == viewModel.listQuestions.value.size - 1) {
                user.score = viewModel.score.value
                navController.navigate(Routes.leaderboard)
            }
            else  {
                viewModel.incrementIndex()
                navController.navigate(Routes.quiz)
            }

        },
        shape = RoundedCornerShape(10.dp),
    ){
        Text(text = text)
    }
}

@Preview
@Composable
fun QuestionActivityPreview(){
    QuestionActivity(rememberNavController(), SurveyViewModel())
}