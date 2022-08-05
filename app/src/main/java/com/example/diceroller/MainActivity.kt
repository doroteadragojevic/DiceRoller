package com.example.diceroller


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize()) {
                    But()
                }
            }
        }
    }
}

@Composable
fun But() {
    var result by remember { mutableStateOf(R.drawable.empty_dice) }
    Box(
        modifier = Modifier.background(color = Color(0xFFF2E2D2)).wrapContentSize(align = Alignment.Center)
    ) {
        Box(
            modifier = Modifier
                .offset(0.dp, (-30).dp)
                .height(260.dp)
                .width(260.dp)
                .wrapContentSize(align = Alignment.Center)

        ) {
            Icon(painterResource(id = result), contentDescription = null, tint = Color.Unspecified)
        }
        Button(
            onClick = { result = rollDice() },
            modifier = Modifier
                .width(200.dp)
                .height(50.dp)
                .offset(30.dp, 270.dp),
            colors = buttonColors(
                backgroundColor= Color(0xFF84C0C6)
            )
        ) {
            Text(text = "Roll", fontSize=20.sp)
        }
    }
}


fun rollDice(): Int {
    return when (Random().nextInt(6) + 1) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

}



