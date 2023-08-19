package com.prmto.moviekmm.android

import android.app.Application
import com.prmto.moviekmm.android.di.appModule
import com.prmto.moviekmm.di.getSharedModules
import org.koin.core.context.startKoin

class Movie : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(getSharedModules() + appModule)
        }
    }
}