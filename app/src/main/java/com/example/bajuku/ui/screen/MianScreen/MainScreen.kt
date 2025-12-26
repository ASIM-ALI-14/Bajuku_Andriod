package com.example.bajuku.ui.screen.MianScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.bajuku.ui.screen.MianScreen.CategoryScreen.CategoryScreen
import com.example.bajuku.ui.screen.MianScreen.Components.BottomNavBar
import com.example.bajuku.ui.screen.MianScreen.Components.HomeTopBar
import com.example.bajuku.ui.screen.MianScreen.Components.ItemDetail
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.BagDetail
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.HomeContant
import com.example.bajuku.ui.screen.MianScreen.ProfileScreen.ProfileScreen
import com.example.bajuku.ui.screen.MianScreen.WishListScreen.WishlistScreen

@Composable
fun MainScreen(navController: NavHostController) {

    val currentRoute =
        navController.currentBackStackEntryAsState().value?.destination?.route
    var searchQuery by remember { mutableStateOf("") }
    var isSearchMode by remember { mutableStateOf(false) }


    Scaffold(
        topBar = {
            if (currentRoute != "BagScreen" && currentRoute != "ItemDetail") {
                HomeTopBar(
                    searchQuery = searchQuery, onValueChange = {
                        searchQuery = it
                    },
                    isSearchMode = { isSearchMode = !isSearchMode },
                    onBag = { navController.navigate("BagScreen") }


                )
            }
        },
        bottomBar = {
            if (currentRoute != "BagScreen" && currentRoute != "ItemDetail") {
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
        }
    ) { innerPadding ->
        // Ignore both top and bottom padding
        NavHost(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = innerPadding.calculateTopPadding(),
                    bottom = innerPadding.calculateBottomPadding()
                ), // DO NOT use .padding(innerPadding)
            navController = navController,
            startDestination = "home"
        ) {
            composable("home") { HomeContant(isSearchMode, searchQuery, navController) }
            composable("wishlist") { WishlistScreen() }
            composable("category") { CategoryScreen() }
            composable("profile") { ProfileScreen() }
            composable("ItemDetail") { ItemDetail(onClick = { navController.navigate("BagScreen") }) }
            composable("BagScreen") { BagDetail() }
        }
    }
}


