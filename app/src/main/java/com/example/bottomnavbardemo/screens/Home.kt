package com.example.bottomnavbardemo.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.bottomnavbardemo.ARGKEY
import com.example.bottomnavbardemo.R
import com.example.bottomnavbardemo.viewmodels.TodoViewModel

@Composable
fun HomeScreen(navController: NavHostController, vm: TodoViewModel) {

    data class OnSellItems(var name: String, var description: String, var price: Double);
    var computer = OnSellItems("Computer", "On good state", 200.4)
    var OnSellItemsList = listOf<OnSellItems>(computer)
    LaunchedEffect(key1 = Unit, block = {
        vm.getTodoList()
    })
    Log.d("todo list itmes", vm.todoList.size.toString())
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.LightGray)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            searchBar()
            userIcon()
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            titleText(title = "Bton Market")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            OnSellItems(navController)
        }

    }
}

@Composable
fun OnSellItems(navController: NavHostController){
    // lazy column goes here
    val list = listOf(
        "A", "B", "C", "D"
    ) + ((0..100).map { it.toString() })
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(items = list, itemContent = { item ->
            Log.d("COMPOSE", "This get rendered $item")
            when (item) {
                "A" -> {
                    CardDemo(navController)
                }
                "B" -> {
                    CardDemo(navController)
                }
                "C" -> {
                    CardDemo(navController)
                }
                "D" -> {
                    CardDemo(navController)
                }
                else -> {
                    CardDemo(navController)
                }
            }
        })
    }
}

@Composable
fun Text(text: String, style: TextStyle){

}

@Composable
fun titleText(title: String){
    Text(text = title, color = colorResource(id = R.color.customBlue))
}

@Composable
fun searchBar(){
    Text(text = "search bar", color = colorResource(id = R.color.customBlue))
}

@Composable
fun userIcon(){
    Icon(Icons.Rounded.Person, contentDescription = "User Profile Picture")
}

@Composable
fun CardDemo(navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable {
                navController.navigate(route = "detail-screen/" + 1)
            },
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(
                buildAnnotatedString {
                    append("welcome to ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W900, color = Color(0xFF4552B8))
                    ) {
                        append("Jetpack Compose Playground")
                    }
                }
            )
            Text(
                buildAnnotatedString {
                    append("Now you are in the ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W900)) {
                        append("Card")
                    }
                    append(" section")
                }
            )
        }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    //HomeScreen()
}