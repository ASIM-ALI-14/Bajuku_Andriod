package com.example.bajuku.ui.screen.MianScreen

import WishlistScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.GridView
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.NotificationsNone
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.bajuku.R
import com.example.bajuku.navigation.Routes
import com.example.bajuku.ui.screen.MianScreen.CategoryScreen.CategoryScreen
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.HomeScreen
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Model.Product
import com.example.bajuku.ui.screen.MianScreen.ProfileScreen.ProfileScreen
import com.example.bajuku.ui.theme.HorizontalSpacingES
import com.example.bajuku.ui.theme.HorizontalSpacingS
import com.example.bajuku.ui.theme.screenHorizontal
import com.example.bajuku.ui.theme.verticalSpacingS
import com.example.bajuku.ui.theme.verticalSpacingXS

// ----------------------- Main Screen -----------------------
@Composable
fun MainScreen_(rootNavController: NavHostController) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val currentRoute = currentDestination?.route
    var wishlist by remember { mutableStateOf<List<Product>>(emptyList()) }


    Scaffold(
        topBar = {
            if (currentRoute != BottomNavScreen.Profile.route) {
                TopBar(
                    onSearchClick = { rootNavController.navigate(Routes.SEARCH) },
                    onBag = { rootNavController.navigate(Routes.BAG) },
                    onNotification = { rootNavController.navigate(Routes.NOTIFICATION) })
            }
        },
        bottomBar = {
            if (currentRoute != BottomNavScreen.Profile.route) {
                BottomNavBar(
                    currentDestination = currentDestination,
                    onNavigate = { route ->
                        navController.navigate(route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavScreen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(BottomNavScreen.Home.route) {
                HomeScreen(
                    navHostController = rootNavController,
                    wishlist = wishlist,
                    onToggleWishlist = { product ->
                        wishlist =
                            if (wishlist.contains(product)) {
                                wishlist - product
                            } else {
                                wishlist + product
                            }
                    }
                )
            }
            composable(BottomNavScreen.Wishlist.route) {
                WishlistScreen(
                    wishlist = wishlist,
                    onRemove = { product ->
                        wishlist = wishlist - product
                    }
                )
            }
            composable(BottomNavScreen.Category.route) { CategoryScreen() }
            composable(BottomNavScreen.Profile.route) { ProfileScreen() }
        }
    }
}

// ----------------------- Top Bar -----------------------
@Composable
fun TopBar(
    onSearchClick: () -> Unit,
    onBag: () -> Unit = {},
    onNotification: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = screenHorizontal)
            .systemBarsPadding(),
        verticalAlignment = Alignment.Bottom
    ) {
        Image(
            painter = painterResource(R.drawable.main_logo),
            contentDescription = null,
            modifier = Modifier.size(28.dp)
        )
        HorizontalSpacingES()
        Text(
            "BrandName",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.weight(1f))

        CompactIconButton(onClick = onNotification, icon = Icons.Outlined.NotificationsNone)
        HorizontalSpacingS()
        CompactIconButton(onClick = onBag, icon = Icons.Outlined.ShoppingBag)
        HorizontalSpacingS()
        CompactIconButton(onClick = onSearchClick, icon = Icons.Outlined.Search)
    }
}

// ----------------------- Compact Icon Button -----------------------
@Composable
fun CompactIconButton(onClick: () -> Unit, icon: ImageVector) {
    Box(
        modifier = Modifier
            .size(37.dp)
            .clip(CircleShape)
            .clickable { onClick() }
            .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.5f), CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Icon(icon, contentDescription = null, modifier = Modifier.size(20.dp))
    }
}

// ----------------------- Bottom Navigation -----------------------
sealed class BottomNavScreen(
    val route: String,
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {
    object Home : BottomNavScreen("home", "Home", Icons.Default.Home, Icons.Outlined.Home)
    object Wishlist : BottomNavScreen(
        "wishlist",
        "Wishlist",
        Icons.Filled.Favorite,
        Icons.Outlined.FavoriteBorder
    )

    object Category :
        BottomNavScreen("category", "Category", Icons.Filled.GridView, Icons.Outlined.GridView)

    object Profile :
        BottomNavScreen("profile", "Profile", Icons.Filled.Person, Icons.Outlined.Person)
}

val bottomNavItems = listOf(
    BottomNavScreen.Home,
    BottomNavScreen.Wishlist,
    BottomNavScreen.Category,
    BottomNavScreen.Profile
)

@Composable
fun BottomNavBar(
    currentDestination: NavDestination?,
    onNavigate: (String) -> Unit
) {
    Column {
        Divider(thickness = 0.3.dp, color = MaterialTheme.colorScheme.primary)
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .navigationBarsPadding()
                .height(60.dp),
            tonalElevation = 0.dp
        ) {
            bottomNavItems.forEach { item ->
                val selected = currentDestination?.hierarchy?.any { it.route == item.route } == true
                NavigationBarItem(
                    selected = selected,
                    onClick = { onNavigate(item.route) },
                    icon = {
                        Icon(
                            imageVector = if (selected) item.selectedIcon else item.unselectedIcon,
                            contentDescription = item.label
                        )
                    },
                    label = { Text(item.label) },
                    alwaysShowLabel = true,
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent,
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                        unselectedIconColor = MaterialTheme.colorScheme.tertiary,
                        selectedTextColor = MaterialTheme.colorScheme.primary,
                        unselectedTextColor = MaterialTheme.colorScheme.tertiary
                    )
                )
            }
        }
    }
}
