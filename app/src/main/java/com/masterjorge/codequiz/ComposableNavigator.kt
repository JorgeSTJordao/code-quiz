package com.masterjorge.codequiz

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.masterjorge.codequiz.presentation.HomeActivity
import com.masterjorge.codequiz.presentation.LeaderboardActivity
import com.masterjorge.codequiz.presentation.LoginActivity
import com.masterjorge.codequiz.presentation.QuestionActivity
import com.masterjorge.codequiz.presentation.RegisterActivity

@Composable
fun ComposableNavigator(navController: NavHostController){

    //NavHost: local que onde permite a transição de telas
    NavHost(navController = navController, startDestination = Routes.HOME) {

        composable(Routes.SIGNIN) {
            LoginActivity(navController)
        }
        composable(Routes.SIGNUP) {
            RegisterActivity(navController)
        }
        composable(Routes.HOME) {
            HomeActivity(navController)
        }
        composable(Routes.QUIZ) {
            QuestionActivity(navController)
        }
        composable(Routes.LEADERBOARD) {
            LeaderboardActivity(navController)
        }
    }

}
