package com.example.bajuku.ui.screen.MianScreen.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bajuku.R
import com.example.bajuku.ui.components.NotSelectedButton
import com.example.bajuku.ui.components.SelectedButton
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Components.ItemCard
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.ItemsConatant.SaleCard
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.RelatedRow
import com.example.bajuku.ui.theme.AppColors
import com.example.bajuku.ui.theme.HorizontalSpacingES
import com.example.bajuku.ui.theme.HorizontalSpacingM
import com.example.bajuku.ui.theme.HorizontalSpacingS
import com.example.bajuku.ui.theme.screenHorizontal
import com.example.bajuku.ui.theme.verticalSpacingEXL
import com.example.bajuku.ui.theme.verticalSpacingL
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
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
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
                    HorizontalSpacingS()
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
                    HorizontalSpacingS()
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

                verticalSpacingM()
                Text(
                    text = "Description",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary
                )
                verticalSpacingS()
                Text(
                    text = "The Seamless Down Parka is a stylish and functional outerwear piece designed to provide optimal warmth and comfort in cold weather., this parka features a seamless construction, eliminating the need for stitching and creating a sleek and modern appearance.",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.tertiary,
                    fontWeight = FontWeight.Medium
                )
                verticalSpacingL()
                Text(
                    text = "Item detail",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary
                )
                verticalSpacingS()
                Row() {
                    Text(
                        text = "Category", style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Jacket & Hoodies",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                verticalSpacingS()
                HorizontalDivider(
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.primaryContainer
                )
                verticalSpacingS()
                Row() {
                    Text(
                        text = "Color", style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Only one color (Cream)",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                verticalSpacingS()
                HorizontalDivider(
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.primaryContainer
                )
                verticalSpacingS()
                Row() {
                    Text(
                        text = "Made", style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Australia",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                verticalSpacingS()
                HorizontalDivider(
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.primaryContainer
                )
                verticalSpacingS()
                Row() {
                    Text(
                        text = "Material", style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Fleece base material",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                verticalSpacingS()
                HorizontalDivider(
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.primaryContainer
                )
                verticalSpacingM()
                Text(
                    text = "Item Rate",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                verticalSpacingM()
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min)
                ) {
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.Bottom) {
                            Text(
                                text = "4.7",
                                style = MaterialTheme.typography.displayMedium,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold
                            )
                            HorizontalSpacingES()
                            Icon(
                                Icons.Filled.Star,
                                contentDescription = null,
                                tint = AppColors.Star50
                            )
                        }
                        Text(
                            text = "154 reviews", style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Item quality", style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.SemiBold
                        )
                        verticalSpacingS()
                        Text(
                            text = "Shipping", style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.SemiBold
                        )
                        verticalSpacingS()
                        Text(
                            text = "Customer service", style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(vertical = 4.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        repeat(3) {
                            Box(
                                modifier = Modifier
                                    .size(65.dp, 4.dp)
                                    .background(
                                        MaterialTheme.colorScheme.onBackground,
                                        RoundedCornerShape(50)
                                    )
                            )
                        }
                    }
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "4.9", style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.SemiBold
                        )

                        Text(
                            text = "4.9", style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.SemiBold
                        )

                        Text(
                            text = "4.9", style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
                verticalSpacingL()
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Item review",
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "See all",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.tertiary,
                        fontWeight = FontWeight.Medium
                    )
                }
                verticalSpacingS()
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(painter = painterResource(R.drawable.subtract), contentDescription = null)
                    HorizontalSpacingS()
                    Text(
                        text = "All reviews are from verified buyers",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                verticalSpacingM()
                CommentBox()
                verticalSpacingS()
                CommentBox()
                verticalSpacingM()
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "More item similar",
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "See all",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.tertiary,
                        fontWeight = FontWeight.Medium
                    )
                }
                verticalSpacingM()
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ItemCard(
                        Image = painterResource(R.drawable.jacket_1),
                        onClick = {},
                    )
                    ItemCard(
                        Image = painterResource(R.drawable.jacket_2),
                        onClick = {},
                    )
                }
                verticalSpacingM()
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Related Search",
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "See all",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.tertiary,
                        fontWeight = FontWeight.Medium
                    )
                }
                verticalSpacingM()
                Row() {
                    RelatedRow()
                    HorizontalSpacingS()
                    RelatedRow()
                }
                verticalSpacingS()
                Row() {
                    RelatedRow()
                    HorizontalSpacingM()
                    RelatedRow()
                }
                verticalSpacingEXL()

            }
        }
    }
}

@Composable
fun ItemTopBar() {
    var onclick by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = screenHorizontal)
    ) {
        IconButton(onClick = { }) {
            Icon(Icons.Outlined.ArrowBack, contentDescription = null)
        }
        Text(
            text = "Product detail",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )
        IconButton(onClick = { onclick = !onclick }) {
            Icon(
                imageVector = if (onclick)
                    Icons.Filled.Favorite
                else
                    Icons.Outlined.FavoriteBorder,
                contentDescription = null,
                tint = if (onclick)
                    MaterialTheme.colorScheme.primary
                else
                    MaterialTheme.colorScheme.tertiary
            )
        }
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
        Row(modifier = Modifier.padding(horizontal = screenHorizontal)) {
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

            .padding(8.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 14.sp,
            color = if (isSelected) MaterialTheme.colorScheme.background else MaterialTheme.colorScheme.tertiary
        )
    }
}

@Composable
fun CommentBox() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .border(
                1.dp,
                color = MaterialTheme.colorScheme.primaryContainer,
                RoundedCornerShape(18.dp)
            )
            .padding(15.dp)

    ) {
        Column() {
            Row(verticalAlignment = Alignment.Bottom, modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(R.drawable.comment_1),
                    contentDescription = null,
                    modifier = Modifier
                        .size(47.dp)
                        .clip(CircleShape),
                )
                HorizontalSpacingS()
                Column() {
                    Text(
                        text = "Nurul Arianit",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontWeight = FontWeight.SemiBold
                    )
                    verticalSpacingXS()
                    Text(
                        text = "7 February 2023",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        fontWeight = FontWeight.Normal
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        Icons.Filled.Star,
                        contentDescription = null,
                        modifier = Modifier.size(13.dp),
                        tint = AppColors.Star50
                    )
                    HorizontalSpacingES()
                    Icon(
                        Icons.Filled.Star,
                        contentDescription = null,
                        modifier = Modifier.size(13.dp),
                        tint = AppColors.Star50
                    )
                    HorizontalSpacingES()
                    Icon(
                        Icons.Filled.Star,
                        contentDescription = null,
                        modifier = Modifier.size(13.dp),
                        tint = AppColors.Star50
                    )
                    HorizontalSpacingES()
                    Icon(
                        Icons.Filled.Star,
                        contentDescription = null,
                        modifier = Modifier.size(13.dp),
                        tint = AppColors.Star50
                    )
                    HorizontalSpacingES()
                    Icon(
                        Icons.Filled.Star,
                        contentDescription = null,
                        modifier = Modifier.size(13.dp),
                        tint = AppColors.Star50
                    )
                    HorizontalSpacingES()
                    Icon(
                        Icons.Filled.Star,
                        contentDescription = null,
                        modifier = Modifier.size(13.dp),
                        tint = AppColors.Star50
                    )
                    HorizontalSpacingS()
                    Text(
                        text = "4.9",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            verticalSpacingM()
            Text(
                text = "“ I recently bought a jacket online and I must say, I am extremely satisfied with my purchase. The quality of the jacket exceeded my expectations, and it fits perfectly.”",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        }
    }


}

