package com.example.learncompose.presentations.signup

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
fun SignUpScreen(authViewModel: AuthViewModel, onOtpScreen: () -> Unit) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Button(
            onClick = {
                onOtpScreen.invoke()
            }){
            Text(text = "SignUp And Verify", color = Color.Black, fontSize = 16.sp)
        }

    }
}