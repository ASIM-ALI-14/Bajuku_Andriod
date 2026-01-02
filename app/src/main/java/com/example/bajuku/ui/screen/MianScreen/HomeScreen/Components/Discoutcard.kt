package com.example.bajuku.ui.screen.MianScreen.HomeScreen.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.bajuku.ui.theme.AppColors

@Composable
fun BestSaler() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(top = 8.dp, start = 8.dp)
            .size(90.dp, 32.dp)
            .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(15.dp))
    ) {
        Text(
            text = "Best Seller",
            style = MaterialTheme.typography.labelLarge,
            color = AppColors.Primary0,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun SaleCard() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(top = 8.dp, start = 8.dp)
            .size(63.dp, 30.dp)
            .background(AppColors.Error300, RoundedCornerShape(15.dp))
    ) {
        Text(
            text = "-$40%",
            style = MaterialTheme.typography.labelLarge,
            color = AppColors.Primary0,
            fontWeight = FontWeight.SemiBold
        )
    }


}