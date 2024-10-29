package com.example.aula1.presentation.screen.viewmodel



import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aula1.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


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
        "shoe" to "sapato",
        "tree" to "árvore",
        "river" to "rio",
        "mountain" to "montanha",
        "city" to "cidade",
        "country" to "país",
        "street" to "rua",
        "flower" to "flor",
        "beach" to "praia",
        "music" to "música",
        "art" to "arte",
        "science" to "ciência",
        "history" to "história",
        "garden" to "jardim",
        "bookstore" to "livraria",
        "market" to "mercado",
        "train" to "trem",
        "airport" to "aeroporto",
        "bridge" to "ponte",
        "library" to "biblioteca"
    )

    private val Context.dataStore by preferencesDataStore("game")
    private val HIGH_SCORE = intPreferencesKey("high_score")

    fun highScore(context: Context, highScore: Int) {
        viewModelScope.launch { context.dataStore.edit {
            it[HIGH_SCORE] = highScore
            }
        }
    }

    fun getHighScore(context: Context) {
        viewModelScope.launch {
           val preferences = context.dataStore.data.first()
            _game.update {
                it.copy(highScore = preferences[HIGH_SCORE] ?: 0)
            }
        }
    }

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
        updateHighScore()
        val word = _list.keys.random()
        val correct = _list[word]!!
        val options = _list.values.filter { it != correct }.shuffled().take(3) + correct
        _game.update {
            it.copy(
                word = word,
                currentScrambledWord = correct,
                option = options.shuffled(),
            )
        }
    }

    fun updateHighScore() {
        if (game.value.score > game.value.highScore) {
            _game.update {
                it.copy(highScore = game.value.score)
            }
        }
    }

    fun returnImage(): Int {
        val image: Int
        if (game.value.score <= 1000){
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

