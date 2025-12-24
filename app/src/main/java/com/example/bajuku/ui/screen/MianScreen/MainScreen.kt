package com.example.bajuku.ui.screen.MianScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.bajuku.ui.screen.MianScreen.CategoryScreen.CategoryScreen
import com.example.bajuku.ui.screen.MianScreen.Components.BottomNavBar
import com.example.bajuku.ui.screen.MianScreen.Components.HomeTopBar
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.HomeContant
import com.example.bajuku.ui.screen.MianScreen.ProfileScreen.ProfileScreen
import com.example.bajuku.ui.screen.MianScreen.WishListScreen.WishlistScreen

@Composable
fun MainScreen(navController: NavHostController) {
    val currentRoute =
        navController.currentBackStackEntryAsState().value?.destination?.route
    var isSearchActive by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            HomeTopBar(value = "", onSearch = {
                isSearchActive = !isSearchActive
            }
            )
        },
        bottomBar = {
            BottomNavBar(
                currentRoute = currentRoute,
                onNavigate = { route ->
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    ) { innerPadding ->
        // Ignore both top and bottom padding
        NavHost(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = innerPadding.calculateTopPadding()), // DO NOT use .padding(innerPadding)
            navController = navController,
            startDestination = "home"
        ) {
            composable("home") { HomeContant(isSearchActive) }
            composable("wishlist") { WishlistScreen() }
            composable("category") { CategoryScreen() }
            composable("profile") { ProfileScreen() }
        }
    }
}


