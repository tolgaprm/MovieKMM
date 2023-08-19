package com.prmto.moviekmm.android.di

import com.prmto.moviekmm.android.detail.DetailViewModel
import com.prmto.moviekmm.android.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get(), get()) }
}