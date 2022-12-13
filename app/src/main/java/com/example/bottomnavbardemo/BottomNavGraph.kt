package com.example.bottomnavbardemo

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.bottomnavbardemo.screens.HomeScreen
import com.example.bottomnavbardemo.screens.ProfileScreen
import com.example.bottomnavbardemo.screens.SettingsScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(navController)
        }
        composable(
            route = BottomBarScreen.Profile.route,
            arguments = listOf(navArgument("id"){
                type = NavType.IntType
            })
        ) {
            Log.d("arg debug", it.arguments?.getInt("id").toString())
            ProfileScreen()
        }
        composable(route = BottomBarScreen.Settings.route) {
            SettingsScreen()
        }
    }
}