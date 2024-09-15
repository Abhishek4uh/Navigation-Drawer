package com.example.learncompose.common.navgraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.toRoute
import com.example.learncompose.AuthViewModel
import com.example.learncompose.common.AppScreen
import com.example.learncompose.common.NavGraphRoute
import com.example.learncompose.presentations.details.DetailScreen
import com.example.learncompose.presentations.home.HomeScreen

fun NavGraphBuilder.mainNavGraph(navController: NavController, authViewModel: AuthViewModel){

    navigation<NavGraphRoute.Main>(startDestination = AppScreen.Home){
        composable<AppScreen.Home> {
            HomeScreen(navController,authViewModel)
        }
        composable<AppScreen.Detail> {
            val data= it.toRoute<AppScreen.Detail>()
            DetailScreen(data,navController)
        }
    }
}