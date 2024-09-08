package com.example.learncompose.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class UserPrefrencesImpl(private val dataStore: DataStore<Preferences>):UserPrefrences {

    override fun userLoggedIn(): Flow<Boolean> {
        return dataStore.data.catch { emit(emptyPreferences()) }.map {preferences->
            preferences[ISLOGGEDIN]?:false
        }
    }

    override suspend fun saveLoggedIn(isLogin: Boolean) {
        dataStore.edit { preferences ->
            preferences[ISLOGGEDIN] = isLogin
        }
    }
}