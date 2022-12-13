package com.example.bottomnavbardemo.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SettingsScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
        contentAlignment = Alignment.Center
    ) {
        var inputText by remember {
            mutableStateOf("")
        }
        UserInput(
            inputText,
            updateInputText = {
                inputText = it
            }
        )
    }
}

@Composable
fun UserInput(inputText:String, updateInputText: (String)->Unit) {
    OutlinedTextField(
        value = inputText,
        onValueChange = {
            updateInputText(it)
            Log.d("input text", inputText)
        }
    )
}


@Composable
@Preview
fun SettingsScreenPreview() {
    SettingsScreen()
}