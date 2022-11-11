package com.betanoapostasonline.futebolesportiva.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UrlRepository(
    private val urlPreferences: UrlPreferences,
    private val urlRemoteDataSource: UrlRemoteDataSource
) {

    private var _tokenFlow: MutableStateFlow<String> = MutableStateFlow("")
    var tokenFlow: StateFlow<String> = _tokenFlow

    suspend fun initRemoteDataSource() {
        urlRemoteDataSource.initRemoteConfig()

        urlRemoteDataSource.token.collect {
            if(it is UrlResult.Success){
                urlPreferences.setToken(it.value)
                _tokenFlow.value = it.value
            }else{
                _tokenFlow.value = urlPreferences.getToken() ?: ""
            }
        }
    }
}