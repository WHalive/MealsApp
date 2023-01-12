package com.example.restapp

import android.app.Application

class RestApp : Application() {

    val prefs by lazy { Prefs(applicationContext) }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        lateinit var INSTANCE: RestApp
            private set
    }
}