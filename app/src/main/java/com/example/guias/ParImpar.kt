package com.example.guias

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.guias.ui.theme.AppTheme
import kotlin.random.Random

class ParImpar : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ParImparGame(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ParImparGame(modifier: Modifier = Modifier) {
    var number by remember { mutableStateOf(Random.nextInt(1, 11)) }  // Número entre 1 y 10
    var correctAnswers by remember { mutableStateOf(0) }
    var incorrectAnswers by remember { mutableStateOf(0) }

    fun checkAnswer(isEven: Boolean) {
        val isCorrect = if (isEven) number % 2 == 0 else number % 2 != 0
        if (isCorrect) {
            correctAnswers++
        } else {
            incorrectAnswers++
        }
        number = Random.nextInt(1, 11)
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Correctas: $correctAnswers" )
        Text(text = "Incorrectas: $incorrectAnswers")
        Text(text = "$number", fontSize = 64.sp,  style = MaterialTheme.typography.displayLarge,)

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Button(
                onClick = { checkAnswer(true) },
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Text(text = "Par")
            }

            Button(
                    onClick = { checkAnswer(false) },
            modifier = Modifier
                .padding(8.dp)
            ) {
            Text(text = "Impar")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ParImparGamePreview() {
    AppTheme {
        ParImparGame()
    }
}