package com.nbelyse.contacts

import android.app.Application
import android.content.Context

class MyContactCloneApp:Application() {
    companion object{
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }
}