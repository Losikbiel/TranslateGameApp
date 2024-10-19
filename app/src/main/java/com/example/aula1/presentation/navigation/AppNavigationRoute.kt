package com.example.aula1.presentation.navigation

 sealed class Screen(val route: String){

     object StartScreen: Screen("start_screen")
     object GameScreen: Screen("game_screen")
     object EndScreen: Screen("end_screen")

 }