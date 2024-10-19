package com.example.aula1.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.aula1.presentation.screen.EndScreen
import com.example.aula1.presentation.screen.GameScreen
import com.example.aula1.presentation.screen.StartScreen
import com.example.aula1.presentation.screen.viewmodel.GameViewModel


@Composable
fun AppNavGraph(navController: NavHostController) {
    val gameViewModel: GameViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.StartScreen.route
    ) {
        composable(route = Screen.StartScreen.route) {
            StartScreen(navController, gameViewModel)
        }
        composable(route = Screen.GameScreen.route) {
            GameScreen(gameViewModel, navController)
        }
        composable(route = Screen.EndScreen.route) {
            EndScreen(gameViewModel, navController)
        }

    }
}