package com.betanoapostasonline.futebolesportiva.app


import android.app.Application
import com.betanoapostasonline.futebolesportiva.di.appModule
import com.betanoapostasonline.futebolesportiva.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule, dataModule))
        }
    }
}