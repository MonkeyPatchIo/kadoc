package com.example.kadoc.android

import android.app.Application
import appModules
import com.example.kadoc.Injector

class MainApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        Injector.initKoin {
            modules(appModules)
        }
    }
}
