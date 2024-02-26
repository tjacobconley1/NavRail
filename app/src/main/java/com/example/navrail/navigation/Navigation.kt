package com.example.navrail.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navrail.screens.EmailScreen
import com.example.navrail.screens.HomeScreen
import com.example.navrail.screens.SettingsScreen
import com.example.navrail.viewmodels.HomeScreenViewModel
import com.example.navrail.viewmodels.HomeScreenViewModel as HomeScreenViewModel1

@Composable
fun Navigation(){

    val navController = rememberNavController()
    var homeScreenViewModel = HomeScreenViewModel()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route ){
        composable(route = Screen.HomeScreen.route){
            HomeScreen(navController = navController, homeScreenViewModel)
        }
        composable(route = Screen.SettingsScreen.route){
            SettingsScreen(navController = navController)
        }
        composable(route = Screen.EmailScreen.route){
            EmailScreen(navController = navController)
        }


    }

}