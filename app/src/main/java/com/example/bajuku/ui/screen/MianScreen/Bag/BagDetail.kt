package com.example.bajuku.ui.screen.MianScreen.Bag

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Remove
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
import androidx.compose.ui.unit.sp
import com.example.bajuku.R
import com.example.bajuku.ui.theme.AppColors
import com.example.bajuku.ui.theme.HorizontalSpacingES
import com.example.bajuku.ui.theme.screenHorizontal
import com.example.bajuku.ui.theme.verticalSpacingM
import com.example.bajuku.ui.theme.verticalSpacingS
import com.example.bajuku.ui.theme.verticalSpacingXS

@Composable
fun BagDetail() {
    Scaffold(
        containerColor = Color(0xFFFAFAFA),
        topBar = { BagTopBar() },
        bottomBar = { BagBottomBar() }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(screenHorizontal)
        ) {
            Text(
                text = "You are IDR 700.000 (excluding tax) away from free standard shipping.",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.surfaceVariant,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 22.sp
            )
            verticalSpacingM()
            Text(
                text = "See what’s recommended for you",
                style = MaterialTheme.typography.labelLarge,
                color = AppColors.Blur40,
                fontWeight = FontWeight.SemiBold
            )
            verticalSpacingM()
            Text(
                text = "Today",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.SemiBold
            )
            verticalSpacingM()
            BagItem()
            verticalSpacingM()
            BagItem()
            verticalSpacingM()
            Text(
                text = "Yesterday",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.SemiBold
            )
            verticalSpacingM()
            BagItem()


        }
    }
}

@Composable
fun BagTopBar() {
    Column(modifier = Modifier.background(Color.White)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {}) {
                Icon(
                    Icons.Outlined.ArrowBack,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
            Text(
                text = "Bag  detail",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.SemiBold
            )
            IconButton(onClick = {}) {
                Icon(
                    Icons.Outlined.Menu,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        }
        verticalSpacingM()
        HorizontalDivider(thickness = 1.5.dp, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }

}

@Composable
fun BagBottomBar() {
    Column(modifier = Modifier.background(Color.White)) {
        HorizontalDivider(thickness = 1.5.dp, color = MaterialTheme.colorScheme.onSurfaceVariant)
        verticalSpacingS()
//        SelectedButton(
//            "Select",
//            {},
//            modifier = Modifier
//                .padding(screenHorizontal)
//                .fillMaxWidth(),
//            selected = true
//
//        )
        verticalSpacingS()
    }

}

@Composable
fun BagItem() {
    var addItem by remember { mutableStateOf(1) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent, RoundedCornerShape(10.dp))
            .border(
                2.dp,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                RoundedCornerShape(15.dp)
            )
            .padding(8.dp),
    ) {
        Image(
            painter = painterResource(R.drawable.jacket_2),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(110.dp)
                .clip(
                    RoundedCornerShape(
                        15.dp
                    )
                )
        )
        HorizontalSpacingES()
        Column(modifier = Modifier.padding(top = 1.dp)) {
            Text(
                text = "Seamless Down Parka",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.SemiBold,
            )
            verticalSpacingXS()
            Text(
                text = "Jacket",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Normal,
            )
            Text(
                text = "Size : L",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Normal,
                lineHeight = 18.sp
            )
            Text(
                text = "Color : Cream",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Normal,
            )
            Spacer(modifier = Modifier.height(7.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "IDR 300.000",
                    style = MaterialTheme.typography.labelLarge.copy(
                        textDecoration = TextDecoration.LineThrough // adds a line through the text
                    ),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = AppColors.Error300
                )
                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = "IDR 240.000",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.labelLarge,
                    fontSize = 11.sp,
                    color = MaterialTheme.colorScheme.onSecondary,
                )
                Spacer(modifier = Modifier.weight(1f))
                Box(
                    modifier = Modifier
                        .size(22.dp)
                        .padding(1.dp)
                        .background(Color.Transparent, CircleShape)
                        .border(
                            1.dp,
                            color = MaterialTheme.colorScheme.tertiary,
                            CircleShape,
                        )
                        .clickable(onClick = { addItem-- }),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Outlined.Remove, contentDescription = null)
                }
                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = addItem.toString(),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.width(4.dp))
                Box(
                    modifier = Modifier
                        .size(22.dp)
                        .padding(1.dp)
                        .background(MaterialTheme.colorScheme.primary, CircleShape)
                        .border(
                            1.dp,
                            color = MaterialTheme.colorScheme.primary,
                            CircleShape,
                        )
                        .clickable(onClick = { addItem++ }),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        Icons.Outlined.Add,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.background
                    )
                }

            }

        }
    }
}