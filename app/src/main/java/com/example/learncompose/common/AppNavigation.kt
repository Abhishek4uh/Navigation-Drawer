package com.example.learncompose.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.learncompose.AuthViewModel
import com.example.learncompose.common.navgraph.authNavGraph
import com.example.learncompose.common.navgraph.mainNavGraph
import com.example.learncompose.presentations.about.AboutScreen
import com.example.learncompose.presentations.details.DetailScreen
import com.example.learncompose.presentations.forgot.ForgotPasswordScreen
import com.example.learncompose.presentations.home.HomeScreen
import com.example.learncompose.presentations.login.LoginScreen
import com.example.learncompose.presentations.otp.OtpScreen
import com.example.learncompose.presentations.signup.SignUpScreen

@Composable
fun AppNavigation(
    navHostController: NavHostController,
    isLoggedIn: Boolean,
    authViewModel: AuthViewModel
) {


    val startDestination = if (isLoggedIn) {
        NavGraphRoute.Main            // Go to the home screen if the user is logged in
    } else {
        NavGraphRoute.Authentication  // Go to login/signup flow if not logged in
    }



    NavHost(navController = navHostController, startDestination = startDestination){    //AppScreen.Login.route

        composable("about"){
            AboutScreen(authViewModel = authViewModel)
        }

        authNavGraph(navHostController, authViewModel)
        mainNavGraph(navHostController,authViewModel)
    }
}