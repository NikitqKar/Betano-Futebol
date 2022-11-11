package com.betanoapostasonline.futebolesportiva.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.betanoapostasonline.futebolesportiva.data.UrlRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: UrlRepository
) : ViewModel() {

    val token = repository.tokenFlow

    fun start() {
        viewModelScope.launch(Dispatchers.Default) { repository.initRemoteDataSource() }
    }
}
