package com.example.learncompose.presentations.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.learncompose.AuthViewModel
import com.example.learncompose.common.AppScreen
import com.example.learncompose.common.NavGraphRoute


@Composable
fun HomeScreen(navHostController: NavController, authViewModel: AuthViewModel) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
        Text(text = "Welcome bacK Screen", color = Color.Black, fontSize = 16.sp)

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = {navHostController.navigate(AppScreen.Detail("Abhishek","araj62630@gmail.com"))}) {
            Text(text = "Detail Page", color = Color.Black, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick ={
            authViewModel.saveIsLogin(false)
            navHostController.navigate(NavGraphRoute.Authentication){
                popUpTo(NavGraphRoute.Main){
                    inclusive=true
                }
            }
        } ) {
            Text(text = "Logout", color = Color.Black, fontSize = 16.sp)
        }
    }
}
