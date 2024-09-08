package com.example.learncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.learncompose.common.AppNavigation
import com.example.learncompose.theme.LearnComposeTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<AuthViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen= installSplashScreen()
        setContent {
            splashScreen.setKeepOnScreenCondition{ viewModel.isSplash }
            LearnComposeTheme {
                AppNavigation(navHostController = rememberNavController(),authViewModel =viewModel)
            }
        }
    }
}
