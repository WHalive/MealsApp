package com.example.restapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

class Prefs(context: Context) {
    private val sharedPreferences =
        context.getSharedPreferences("myPreference", AppCompatActivity.MODE_PRIVATE)

    val getIsClicked
        get() = sharedPreferences.getBoolean("Boolean", false)

    fun saveIsNextClicked(isClicked: Boolean) {

        sharedPreferences.edit()
            .putBoolean("Boolean", isClicked)
            .apply()
    }
}
