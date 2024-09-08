package com.example.learncompose

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApp:Application() {

    companion object{
        const val TAG="Base_Application_initialization"
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG,"onCreate")
    }
}