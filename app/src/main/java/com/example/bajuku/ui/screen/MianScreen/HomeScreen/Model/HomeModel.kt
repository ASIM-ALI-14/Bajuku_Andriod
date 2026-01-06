package com.example.bajuku.ui.screen.MianScreen.HomeScreen.Model

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.bajuku.navigation.Routes
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.ItemsConatant.Accessories
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.ItemsConatant.Dress
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.ItemsConatant.Jacket
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.ItemsConatant.Pants
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.ItemsConatant.Shoes

data class BannerUiModel(
    val imageRes: Int,
    val title: String,
    val subtitle: String,
    val ctaText: String
)

data class Product(
    val id: String,
    val name: String,
    val originalPrice: String,
    val discountedPrice: String,
    val image: Int,

    // ✅ ADD THESE
    val category: String,          // Jacket, Dress, Shoes
    val description: String,
    val itemDetails: ItemDetails,
    val rating: Double,
    val reviewsCount: Int
)

data class ItemDetails(
    val category: String,
    val color: String,
    val madeIn: String,
    val material: String
)

data class HomeTab(
    val title: String,
    val content: @Composable () -> Unit
)

fun getHomeTabs(navHostController: NavHostController): List<HomeTab> {
    return listOf(
        HomeTab("Dress") {
            Dress { productId ->
                navHostController.navigate(
                    "${Routes.PRODUCT_DETAIL}/$productId"
                )
            }
        },
        HomeTab("Jacket") {
            Jacket { productId ->
                navHostController.navigate(
                    "${Routes.PRODUCT_DETAIL}/$productId"
                )
            }
        },
        HomeTab("Pants") {
            Pants { productId ->
                navHostController.navigate(
                    "${Routes.PRODUCT_DETAIL}/$productId"
                )
            }
        },
        HomeTab("Shoes") {
            Shoes { productId ->
                navHostController.navigate(
                    "${Routes.PRODUCT_DETAIL}/$productId"
                )
            }
        },
        HomeTab("Accessories") {
            Accessories { productId ->
                navHostController.navigate(
                    "${Routes.PRODUCT_DETAIL}/$productId"
                )
            }
        }
    )
}


