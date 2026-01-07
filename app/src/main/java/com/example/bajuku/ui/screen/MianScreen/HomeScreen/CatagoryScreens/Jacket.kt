package com.example.bajuku.ui.screen.MianScreen.HomeScreen.ItemsConatant

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Components.CategoryRow
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Data.JacketProducts
import com.example.bajuku.ui.theme.screenHorizontal
import com.example.bajuku.ui.theme.verticalSpacingEXL
import com.example.bajuku.ui.theme.verticalSpacingL

@Composable
fun Jacket(
    wishlist: List<com.example.bajuku.ui.screen.MianScreen.HomeScreen.Model.Product>,
    onToggleWishlist: (com.example.bajuku.ui.screen.MianScreen.HomeScreen.Model.Product) -> Unit,
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
            products = JacketProducts.take(2),
            wishlist = wishlist,
            onToggleWishlist = onToggleWishlist,
            onProductClick = onProductClick
        )
        verticalSpacingL()

        // --- Recommendation ---
        CategoryRow(
            title = "Recommendation",
            products = JacketProducts.slice(2..3),
            wishlist = wishlist,
            onToggleWishlist = onToggleWishlist,
            onProductClick = onProductClick
        )
        verticalSpacingL()

        // --- Popular Jacket ---
        CategoryRow(
            title = "Popular Jacket",
            products = JacketProducts.slice(4..5),
            wishlist = wishlist,
            onToggleWishlist = onToggleWishlist,
            onProductClick = onProductClick
        )
        verticalSpacingEXL()
    }
}


