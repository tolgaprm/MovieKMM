package com.prmto.moviekmm.android

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.prmto.moviekmm.android.common.Detail
import com.prmto.moviekmm.android.common.Home
import com.prmto.moviekmm.android.common.MovieAppBar
import com.prmto.moviekmm.android.common.movieDestinations
import com.prmto.moviekmm.android.detail.DetailScreen
import com.prmto.moviekmm.android.detail.DetailViewModel
import com.prmto.moviekmm.android.home.HomeScreen
import com.prmto.moviekmm.android.home.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MovieApp() {
    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = movieDestinations.find { destination ->
        backStackEntry?.destination?.route == destination.route || backStackEntry?.destination?.route == destination.routeWithArgs
    } ?: Home

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            MovieAppBar(
                canNavigateBack = navController.previousBackStackEntry != null,
                currentScreen = currentScreen,
                onNavigateBack = {
                    navController.navigateUp()
                }
            )
        }
    ) { paddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            startDestination = Home.route
        ) {
            composable(Home.route) {
                val homeViewModel: HomeViewModel = koinViewModel()
                HomeScreen(
                    uiState = homeViewModel.uiState,
                    loadNextMovies = homeViewModel::loadMovies,
                    onNavigateToDetail = { movie ->
                        navController.navigate("${Detail.route}/${movie.id}")
                    }
                )
            }

            composable(Detail.routeWithArgs, arguments = Detail.arguments) {
                val detailViewModel: DetailViewModel = koinViewModel()
                DetailScreen(
                    uiState = detailViewModel.uiState
                )
            }
        }
    }
}