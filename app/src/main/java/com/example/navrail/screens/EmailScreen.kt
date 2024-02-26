package com.example.navrail.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.navrail.navigation.NavigationItem
import com.example.navrail.navigation.NavigationSideBar
import com.example.navrail.ui.theme.NavRailTheme

@Composable
fun EmailScreen(
    navController: NavController
){

    val context = LocalContext.current
    val showNavigationRail = true
    var selectedItemIndex: Int by rememberSaveable {
        mutableStateOf(0)
    }

    val railItems = listOf(
        NavigationItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false
        ),
        NavigationItem(
            title = "Email",
            selectedIcon = Icons.Filled.Email,
            unselectedIcon = Icons.Outlined.Email,
            hasNews = false,
            badgeCount = 45
        ),
        NavigationItem(
            title = "Settings",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            hasNews = true
        )

    )
    Text(text = "HELLO WORLD TEST EMAIL SCREEN")
    NavRailTheme {
        
        // OUTSIDE OF SURFACE
        // OUTSIDE OF SCAFFOLD
        if(showNavigationRail){
            NavigationSideBar(
                items = railItems,
                selectedItemIndex = selectedItemIndex,
                onNavigate = { selectedItemIndex = it},
                navController = navController
            )
        }
    }
    
}