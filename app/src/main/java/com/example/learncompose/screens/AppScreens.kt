package com.example.learncompose.screens

sealed class AppScreens(val route: String) {
    data object Account : AppScreens("account")
    data object Image : AppScreens("image")
    data object Shopping:AppScreens("shopping")
    data object Settings:AppScreens("setting")
    data object Notification:AppScreens("notification")
}