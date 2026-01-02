package com.example.bajuku.ui.screen.MianScreen.HomeScreen


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.bajuku.R
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.CatagoryScreens.Accessories
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.CatagoryScreens.Dress
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.CatagoryScreens.Jacket
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.CatagoryScreens.Pants
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.CatagoryScreens.Shoes

data class HomeTab(
    val title: String,
    val content: @Composable (() -> Unit)
)

fun getHomeTabs(navController: NavHostController): List<HomeTab> {
    return listOf(
        HomeTab("Jacket") { Jacket { navController.navigate("ItemDetail") } },
        HomeTab("Pants") { Pants { navController.navigate("ItemDetail") } },
        HomeTab("Shoes") { Shoes { navController.navigate("ItemDetail") } },
        HomeTab("Dress") { Dress { navController.navigate("ItemDetail") } },
        HomeTab("Accessories") { Accessories { navController.navigate("ItemDetail") } },


        )
}

data class BannerUiModel(
    val imageRes: Int,
    val title: String,
    val subtitle: String,
    val ctaText: String
)

val bannerList = listOf(
    BannerUiModel(
        imageRes = R.drawable.banner_1,
        title = "New Season Essential",
        subtitle = "Discount up to 50%",
        ctaText = "Get it Now"
    ),
    BannerUiModel(
        imageRes = R.drawable.banner_2,
        title = "Winter Collection",
        subtitle = "Flat 30% Off",
        ctaText = "Shop Now"
    ),
    BannerUiModel(
        imageRes = R.drawable.banner_3,
        title = "Trending Styles",
        subtitle = "Limited Time Offer",
        ctaText = "Explore"
    ),
    BannerUiModel(
        imageRes = R.drawable.banner_4,
        title = "Exclusive Deals",
        subtitle = "Members Only",
        ctaText = "Join Now"
    ),
    BannerUiModel(
        imageRes = R.drawable.banner_5,
        title = "New Arrivals",
        subtitle = "Fresh Collection",
        ctaText = "View All"
    )
)

