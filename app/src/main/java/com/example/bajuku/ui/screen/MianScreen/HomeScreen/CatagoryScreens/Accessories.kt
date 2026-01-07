package com.example.bajuku.ui.screen.MianScreen.HomeScreen.ItemsConatant

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Components.CategoryRow
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Data.accessoriesProducts
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Model.Product
import com.example.bajuku.ui.theme.screenHorizontal
import com.example.bajuku.ui.theme.verticalSpacingEXL
import com.example.bajuku.ui.theme.verticalSpacingL

@Composable
fun Accessories(
    wishlist: List<Product>,
    onToggleWishlist: (Product) -> Unit,
    onProductClick: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(horizontal = screenHorizontal)
            .verticalScroll(rememberScrollState())
    ) {

        CategoryRow(
            title = "New Arrival",
            products = accessoriesProducts.take(2),
            wishlist = wishlist,
            onToggleWishlist = onToggleWishlist,
            onProductClick = onProductClick
        )
        verticalSpacingL()

        CategoryRow(
            title = "Recommendation",
            products = accessoriesProducts.slice(2..3),
            wishlist = wishlist,
            onToggleWishlist = onToggleWishlist,
            onProductClick = onProductClick
        )
        verticalSpacingL()

        CategoryRow(
            title = "Popular Accessories",
            products = accessoriesProducts.slice(4..5),
            wishlist = wishlist,
            onToggleWishlist = onToggleWishlist,
            onProductClick = onProductClick
        )
        verticalSpacingEXL()
    }
}


