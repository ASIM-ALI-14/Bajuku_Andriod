package com.example.bajuku.ui.screen.MianScreen.HomeScreen.ItemsConatant

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Components.CategoryRow
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Data.DressProducts
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Model.Product
import com.example.bajuku.ui.theme.screenHorizontal
import com.example.bajuku.ui.theme.verticalSpacingEXL
import com.example.bajuku.ui.theme.verticalSpacingL

@Composable
fun Dress(
    wishlist: List<Product>,
    onToggleWishlist: (Product) -> Unit,
    onProductClick: (productId: String) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(horizontal = screenHorizontal)
            .verticalScroll(rememberScrollState())
    ) {

        // --- New Arrival ---
        CategoryRow(
            title = "New Arrival",
            products = DressProducts.take(2),
            wishlist = wishlist,
            onToggleWishlist = onToggleWishlist,
            onProductClick = onProductClick
        )

        verticalSpacingL()

        // --- Recommendation ---
        CategoryRow(
            title = "Recommendation",
            products = DressProducts.slice(2..3),
            wishlist = wishlist,
            onToggleWishlist = onToggleWishlist,
            onProductClick = onProductClick
        )

        verticalSpacingL()

        // --- Popular Dress ---
        CategoryRow(
            title = "Popular Dress",
            products = DressProducts.slice(4..5),
            wishlist = wishlist,
            onToggleWishlist = onToggleWishlist,
            onProductClick = onProductClick
        )

        verticalSpacingEXL()
    }
}


