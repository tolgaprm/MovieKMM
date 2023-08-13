package com.prmto.moviekmm.di

import com.prmto.moviekmm.data.remote.MovieRemoteDataSource
import com.prmto.moviekmm.data.remote.MovieService
import com.prmto.moviekmm.data.repository.MovieRepositoryImpl
import com.prmto.moviekmm.domain.repository.MovieRepository
import com.prmto.moviekmm.domain.usecase.GetMovieUseCase
import com.prmto.moviekmm.domain.usecase.GetMoviesUseCase
import com.prmto.moviekmm.util.provideDispatcher
import org.koin.dsl.module

private val dataModule = module {
    factory { MovieRemoteDataSource(get(), get()) }
    factory { MovieService() }
}

private val utilModule = module {
    factory { provideDispatcher() }
}

private val domainModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get()) }
    factory { GetMovieUseCase() }
    factory { GetMoviesUseCase() }
}

private val sharedModules = listOf(dataModule, utilModule, domainModule)

fun getSharedModules() = sharedModules