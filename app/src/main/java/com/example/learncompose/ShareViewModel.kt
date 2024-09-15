package com.example.learncompose


import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learncompose.data.local.UserPrefrences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val userPrefrences: UserPrefrences):ViewModel() {

    val isLoggedIn= userPrefrences.userLoggedIn()

    var isSplash by mutableStateOf(false)

    init {
        viewModelScope.launch {
            delay(2000)
            isSplash= false
        }
    }

    // Synchronous login state fetcher
    suspend fun isLoggedInSync(): Boolean {
        return userPrefrences.isLoggedInSync()
    }



    fun saveIsLogin(isLogin:Boolean){
        viewModelScope.launch{
            userPrefrences.saveLoggedIn(isLogin)
        }
    }
}