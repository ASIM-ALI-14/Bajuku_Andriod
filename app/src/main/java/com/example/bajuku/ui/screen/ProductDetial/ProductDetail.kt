package com.example.bajuku.ui.screen.ProductDetial

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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
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
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.window.Dialog
import com.example.bajuku.R
import com.example.bajuku.ui.components.PrimaryButton
import com.example.bajuku.ui.components.SecondaryButton
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Components.ProductCard
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Components.SaleCard
import com.example.bajuku.ui.screen.MianScreen.HomeScreen.Data.ProductRepository
import com.example.bajuku.ui.screen.MianScreen.Search.RelatedRow
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
fun ProductDetail(
    productId: String,
    onBack: () -> Unit,
    onBuy: () -> Unit,
    navegateToBag: () -> Unit
) {
    val product = remember {
        ProductRepository.getProductById(productId)
    }

    val relatedProducts = remember {
        ProductRepository.getRelatedProducts(
            category = product.category,
            excludeId = product.id
        )
    }
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
    var showDialog by remember { mutableStateOf(false) }
    Scaffold(
        topBar = { ItemTopBar(onBack) },
        bottomBar = { ItemBottomBar({ showDialog = true }, { onBuy() }) }) { innerPadding ->
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
                    painter = painterResource(product.image),
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
                        text = product.name,
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                    SaleCard()
                }
                verticalSpacingS()
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = product.originalPrice,
                        style = MaterialTheme.typography.labelLarge.copy(
                            textDecoration = TextDecoration.LineThrough // adds a line through the text
                        ),
                        fontWeight = FontWeight.SemiBold,
                        color = AppColors.Error300
                    )
                    HorizontalSpacingS()
                    Text(
                        text = product.discountedPrice,
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
                    text = product.description,
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
                        text = product.itemDetails.category,

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
                        text = product.itemDetails.color,
                        style = MaterialTheme.typography.labelLarge,
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
                        text = product.itemDetails.madeIn,
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
                        text = product.itemDetails.material,
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
                                text = product.rating.toString(),
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
                            text = "${product.reviewsCount} reviews",
                            style = MaterialTheme.typography.labelLarge,
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
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    relatedProducts.forEach { related ->
                        ProductCard(product = related) {
                            // navigate again to detail
                        }
                    }
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
//                    RelatedRow( )
                }
                verticalSpacingS()
                Row() {
                    RelatedRow()
                    HorizontalSpacingM()
//                    RelatedRow()
                }
                verticalSpacingEXL()

            }
        }
        if (showDialog) {
            Dialog(
                onDismissRequest = { showDialog = false }
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(130.dp),
                    shape = RoundedCornerShape(26.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.background
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "The product has been successfully added to your bag",
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.headlineSmall,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(horizontal = screenHorizontal)
                        )
                        verticalSpacingS()
                        HorizontalDivider(
                            thickness = 1.7.dp,
                            color = MaterialTheme.colorScheme.primaryContainer
                        )
                        TextButton(
                            onClick = {
                                showDialog = false
                                navegateToBag()

                            }
                        ) {
                            Text(
                                "Check now",
                                style = MaterialTheme.typography.headlineSmall,
                                color = AppColors.Blur20,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            }
        }

    }
}


@Composable
fun ItemTopBar(onBack: () -> Unit) {
    var onclick by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .systemBarsPadding()
            .padding(horizontal = screenHorizontal)
    ) {
        IconButton(onClick = { onBack() }) {
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
fun ItemBottomBar(onClick: () -> Unit, Buynow: () -> Unit) {
    Column(modifier = Modifier.systemBarsPadding()) {
        HorizontalDivider(
            thickness = 1.7.dp,
            color = MaterialTheme.colorScheme.primaryContainer
        )
        verticalSpacingM()
        Row(modifier = Modifier.padding(horizontal = screenHorizontal)) {
            SecondaryButton(
                "Add to bag",
                onSelected = false,
                onClick = { onClick() },
                modifier = Modifier.weight(1f)
            )
            HorizontalSpacingM()
            PrimaryButton(
                "Buy now",
                isSelected = true,
                onClick = { Buynow() },
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


