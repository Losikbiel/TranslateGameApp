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
import androidx.compose.foundation.layout.width
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


val pressStart2p = FontFamily(
    Font(R.font.pressstart2pregular, FontWeight.Normal)
)
@Composable
fun StartScreen(navController: NavHostController, gameViewModel: GameViewModel) {

    gameViewModel.getHighScore(navController.context)


    Box(
        modifier = Modifier
            .fillMaxSize()

    )

    {
        Column(
            modifier = Modifier
                .fillMaxHeight(0.6f)
                .fillMaxWidth()
                .background(Color(0xFFE0FFDD))
                .padding(horizontal = 20.dp)
                .align(Alignment.TopStart),
        ) {
            Row (
                modifier = Modifier
                    .fillMaxHeight(0.1f)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.Bottom


            ){
                Text(text = "TranslateIt", fontSize = 18.sp, color = Color(0xFF053406), fontFamily = pressStart2p)

            }


            Spacer(modifier = Modifier.height(60.dp))



            Row(
                modifier = Modifier
                    .fillMaxHeight(0.1f)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.Bottom

            ) {
                Text(text = "Bem-vindo", fontSize = 32.sp, color = Color(0xFF053406), fontFamily = pressStart2p)
            }
                Spacer(modifier = Modifier.height(20.dp))

                Text(text = "Adivinhe a traducão correta da palavra em ingles e ganhe pontos!",
                    modifier = Modifier.fillMaxWidth(0.85f),
                    fontSize = 14.sp,
                    color = Color (0xFF71BD6A),
                    fontFamily = pressStart2p
                )
        }

     Image(
         painter = painterResource(R.drawable.img),
         contentDescription = null,
         modifier = Modifier
             .align(Alignment.Center)
             .offset(y = 60.dp)
             .zIndex(1f)
             .size(300.dp)

     )
     Column (
         modifier = Modifier
             .fillMaxHeight(0.4f)
             .fillMaxWidth()
             .background(Color(0xFFCBFFC7))
             .align(Alignment.BottomCenter),
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.Center

     ){

         Button(
            onClick = {
                gameViewModel.restartGame()
                navController.navigate(Screen.GameScreen.route)
            },
            colors = ButtonDefaults.buttonColors(Color(0xFF053406)),
             modifier = Modifier
                 .width(235.dp)
                 .height(50.dp)
                 .offset(y = 20.dp)

         ) {
             Text(text = "Iniciar", fontSize = 14.sp,color = (Color(0xFFE0FFDD)), fontFamily = pressStart2p)
            }
        }
    }
}

