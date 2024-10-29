package com.example.aula1.presentation.screen.viewmodel

data class GameUIState(
    val word: String = "",
    val currentScrambledWord: String = "",
    val score: Int = 0,
    val option: List<String> = listOf(),
    val highScore: Int = 0,
)
