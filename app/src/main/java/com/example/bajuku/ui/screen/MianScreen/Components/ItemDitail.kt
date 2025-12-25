package com.example.bajuku.ui.screen.MianScreen.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.bajuku.R
import com.example.bajuku.ui.components.NotSelectedButton
import com.example.bajuku.ui.components.SelectedButton
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.ItemsConatant.SaleCard
import com.example.bajuku.ui.theme.AppColors
import com.example.bajuku.ui.theme.HorizontalSpacingES
import com.example.bajuku.ui.theme.HorizontalSpacingM
import com.example.bajuku.ui.theme.HorizontalSpacingS
import com.example.bajuku.ui.theme.screenHorizontal
import com.example.bajuku.ui.theme.verticalSpacingM
import com.example.bajuku.ui.theme.verticalSpacingS
import com.example.bajuku.ui.theme.verticalSpacingXS

@Composable
fun ItemDetail() {
    val productImages = listOf(
        R.drawable.jacket_1,
        R.drawable.jacket_2,
        R.drawable.jacket_3,
        R.drawable.jacket_4
    )
    val SizeProduct = listOf(
        "S",
        "M",
        "l",
        "XL",
        "XXL"
    )
    var selectedSize by remember { mutableStateOf(SizeProduct[0]) }
    var selectedImage by remember { mutableStateOf(productImages[0]) }
    Scaffold(topBar = { ItemTopBar() }, bottomBar = { ItemBottomBar() }) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            verticalSpacingXS()
            HorizontalDivider(
                thickness = 2.5.dp,
                color = MaterialTheme.colorScheme.primaryContainer
            )
            Box(contentAlignment = Alignment.BottomCenter) {
                Image(
                    painter = painterResource(selectedImage),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxWidth()
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    productImages.forEach { image ->
                        ImageSmall(
                            imageRes = image,
                            isSelected = image == selectedImage,
                            onClick = { selectedImage = image }
                        )
                    }
                }
            }
            verticalSpacingM()
            Column(modifier = Modifier.padding(horizontal = screenHorizontal)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Seamless Down Parka",
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                    SaleCard()
                }
                verticalSpacingS()
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "IDR 300.000",
                        style = MaterialTheme.typography.labelLarge.copy(
                            textDecoration = TextDecoration.LineThrough // adds a line through the text
                        ),
                        fontWeight = FontWeight.SemiBold,
                        color = AppColors.Error300
                    )
                    HorizontalSpacingES()
                    Text(
                        text = "IDR 240.000",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onSecondary
                    )
                }
                verticalSpacingS()
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Filled.Star, contentDescription = null, tint = AppColors.Star50)
                    HorizontalSpacingES()
                    Icon(Icons.Filled.Star, contentDescription = null, tint = AppColors.Star50)
                    HorizontalSpacingES()
                    Icon(Icons.Filled.Star, contentDescription = null, tint = AppColors.Star50)
                    HorizontalSpacingES()
                    Icon(Icons.Filled.Star, contentDescription = null, tint = AppColors.Star50)
                    HorizontalSpacingES()
                    Icon(Icons.Filled.Star, contentDescription = null, tint = AppColors.Star50)
                    HorizontalSpacingES()
                    Icon(Icons.Filled.Star, contentDescription = null, tint = AppColors.Star50)
                    HorizontalSpacingS()
                    Text(
                        text = "4.9",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    HorizontalSpacingES()
                    Text(
                        text = "(154reviews)",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.onBackground
                    )


                }
                verticalSpacingM()
                Text(
                    text = "Select size",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.SemiBold
                )
                verticalSpacingS()
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    SizeProduct.forEach { text ->
                        SizeBox(
                            text = text,
                            isSelected = text == selectedSize,
                            onClick = { selectedSize = text })
                        HorizontalSpacingS()
                    }
                }
            }
        }
    }
}

@Composable
fun ItemTopBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = screenHorizontal)
    ) {
        IconButton(onClick = {}) {
            Icon(Icons.Outlined.ArrowBack, contentDescription = null)
        }
        Text(
            text = "Product detail",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Icon(Icons.Outlined.FavoriteBorder, contentDescription = null)
    }
}

@Composable
fun ItemBottomBar() {
    Column() {
        HorizontalDivider(
            thickness = 1.7.dp,
            color = MaterialTheme.colorScheme.primaryContainer
        )
        verticalSpacingM()
        Row() {
            NotSelectedButton(
                "Add to bag",
                selected = false,
                onclick = {},
                modifier = Modifier.weight(1f)
            )
            HorizontalSpacingM()
            SelectedButton(
                "Buy now",
                selected = true,
                onclick = {},
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun ImageSmall(
    imageRes: Int,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Image(
        painter = painterResource(imageRes),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .size(75.dp)
            .clip(RoundedCornerShape(5.dp))
            .clickable(onClick = onClick)
            .border(
                width = 2.dp,
                color = if (isSelected)
                    MaterialTheme.colorScheme.primary
                else
                    Color.Transparent,
                shape = RoundedCornerShape(5.dp)
            )
    )
}

@Composable
fun SizeBox(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(end = 8.dp)
            .clip(CircleShape)
            .clickable { onClick() }
            .size(45.dp)
            .background(
                if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent,
                CircleShape
            )
            .border(
                1.4.dp,
                color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primaryContainer,
                CircleShape
            )

            .padding(4.dp)
    ) {
        Text(
            text = text,
            color = if (isSelected) MaterialTheme.colorScheme.background else MaterialTheme.colorScheme.tertiary
        )
    }
}

