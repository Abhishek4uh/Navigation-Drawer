package com.example.learncompose.data.local

import androidx.datastore.preferences.core.booleanPreferencesKey
import kotlinx.coroutines.flow.Flow


val ISLOGGEDIN= booleanPreferencesKey("is_loggedIn")
interface UserPrefrences {
    fun userLoggedIn():Flow<Boolean>
    suspend fun saveLoggedIn(isLogin:Boolean)
}