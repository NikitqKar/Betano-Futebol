package com.betanoapostasonline.futebolesportiva.data

import android.util.Log
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UrlRemoteDataSource {

    private val _token: MutableStateFlow<UrlResult> = MutableStateFlow(UrlResult.Failure)
    var token: StateFlow<UrlResult> = _token

    fun initRemoteConfig() {
        FirebaseRemoteConfig.getInstance().apply {
            setConfigSettingsAsync(
                FirebaseRemoteConfigSettings.Builder()
                    .setMinimumFetchIntervalInSeconds(3600)
                    .build()
            )
            fetchAndActivate().addOnSuccessListener {
                Log.d("UrlRemoteDataSource", "new value $it")
                _token.value = UrlResult.Success(getString("astarpe"))
            }.addOnFailureListener {
                Log.e("UrlRemoteDataSource", "new value fail", it)
                _token.value = UrlResult.Failure
            }
            activate()
        }
    }
}

sealed class UrlResult {
    class Success(val value: String) : UrlResult()
    object Failure : UrlResult()
}