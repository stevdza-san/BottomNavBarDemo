package com.example.bottomnavbardemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.bottomnavbardemo.screens.HomeScreen
import com.example.bottomnavbardemo.ui.theme.BottomNavBarDemoTheme
import com.example.bottomnavbardemo.viewmodels.TodoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val vm = TodoViewModel()
        super.onCreate(savedInstanceState)
        setContent {
            BottomNavBarDemoTheme {
                MainScreen(vm)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    BottomNavBarDemoTheme {
        //MainScreen()
    }
}

