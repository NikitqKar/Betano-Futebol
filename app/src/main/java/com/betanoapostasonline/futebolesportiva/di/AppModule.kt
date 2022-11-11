package com.betanoapostasonline.futebolesportiva.di

import com.betanoapostasonline.futebolesportiva.data.UrlPreferences
import com.betanoapostasonline.futebolesportiva.data.UrlRemoteDataSource
import com.betanoapostasonline.futebolesportiva.data.UrlRepository
import com.betanoapostasonline.futebolesportiva.screen.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel {
        MainViewModel(get())
    }
}

val dataModule = module {
    single { UrlPreferences( get()) }

    single { UrlRepository(get(), get()) }

    single { UrlRemoteDataSource() }
}