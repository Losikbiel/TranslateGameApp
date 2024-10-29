package com.example.aula1.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.example.aula1.R
import com.example.aula1.presentation.navigation.Screen
import com.example.aula1.presentation.screen.viewmodel.GameViewModel

@Composable
fun GameScreen(gameViewModel: GameViewModel, navController: NavHostController) {
    val pressStart2p = FontFamily(
        Font(R.font.pressstart2pregular, FontWeight.Normal)
    )
    val game by gameViewModel.game.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row (
            modifier = Modifier
                .fillMaxHeight(0.10f)
                .fillMaxWidth()
                .background(color = Color(0xFF09520C)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ){

            Text(text = "TranslateIt", fontSize = 24.sp, color = Color(0xFFE0FFDD), fontFamily = pressStart2p)
        }
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "HighScore: ${game.highScore}", fontSize = 20.sp, color = Color(0xFF2A7A23), fontFamily = pressStart2p, modifier = Modifier.align(Alignment.CenterHorizontally))

        Spacer(modifier = Modifier.height(35.dp))

       Box(
           modifier = Modifier
               .fillMaxHeight(0.6f)
               .fillMaxWidth()
               .padding(horizontal = 20.dp),

       ){
           Box (
               modifier = Modifier
                   .fillMaxHeight(0.13f)
                   .fillMaxWidth(0.7f)
                   .align(Alignment.TopCenter)
                   .clip(shape = RoundedCornerShape(11.dp))
                   .background(color = Color(0xFF053406))
                   .zIndex(1f),
               Alignment.Center

           ){
                Text(text = "Score: ${game.score}" , fontSize = 20.sp, color = Color(0xFFE0FFDD), fontFamily = pressStart2p)
           }
            Card(
                modifier = Modifier
                    .fillMaxHeight(0.95f)
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                shape = RoundedCornerShape(11.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                colors = CardDefaults.cardColors(Color(0xFF09520C)),
            ){
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                   Alignment.Center
                ){
                    Text(text = game.word, fontSize = 64.sp, color = Color(0xFFE0FFDD))}
            }
       }
        Spacer(modifier = Modifier.height(60.dp))

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF387D32))
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Black.copy(alpha = 0.3f),
                            Color.Transparent
                        )
                    )
                )
        )
Column (
    modifier = Modifier.fillMaxWidth().fillMaxHeight(0.8f).padding(horizontal = 16.dp),
    verticalArrangement = Arrangement.SpaceAround

){   game.option.chunked(2).forEach { rowItems ->
    Row(

        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,

        ) {rowItems .forEach { item ->
        Card(
            modifier = Modifier
                .width(160.dp)
                .height(50.dp)
                .clickable {
                    gameViewModel.questionsAsked(item,
                        {navController.navigate(Screen.EndScreen.route)})
                },
            colors = CardDefaults.cardColors(Color(0xFF053406)),
        ){
            Row (
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically

            ){

                Text(text = item, fontSize = 15.sp, color = Color(0xFFE0FFDD), fontFamily = pressStart2p)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}



