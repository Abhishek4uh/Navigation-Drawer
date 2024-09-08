package com.example.learncompose.presentations.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.learncompose.AuthViewModel


@Composable
fun LoginScreen(
    authViewModel: AuthViewModel,
    onLoginSuccess: () -> Unit,
    onSignUp:()->Unit,
    onForgotPassword: () -> Unit) {

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Button(
            onClick = {
                authViewModel.saveIsLogin(true)
                onLoginSuccess.invoke()
            }){
            Text(text = "Login", color = Color.Black, fontSize = 16.sp)
        }

        Button(
            onClick = {
                onSignUp.invoke()
            }){
            Text(text = "SignUp", color = Color.Black, fontSize = 16.sp)
        }

        Button(
            onClick = {
                onForgotPassword.invoke()
            }){
            Text(text = "Forgot", color = Color.Black, fontSize = 16.sp)
        }

    }

}


