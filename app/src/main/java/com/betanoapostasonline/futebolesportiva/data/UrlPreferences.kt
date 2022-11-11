package com.betanoapostasonline.futebolesportiva.data

import android.content.Context
import android.preference.PreferenceManager
import android.util.Log
import androidx.core.content.edit

private const val TOKEN_KEY = "token"

class UrlPreferences(context: Context) {

    private val prefs = PreferenceManager.getDefaultSharedPreferences(context)

    fun getToken(): String? {
        val value = prefs.getString(TOKEN_KEY, null)
        Log.d("UrlPreferences", "return value $value")
        return value
    }

    fun setToken(value: String) {
        prefs.edit {
            putString(TOKEN_KEY, value)
            commit()
            Log.d("UrlPreferences", "new value $value")
        }
    }
}
