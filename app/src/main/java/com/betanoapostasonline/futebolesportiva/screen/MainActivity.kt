package com.betanoapostasonline.futebolesportiva.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.betanoapostasonline.futebolesportiva.R
import com.onesignal.OneSignal

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId("4ce310c2-9980-46e6-bf0d-800b42b237c5")
    }
}