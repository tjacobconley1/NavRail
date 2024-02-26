package com.example.navrail.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navrail.navigation.NavigationItem
import com.example.navrail.navigation.NavigationSideBar
import com.example.navrail.ui.theme.NavRailTheme

@Composable
fun SettingsScreen(
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


    NavRailTheme {

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            Scaffold(
                bottomBar = {

                },
                modifier = Modifier.fillMaxSize()
            ) {

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it)
                        .padding(
                            if (showNavigationRail) 80.dp else 0.dp
                        )
                ){
                    items(4){
                        Row() {

                            if(it == 0){
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Default.Settings,
                                        contentDescription = "Menu")
                                }
                                Text(
                                    text = "General Settings",
                                    modifier = Modifier.padding(16.dp)
                                )
                            }

                            if(it == 1){
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Default.AccountCircle,
                                        contentDescription = "Menu")
                                }
                                Text(
                                    text = "Accounts",
                                    modifier = Modifier.padding(16.dp)
                                )
                            }

                            if(it == 2){
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Default.List,
                                        contentDescription = "Menu")
                                }
                                Text(
                                    text = "Language Preferences",
                                    modifier = Modifier.padding(16.dp)
                                )
                            }

                            if(it == 3){
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(
                                        imageVector = Icons.Default.Info,
                                        contentDescription = "Menu")
                                }
                                Text(
                                    text = "App Info",
                                    modifier = Modifier.padding(16.dp)
                                )
                            }

                        }
                    }

                }
            }
        }
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