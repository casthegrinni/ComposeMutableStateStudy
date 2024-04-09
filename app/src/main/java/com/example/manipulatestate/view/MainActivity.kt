package com.example.manipulatestate.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.manipulatestate.ui.theme.ManipulateStateTheme
import com.example.manipulatestate.viewModel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ManipulateStateTheme {
                MyApp()
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MyApp(viewModel: MainViewModel = MainViewModel()) {
    var moneyCounter: Int by remember { mutableIntStateOf(100)  }
//    var moneyCounter = remember {
//        mutableIntStateOf(0)
//    }
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color(0xFF546E7A)) {

        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            var textBeingTyped: String by remember { mutableStateOf("") }

            Column {
                Text(
                    text = "You're tiping:",
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                    style = TextStyle(
                        color = Color.White,
                        fontFamily = FontFamily.Monospace,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold))

                Text(
                    text = textBeingTyped,
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                    style = TextStyle(
                        color = Color.White,
                        fontFamily = FontFamily.Monospace,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold))
            }

            Spacer(modifier = Modifier.height(30.dp))

            TextField(
                value = textBeingTyped,
                onValueChange = { textBeingTyped = it },
                colors = OutlinedTextFieldDefaults
                    .colors(
                        cursorColor = Color.Cyan,
                        focusedBorderColor = Color.Cyan,
                        unfocusedBorderColor = Color.LightGray,
                        focusedLabelColor = Color.Cyan,
                    )
                ,
                textStyle = TextStyle(
                    color = Color.White,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                ),
                label = { Text("Your text") }
            )

            Spacer(modifier = Modifier.height(100.dp))

            Text(text = "$$moneyCounter",
                style = TextStyle(
                    color = Color.White,
                    fontFamily = FontFamily.Cursive,
                    fontSize = 39.sp,
                    fontWeight = FontWeight.ExtraBold))
            Spacer(modifier = Modifier.height(20.dp))
            CreateCircle {
                moneyCounter += it
            }

            Spacer(modifier = Modifier.height(50.dp))

            PostList(viewModel = viewModel)
        }

    }
}

@Composable
fun CreateCircle(updateMoneyCounter: (Int) -> Unit = {}) {
    Card(
        modifier = Modifier
            .padding(3.dp)
            .size(145.dp)
            .clickable { updateMoneyCounter(10) },
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center) {

            Text(
                text = "Tap",
                fontFamily = FontFamily.Cursive,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold)
        }

    }
}