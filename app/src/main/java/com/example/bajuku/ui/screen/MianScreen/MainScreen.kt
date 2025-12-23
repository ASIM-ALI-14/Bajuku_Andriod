package com.example.bajuku.ui.screen.MianScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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

    Scaffold(
        topBar = { HomeTopBar("") },
        bottomBar = {
            BottomNavBar(
                navController = navController,
                currentRoute = currentRoute
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") { HomeContant() }
            composable("wishlist") { WishlistScreen() }
            composable("category") { CategoryScreen() }
            composable("profile") { ProfileScreen() }
        }
    }
}
