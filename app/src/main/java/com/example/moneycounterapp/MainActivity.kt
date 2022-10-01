package com.example.moneycounterapp

import android.os.Bundle
import android.util.Log
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moneycounterapp.ui.theme.MoneyCounterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoneyCounterAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MoneyCounter ()
                }
            }
        }
    }
}
@Composable
fun MoneyCounter() {
    Column(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        var count by remember {
            mutableStateOf(0)
        }       
        Text(text = "$$count", fontWeight = FontWeight.Bold, fontSize = 50.sp)
        Spacer(modifier = Modifier.height(50.dp))

        CounterButton(count){
            count = it +10
        }
        if(count >= 100) {
            Text(text = "You have lots of money", fontSize = 30.sp)
        }
    }
}
@Composable
fun CounterButton(count: Int, UpdateCount: (Int) -> Unit) {
    Button(onClick = { UpdateCount(count) },
        shape = CircleShape,
        elevation = ButtonDefaults.elevation(8.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
        modifier = Modifier
            .height(150.dp)
            .width(150.dp)) {
        Text(text = "Tap", fontSize = 30.sp, fontWeight = FontWeight.Bold)
    }
}
@Preview(showBackground = true , showSystemUi = true)
@Composable
fun DefaultPreview() {
    MoneyCounterAppTheme {
        MoneyCounter()
    }
}