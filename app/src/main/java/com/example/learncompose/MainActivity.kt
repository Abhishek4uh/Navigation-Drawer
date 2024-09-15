package com.example.learncompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.example.learncompose.common.AppNavigation
import com.example.learncompose.theme.LearnComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // Set up the splash screen
        val splashScreen = installSplashScreen()

        // Launch a coroutine to check the login state before setting content
        lifecycleScope.launch {
            val isLoggedIn = viewModel.isLoggedInSync()

            Log.d("MainActivity","here 1 $isLoggedIn")

            // Once the login state is known, set the UI content
            setContent {
                // Splash screen condition
                Log.d("MainActivity","here 2 $isLoggedIn")

                splashScreen.setKeepOnScreenCondition { viewModel.isSplash }

                LearnComposeTheme {
                    val navController = rememberNavController()

                    Log.d("MainActivity","here 3 $isLoggedIn")

                    // Navigate based on login state
                    AppNavigation(
                        navHostController = navController,
                        isLoggedIn = isLoggedIn,
                        authViewModel = viewModel
                    )
                }
            }
        }
    }
}
