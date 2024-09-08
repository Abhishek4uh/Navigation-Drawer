package com.example.learncompose.common

sealed class AppScreen(val route:String){
    data object Login: AppScreen("login")
    data object SignUp: AppScreen("signup")
    data object ForgotPassword: AppScreen("forgot_password")
    data object OtpScreen: AppScreen("otp_screen")
    data object Home: AppScreen("home")
    data object Detail: AppScreen("details")

}

sealed class NavGraphRoute(val route: String){
    data object Authentication: NavGraphRoute("auth")
    data object Main: NavGraphRoute("main")
}