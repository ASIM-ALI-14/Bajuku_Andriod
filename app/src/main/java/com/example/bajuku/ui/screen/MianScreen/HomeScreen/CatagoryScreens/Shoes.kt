package com.example.bajuku.ui.screen.MianScreen.HomeScreen.ItemsConatant

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Components.CategoryRow
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Components.ProductCard
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Data.DressProducts
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Data.ShoesProducts
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Data.accessoriesProducts
import com.example.bajuku.ui.theme.HorizontalSpacingM
import com.example.bajuku.ui.theme.screenHorizontal
import com.example.bajuku.ui.theme.verticalSpacingEXL
import com.example.bajuku.ui.theme.verticalSpacingL
import com.example.bajuku.ui.theme.verticalSpacingM

@Composable
fun Shoes(onClick: (productId: String) -> Unit) {
    Column(
        modifier = Modifier
            .padding(horizontal = screenHorizontal)
            .verticalScroll(rememberScrollState())
    ) {

        // --- New Arrival (First 2 products) ---
        CategoryRow("New Arrival", ShoesProducts.take(2), onClick)
        verticalSpacingL()

        // --- Recommendation (Next 2 products) ---
        CategoryRow("Recommendation", ShoesProducts.slice(2..3), onClick)
        verticalSpacingL()

        // --- Popular Jacket (Next 2 products) ---
        CategoryRow("Popular Dress", ShoesProducts.slice(4..5), onClick)
        verticalSpacingEXL()
    }
}

