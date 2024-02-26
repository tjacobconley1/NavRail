@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3WindowSizeClassApi::class)

package com.example.navrail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.navrail.navigation.Navigation

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        var viewModel = MainActivityViewModel()


        setContent {



            Navigation()

        }
    }
}






//@Preview
//@Composable
//fun Preview() {
//
//        val railItems = listOf(
//            NavigationItem(
//                title = "Home",
//                selectedIcon = Icons.Filled.Home,
//                unselectedIcon = Icons.Outlined.Home,
//                hasNews = false
//            ),
//            NavigationItem(
//                title = "Home",
//                selectedIcon = Icons.Filled.Email,
//                unselectedIcon = Icons.Outlined.Email,
//                hasNews = false,
//                badgeCount = 45
//            ),
//            NavigationItem(
//                title = "Home",
//                selectedIcon = Icons.Filled.Settings,
//                unselectedIcon = Icons.Outlined.Settings,
//                hasNews = true
//            )
//
//        )
//
//        NavRailTheme {
//
//            val showNavigationRail = true
//            var selectedItemIndex by rememberSaveable {
//                mutableIntStateOf(0)
//            }
//
//            Surface(
//                modifier = Modifier.fillMaxSize(),
//                color = MaterialTheme.colorScheme.background
//            ) {
//
//                Scaffold(
//                    bottomBar = {  },
//                    modifier = Modifier.fillMaxSize()
//                ) {
//
//                    LazyColumn(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(it)
//                            .padding(
//                                if (showNavigationRail) 80.dp else 0.dp
//                            )
//                    ) {
//                        items(100) {
//                            Text(
//                                text = "Item ${it}",
//                                modifier = Modifier.padding(16.dp)
//                            )
//                        }
//                    }
//
//                }
//            }
//
//            // OUTSIDE OF SURFACE
//            // OUTSIDE OF SCAFFOLD
//            if (showNavigationRail) {
//                NavigationSideBar(
//                    items = railItems,
//                    selectedItemIndex = selectedItemIndex,
//                    onNavigate = { selectedItemIndex = it }
//                )
//            }
//        }
//}

