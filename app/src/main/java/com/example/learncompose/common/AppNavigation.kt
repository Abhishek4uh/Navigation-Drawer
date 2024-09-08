package com.example.learncompose.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.learncompose.AuthViewModel
import com.example.learncompose.presentations.about.AboutScreen
import com.example.learncompose.presentations.details.DetailScreen
import com.example.learncompose.presentations.forgot.ForgotPasswordScreen
import com.example.learncompose.presentations.home.HomeScreen
import com.example.learncompose.presentations.login.LoginScreen
import com.example.learncompose.presentations.otp.OtpScreen
import com.example.learncompose.presentations.signup.SignUpScreen

@Composable
fun AppNavigation(navHostController: NavHostController, authViewModel: AuthViewModel) {


    val isLoggedIn by authViewModel.isLoggedIn.collectAsState(initial = false)


    val startDestination = if (isLoggedIn) {
        NavGraphRoute.Main.route            // Go to the home screen if the user is logged in
    } else {
        NavGraphRoute.Authentication.route  // Go to login/signup flow if not logged in
    }



    NavHost(navController = navHostController, startDestination = startDestination){    //AppScreen.Login.route

        composable("about"){
            AboutScreen(authViewModel = authViewModel)
        }

        //Auth
        navigation(startDestination = AppScreen.Login.route, route= NavGraphRoute.Authentication.route){

            composable(AppScreen.Login.route){
                LoginScreen(
                    authViewModel,
                    onLoginSuccess ={
                        navHostController.navigate(NavGraphRoute.Main.route) {
                            popUpTo(NavGraphRoute.Authentication.route) {
                                inclusive = true
                            }
                        }
                    },
                    onSignUp = {
                        navHostController.navigate(AppScreen.SignUp.route)
                    },
                    onForgotPassword = {
                        navHostController.navigate(AppScreen.ForgotPassword.route)
                    }
                )
            }
            composable(AppScreen.SignUp.route){
                SignUpScreen(authViewModel, onOtpScreen = {
                    navHostController.navigate(AppScreen.OtpScreen.route)
                })
            }
            composable(AppScreen.ForgotPassword.route){
                ForgotPasswordScreen(authViewModel, onOtpScreen = {
                    navHostController.navigate(AppScreen.OtpScreen.route)
                })
            }
            composable(AppScreen.OtpScreen.route){
                OtpScreen(authViewModel, onHomeScreen = {
                    navHostController.navigate(NavGraphRoute.Main.route){
                        popUpTo(NavGraphRoute.Authentication.route) {
                            inclusive = true
                        }
                    }
                })
            }
        }

        //main
        navigation(startDestination = AppScreen.Home.route, route= NavGraphRoute.Main.route){
            composable(AppScreen.Home.route){
                HomeScreen(navHostController)

            }
            composable(AppScreen.Detail.route){
                DetailScreen(navHostController)
            }
        }
    }
}