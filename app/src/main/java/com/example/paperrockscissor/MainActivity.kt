package com.example.paperrockscissor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.paperrockscissor.ui.theme.PaperRockScissorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaperRockScissorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
                  ButtonsTxt()
                }
            }
        }
    }
}

@Composable
fun ButtonsTxt() {

    var number by remember {
        mutableStateOf(0)
    }

    var pcNumber by remember {
        mutableStateOf(0)
    }

    var point by remember {
        mutableStateOf(0)
    }

    var pcPoint by remember {
        mutableStateOf(0)
    }

    var text by remember {
        mutableStateOf("")
    }

    var win by remember {
        mutableStateOf(0)
    }

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Row(
            Modifier.padding(bottom = 16.dp)
        ) {
            //ROCK
            Button(
                onClick = { number = 0
                    pcNumber = computer();
                       if(number == 0 && pcNumber == 1 || number == 1 && pcNumber == 2 || number == 2 && pcNumber == 0)
                       {
                           win = 0
                           pcPoint++
                       }
                    if(number == 1 && pcNumber == 0 || number == 2 && pcNumber == 1 || number == 0 && pcNumber == 2)
                    {
                        win = 1
                        point++
                    }
                    if(number == pcNumber || number == pcNumber || number == pcNumber )
                    {
                        win = 2
                    }
            }) {Text(text = "rock")}
            // PAPER
            Button(
                onClick = { number = 0
                    pcNumber = computer();
                    if(number == 0 && pcNumber == 1 || number == 1 && pcNumber == 2 || number == 2 && pcNumber == 0)
                    {
                        win = 0
                        pcPoint++
                    }
                    if(number == 1 && pcNumber == 0 || number == 2 && pcNumber == 1 || number == 0 && pcNumber == 2)
                    {
                        win = 1
                        point++
                    }
                    if(number == pcNumber || number == pcNumber || number == pcNumber )
                    {
                        win = 2
                    }
                }) {Text(text = "paper")}
            // SCISSORS
            Button(
                onClick = { number = 0
                    pcNumber = computer();
                    if(number == 0 && pcNumber == 1 || number == 1 && pcNumber == 2 || number == 2 && pcNumber == 0)
                    {
                        win = 0
                        pcPoint++
                    }
                    if(number == 1 && pcNumber == 0 || number == 2 && pcNumber == 1 || number == 0 && pcNumber == 2)
                    {
                        win = 1
                        point++
                    }
                    if(number == pcNumber || number == pcNumber || number == pcNumber )
                    {
                        win = 2
                    }
                }) {Text(text = "scissors")}
        }
        Row {
            Text(
                modifier = Modifier.padding(top = 16.dp),
                fontSize = 36.sp,
                text = ""+point
            )
            immage(number)
            immage(pcNumber)
            Text(
                modifier = Modifier.padding(top = 16.dp),
                fontSize = 36.sp,
                text = ""+pcPoint
            )

        }
        if (win == 0){
            text = stringResource(R.string.perso)
        }
        if (win == 0){
            text = stringResource(R.string.vinto)
        }
        if (win == 0){
            text = stringResource(R.string.pareggio)
        }

    }

}

@Composable
fun immage(number: Int)  {
    if(number == 0){
        Image(painter = painterResource(R.drawable.rock), contentDescription = null)
    }
    if(number == 0){
        Image(painter = painterResource(R.drawable.paper), contentDescription = null)
    }
    if(number == 0){
        Image(painter = painterResource(R.drawable.scissors), contentDescription = null)
    }
}

fun computer(): Int{
    return(0..2).random()
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}