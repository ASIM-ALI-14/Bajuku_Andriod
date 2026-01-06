package com.example.bajuku.ui.screen.MianScreen.HomeScreen.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.bajuku.ui.theme.HorizontalSpacingM
import com.example.bajuku.ui.theme.verticalSpacingM

@Composable
fun CategoryRow(
    title: String,
    products: List<com.example.bajuku.ui.screen.MianScreen.HomeScreen.Model.Product>,
    onClick: (productId: String) -> Unit
) {
    // Title
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "See All",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
    verticalSpacingM()

    // Product Cards Row
    Row {
        products.forEachIndexed { index, product ->
            ProductCard(product = product) {
                onClick(product.id)
            }
            if (index != products.lastIndex) HorizontalSpacingM()
        }
    }
}
