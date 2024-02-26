package com.example.navrail.navigation

sealed class Screen(val route: String){
    object SettingsScreen : Screen("settings_screen")
    object HomeScreen : Screen("home_screen")
    object EmailScreen : Screen("email_screen")


    fun withArgs(vararg args: String): String{
        return buildString {
            append(route)
            args.forEach { arg->
                append("/$arg")
            }
        }
    }
}
