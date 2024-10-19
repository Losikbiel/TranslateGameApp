package com.example.aula1.presentation.screen.viewmodel


import androidx.lifecycle.ViewModel
import com.example.aula1.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update



class GameViewModel() : ViewModel() {

    private val _game: MutableStateFlow<GameUIState> = MutableStateFlow(GameUIState())
    val game: StateFlow<GameUIState> = _game.asStateFlow()


    private val _list = mapOf(
        "apple" to "maçã",
        "book" to "livro",
        "cat" to "gato",
        "dog" to "cachorro",
        "house" to "casa",
        "car" to "carro",
        "water" to "água",
        "sun" to "sol",
        "moon" to "lua",
        "computer" to "computador",
        "school" to "escola",
        "teacher" to "professor",
        "food" to "comida",
        "chair" to "cadeira",
        "table" to "mesa",
        "door" to "porta",
        "window" to "janela",
        "pen" to "caneta",
        "phone" to "telefone",
        "shoe" to "sapato"
    )

    init {
        updateGame()
    }

    fun questionsAsked(answer: String, onClick: () -> Unit) {
        if (answer == _game.value.currentScrambledWord) {
            _game.update {
                it.copy(score = it.score + 15)

            }
            updateGame()
        }
        else {
            onClick()
        }
    }
    private fun updateGame() {
        val word = _list.keys.random()
        val correct = _list[word]!!
        val options = _list.values.filter { it != correct }.shuffled().take(3) + correct
        _game.update {
            it.copy(
                word = word,
                currentScrambledWord = correct,
                option = options.shuffled()
            )
        }
    }

    fun returnImage(): Int {
        val image: Int
        if (game.value.score <= 100){
            image = R.drawable.img_1
        }
        else{
            image = R.drawable.img_2
        }
        return image
        }

    fun restartGame(){

        _game.update {
            it.copy(score = 0)
        }
        updateGame()
        }

    fun returnPhrase1(): String {
       val phrase: String
       if (game.value.score <= 100){
           phrase = "Melhore.."
       }
        else{
            phrase = "Parabéns!"
       }
        return phrase
       }

    fun returnPhrase2(): String {
        val phrase: String
        if (game.value.score <= 100){
            phrase = "Você acertou poucas questões.."
        }
        else{
            phrase = "Você acertou muitas questões!"
        }
        return phrase
    }
 }

