package com.example.midtermexam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.midtermexam.ui.theme.MidtermExamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MidtermExamTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    var rgb by remember {
        mutableStateOf(RGB(0, 0, 0))
    }

    var rgbView by remember {
        mutableStateOf(RGB(0, 0, 0))
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            TextField(
                value = rgb.red.toString(),
                onValueChange = { rgbUpdated ->
                    val digitsOnly = rgbUpdated.filter { it.isDigit() }
                    if (digitsOnly.isNotEmpty()) {
                        if (digitsOnly.toInt() < 0) {
                            rgb = rgb.copy(red = 0)
                        } else if (digitsOnly.toInt() > 255) {
                            rgb = rgb.copy(red = 255)
                        } else {
                            rgb = rgb.copy(red = digitsOnly.toInt())
                        }
                    } else {
                        rgb = rgb.copy(red = 0)
                    }
                },
                label = { Text(text = "Red") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
            TextField(
                value = rgb.green.toString(),
                onValueChange = { rgbUpdated ->
                    val digitsOnly = rgbUpdated.filter { it.isDigit() }
                    if (digitsOnly.isNotEmpty()) {
                        if (digitsOnly.toInt() < 0) {
                            rgb = rgb.copy(green = 0)
                        } else if (digitsOnly.toInt() > 255) {
                            rgb = rgb.copy(green = 255)
                        } else {
                            rgb = rgb.copy(green = digitsOnly.toInt())
                        }
                    } else {
                        rgb = rgb.copy(green = 0)
                    }
                },
                label = { Text(text = "Green") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
            TextField(
                value = rgb.blue.toString(),
                onValueChange = { rgbUpdated ->
                    val digitsOnly = rgbUpdated.filter { it.isDigit() }
                    if (digitsOnly.isNotEmpty()) {
                        if (digitsOnly.toInt() < 0) {
                            rgb = rgb.copy(blue = 0)
                        } else if (digitsOnly.toInt() > 255) {
                            rgb = rgb.copy(blue = 255)
                        } else {
                            rgb = rgb.copy(blue = digitsOnly.toInt())
                        }
                    } else {
                        rgb = rgb.copy(blue = 0)
                    }
                },
                label = { Text(text = "Blue") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color(rgb.red, rgb.green, rgb.blue))
        )
    }
}

@Preview(showBackground = true, widthDp = 300, heightDp = 300)
@Composable
private fun MainScreenPreview() {
    MainScreen()
}

data class RGB(
    val red: Int,
    val green: Int,
    val blue: Int,
)
