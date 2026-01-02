package com.example.bajuku.ui.screen.MianScreen.HomeScreen.CatagoryScreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.example.bajuku.R
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Components.BestSaler
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Components.ItemCard
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Components.SaleCard
import com.example.bajuku.ui.theme.HorizontalSpacingM
import com.example.bajuku.ui.theme.screenHorizontal
import com.example.bajuku.ui.theme.verticalSpacingEXL
import com.example.bajuku.ui.theme.verticalSpacingL
import com.example.bajuku.ui.theme.verticalSpacingM

@Composable
fun Shoes(onclick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(horizontal = screenHorizontal)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            androidx.compose.material.Text(
                text = "New Arrival",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary
            )
            androidx.compose.material.Text(
                text = "See All",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        verticalSpacingM()
        Row() {
            Box() {
                ItemCard(Image = painterResource(R.drawable.shoes_1), onclick)
                BestSaler()
            }
            HorizontalSpacingM()
            Box() {
                ItemCard(Image = painterResource(R.drawable.shoes_2), onclick)
                SaleCard()
            }
        }
        verticalSpacingL()
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            androidx.compose.material.Text(
                text = "Recommendation",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary
            )
            androidx.compose.material.Text(
                text = "See All",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        verticalSpacingM()
        Row() {
            ItemCard(Image = painterResource(R.drawable.shoes_3), onclick)
            HorizontalSpacingM()
            ItemCard(Image = painterResource(R.drawable.shoes_4), onclick)
        }
        verticalSpacingL()
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            androidx.compose.material.Text(
                text = "Popular Jacket",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary
            )
            androidx.compose.material.Text(
                text = "See All",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
        verticalSpacingM()
        Row() {
            ItemCard(Image = painterResource(R.drawable.shoes_4), onclick)
            HorizontalSpacingM()
            ItemCard(Image = painterResource(R.drawable.shoes_3), onclick)
        }
        verticalSpacingEXL()
    }
}