package com.example.aula1.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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

fun EndScreen(gameViewModel: GameViewModel, navController: NavHostController) {
    val pressStart2p = FontFamily(
        Font(R.font.pressstart2pregular, FontWeight.Normal))

Box (
    modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFE0FFDD))
){
    Column (
        modifier = Modifier
            .fillMaxHeight(0.65f)
            .fillMaxWidth()
            .padding(20.dp)
            .zIndex(1f)
            .align(Alignment.TopEnd)

    ){
        Row (
            modifier = Modifier
                .fillMaxHeight(0.12f)
                .fillMaxWidth()
                .padding(20.dp)
        ){
            Text(text = "TranslateIt", fontSize = 14.sp, color = Color(0xFF053406), fontFamily = pressStart2p)
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row (
            modifier = Modifier
                .fillMaxHeight(0.08f)
                .fillMaxWidth()
        ){
            Text(text = gameViewModel.returnPhrase1(), fontSize = 20.sp, color = Color(0xFF053406), fontFamily = pressStart2p)
        }

        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier
                .fillMaxHeight(0.12f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) { Text(text = gameViewModel.returnPhrase2(), fontSize = 14.sp, color = Color(0xFF387D32), fontFamily = pressStart2p)
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                ,
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(gameViewModel.returnImage()),
                contentDescription = null,
                modifier = Modifier
                    .size(300.dp)
            )
        }
    }
    Column (
    modifier = Modifier
            .fillMaxHeight(0.4f)
            .fillMaxWidth()
            .background(color = Color(0xFF91DE8A))
            .align(Alignment.BottomCenter)
            .offset(y = 55.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
) {
        Button(
            onClick = {
                navController.navigate(Screen.StartScreen.route)
            },
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(40.dp),
           colors = ButtonDefaults.buttonColors(Color(0xFF053406))
        ) {
            Text(text = "Voltar", color = Color(0xFFFFFFFF))
            }
        }
    }
}


