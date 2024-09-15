package com.example.learncompose.common.navgraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.learncompose.AuthViewModel
import com.example.learncompose.common.AppScreen
import com.example.learncompose.common.NavGraphRoute
import com.example.learncompose.presentations.forgot.ForgotPasswordScreen
import com.example.learncompose.presentations.login.LoginScreen
import com.example.learncompose.presentations.otp.OtpScreen
import com.example.learncompose.presentations.signup.SignUpScreen

fun NavGraphBuilder.authNavGraph(navController: NavController, authViewModel:AuthViewModel){
    //Auth
    /* navigation(startDestination = AppScreen.Login.route, route= NavGraphRoute.Authentication.route){

        composable(AppScreen.Login.route){
            LoginScreen(
                authViewModel,
                onLoginSuccess ={
                    navController.navigate(NavGraphRoute.Main.route) {
                        popUpTo(NavGraphRoute.Authentication.route) {
                            inclusive = true
                        }
                    }
                },
                onSignUp = {
                    navController.navigate(AppScreen.SignUp.route)
                },
                onForgotPassword = {
                    navController.navigate(AppScreen.ForgotPassword.route)
                }
            )
        }
        composable(AppScreen.SignUp.route){
            SignUpScreen(authViewModel, onOtpScreen = {
                navController.navigate(AppScreen.OtpScreen.route)
            })
        }
        composable(AppScreen.ForgotPassword.route){
            ForgotPasswordScreen(authViewModel, onOtpScreen = {
                navController.navigate(AppScreen.OtpScreen.route)
            })
        }
        composable(AppScreen.OtpScreen.route){
            OtpScreen(authViewModel, onHomeScreen = {
                navController.navigate(NavGraphRoute.Main.route){
                    popUpTo(NavGraphRoute.Authentication.route) {
                        inclusive = true
                    }
                }
            })
        }
    }*/

    navigation<NavGraphRoute.Authentication>(startDestination = AppScreen.Login){
        composable<AppScreen.Login> {
            LoginScreen(
                authViewModel,
                onLoginSuccess ={
                    navController.navigate(NavGraphRoute.Main) {
                        popUpTo(NavGraphRoute.Authentication) {
                            inclusive = true
                        }
                    }
                },
                onSignUp = {
                    navController.navigate(AppScreen.SignUp)
                },
                onForgotPassword = {
                    navController.navigate(AppScreen.ForgotPassword)
                }
            )
        }
        composable<AppScreen.SignUp> {
            SignUpScreen(authViewModel, onOtpScreen = {
                navController.navigate(AppScreen.OtpScreen)
            })
        }
        composable<AppScreen.ForgotPassword> {
            ForgotPasswordScreen(authViewModel, onOtpScreen = {
                navController.navigate(AppScreen.OtpScreen)
            })
        }
        composable<AppScreen.OtpScreen> {
            OtpScreen(authViewModel, onHomeScreen = {
                navController.navigate(NavGraphRoute.Main){
                    popUpTo(NavGraphRoute.Authentication) {
                        inclusive = true
                    }
                }
            })
        }
    }
}