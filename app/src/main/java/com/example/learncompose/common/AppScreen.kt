package com.example.learncompose.common

import kotlinx.serialization.Serializable

sealed class AppScreen{
    @Serializable
    data object Login: AppScreen()
    @Serializable
    data object SignUp: AppScreen()
    @Serializable
    data object ForgotPassword: AppScreen()
    @Serializable
    data object OtpScreen: AppScreen()

    //Main Screen
    @Serializable
    data object Home: AppScreen()
    @Serializable
    data class Detail(val name:String, val email:String): AppScreen()
}

sealed class NavGraphRoute{
    @Serializable
    data object Authentication: NavGraphRoute()
    @Serializable
    data object Main: NavGraphRoute()
}