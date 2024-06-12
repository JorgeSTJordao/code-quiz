package com.masterjorge.codequiz

//API: https://quizapi.io/docs/1.0/overview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.masterjorge.codequiz.data.Routes
import com.masterjorge.codequiz.data.UserData.UserDao
import com.masterjorge.codequiz.data.UserData.UserDatabase
import com.masterjorge.codequiz.data.UserData.UserRepository
import com.masterjorge.codequiz.domain.SurveyViewModel
import com.masterjorge.codequiz.domain.UserViewModel
import com.masterjorge.codequiz.screens.HomeActivity
import com.masterjorge.codequiz.screens.LeaderboardActivity
import com.masterjorge.codequiz.screens.LoginActivity
import com.masterjorge.codequiz.screens.QuestionActivity
import com.masterjorge.codequiz.screens.RegisterActivity

class MainActivity : ComponentActivity() {

    val viewModel = SurveyViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CodeQuizApp(viewModel)
        }
    }

    @Composable
    fun CodeQuizApp(viewModel: SurveyViewModel){
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = Routes.login) {
            composable(Routes.home) {
                HomeActivity(navController, viewModel)
            }
            composable(Routes.quiz) {
                QuestionActivity(navController, viewModel)
            }
            composable(Routes.login) {
                LoginActivity(navController, viewModel)
            }
            composable(Routes.register) {
                RegisterActivity(navController)
            }
            composable(Routes.leaderboard) {
                LeaderboardActivity(navController, viewModel)
            }
        }
    }
}