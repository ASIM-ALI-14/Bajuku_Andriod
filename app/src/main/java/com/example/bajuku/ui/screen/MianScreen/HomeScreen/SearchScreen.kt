package com.example.bajuku.ui.screen.MianScreen.HomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowOutward
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Restore
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.bajuku.R
import com.example.bajuku.ui.theme.AppColors
import com.example.bajuku.ui.theme.HorizontalSpacingM
import com.example.bajuku.ui.theme.HorizontalSpacingS
import com.example.bajuku.ui.theme.screenHorizontal
import com.example.bajuku.ui.theme.verticalSpacingES
import com.example.bajuku.ui.theme.verticalSpacingL
import com.example.bajuku.ui.theme.verticalSpacingM
import com.example.bajuku.ui.theme.verticalSpacingS

@Composable
fun SearchContant() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFAFAFA))
    ) {
        HorizontalDivider(thickness = 1.4.dp, color = MaterialTheme.colorScheme.primaryContainer)
        verticalSpacingL()
        Column() {
            SearchContantRow(text = "Seamless", num = 12)
            verticalSpacingES()
            HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.primaryContainer)
            verticalSpacingS()
            SearchContantRow(text = "Superstar Shoes", num = 12)
            verticalSpacingES()
            HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.primaryContainer)
            verticalSpacingS()
            SearchContantRow(text = "Seamless", num = 12)
            verticalSpacingES()
            HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.primaryContainer)
            verticalSpacingS()
            SearchContantRow(text = "Superstar Shoes", num = 12)
            verticalSpacingES()
            HorizontalDivider(thickness = 1.dp, color = MaterialTheme.colorScheme.primaryContainer)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Top Product",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "see All",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            verticalSpacingS()
            TopSearchRow()

        }




        Column(modifier = Modifier.padding(horizontal = screenHorizontal)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Recent Search",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Remove All",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            verticalSpacingS()
            Row(verticalAlignment = Alignment.CenterVertically) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable(onClick = {})
                ) {
                    Icon(
                        Icons.Outlined.Restore,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                    HorizontalSpacingS()
                    Text(
                        text = "Superstar Shoes",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.surfaceVariant
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Outlined.Clear,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable(onClick = {})
                ) {
                    Icon(
                        Icons.Outlined.Restore,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                    HorizontalSpacingS()
                    Text(
                        text = "Reusable Tote Bag (Medium)",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.surfaceVariant
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Outlined.Clear,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable(onClick = {})
                ) {
                    Icon(
                        Icons.Outlined.Restore,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.tertiary
                    )
                    HorizontalSpacingS()
                    Text(
                        text = "Adi break Pants",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.surfaceVariant
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Outlined.Clear,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
            verticalSpacingM()
            Text(
                text = "View all search history (10)",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Medium,
                color = AppColors.Blur20
            )
        }
    }


}

@Composable
fun SearchContantRow(text: String, num: Int) {
    Row() {
        Column() {
            Text(
                text = text,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSecondary,
                fontWeight = FontWeight.Medium,
                lineHeight = 12.sp
            )
            Text(
                text = "${num}review",
                fontSize = 10.sp,
                color = MaterialTheme.colorScheme.tertiary,
                fontWeight = FontWeight.Medium,
                lineHeight = 12.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = {}) {
                Icon(
                    Icons.Outlined.ArrowOutward,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )

            }


        }
    }
}

@Composable
fun TopSearchRow() {
    Row() {
        Image(
            painter = painterResource(R.drawable.jacket_2),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(5.dp))
        )
        HorizontalSpacingM()
        Column() {
            Text(
                text = "Seamless Down Parka",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Medium
            )
            verticalSpacingES()
            Text(
                text = "Jacket (334 stock)",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Normal
            )
        }
    }
}