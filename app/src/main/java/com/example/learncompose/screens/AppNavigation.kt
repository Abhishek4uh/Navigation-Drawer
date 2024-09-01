package com.example.learncompose.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.learncompose.screens.screen.HomeScreen

@Composable
fun AppNavigation() {
    val navController= rememberNavController()
    HomeScreen(navController)
}