@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.navrail.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun NavigationSideBar(
    items: List<NavigationItem>,
    selectedItemIndex: Int,
    onNavigate: (Int) -> Unit,
    navController: NavController
){

    // NAVIGATION RAIL
    NavigationRail(
        header = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu")
            }
            FloatingActionButton(
                onClick = { /*TODO*/ },
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add")
            }
        },
        modifier = Modifier
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .offset(x = ((-1).dp))
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.Bottom)
        ) {

            items.forEachIndexed { index, item ->
                NavigationRailItem(
                    selected = selectedItemIndex == index,
                    onClick = {
                        onNavigate(index)
                        if(item.title == "Settings"){
                        navController.navigate(Screen.SettingsScreen.route)
                        }
                        if(item.title == "Home"){
                            navController.navigate(Screen.HomeScreen.route)
                        }
                        if(item.title == "Email"){
                            navController.navigate(Screen.EmailScreen.route)
                        }
                    },
                    icon = {
                        NavigationIcon(item = item, selected = selectedItemIndex == index)
                    },
                    label = {
                        Text(text = item.title.toString())
                    }
                )
            }
        }
    }
}


@Composable
fun NavigationIcon(
    item: NavigationItem,
    selected: Boolean
){
    BadgedBox(
        badge = {
            if(item.badgeCount != null){
                Badge{
                    Text(text = item.badgeCount.toString())
                }
            }else if(item.hasNews){
                Badge()
            }
        }
    ) {

        Icon(
            imageVector = if(selected) item.selectedIcon else item.unselectedIcon,
            contentDescription = item.title)

    }

}


data class NavigationItem(
    val title: String?,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)
