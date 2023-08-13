package com.prmto.moviekmm.util

import com.prmto.moviekmm.di.getSharedModules
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(getSharedModules())
    }
}