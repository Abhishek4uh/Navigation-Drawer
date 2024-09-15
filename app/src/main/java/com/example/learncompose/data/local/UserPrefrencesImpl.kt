package com.example.learncompose.data.local

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class UserPrefrencesImpl(private val dataStore: DataStore<Preferences>):UserPrefrences {

    override fun userLoggedIn(): Flow<Boolean> {
        return dataStore.data.catch { emit(emptyPreferences()) }.map {preferences->
            preferences[ISLOGGEDIN]?:false
        }
    }

    override suspend fun isLoggedInSync(): Boolean {
        val preferences = dataStore.data.first() // Fetch the current state directly
        Log.d("MainActivity","shared 1 $preferences")
        Log.d("MainActivity","shared 2 ${preferences[ISLOGGEDIN]}")
        return preferences[ISLOGGEDIN] ?: false
    }

    override suspend fun saveLoggedIn(isLogin: Boolean) {
        dataStore.edit { preferences ->
            preferences[ISLOGGEDIN] = isLogin
        }
    }
}