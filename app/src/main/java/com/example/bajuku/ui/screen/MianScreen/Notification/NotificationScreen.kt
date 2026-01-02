package com.example.bajuku.ui.screen.MianScreen.Notification

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.bajuku.R
import com.example.bajuku.ui.theme.AppColors
import com.example.bajuku.ui.theme.screenHorizontal
import com.example.bajuku.ui.theme.verticalSpacingEXL
import com.example.bajuku.ui.theme.verticalSpacingM
import com.example.bajuku.ui.theme.verticalSpacingS

@Composable
fun NotificationScreen() {
    Scaffold(
        containerColor = Color(0xFFFAFAFA),
        topBar = { NotificationTopbar() }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(screenHorizontal),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.notification),
                contentDescription = null,
                modifier = Modifier.size(73.dp)
            )
            verticalSpacingM()
            Text(
                text = "No notification yet",
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.onSecondary
            )
            verticalSpacingS()
            Text(
                text = "Your notification will appear here once you’ve\nreceived them.",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onBackground,
                textAlign = TextAlign.Center
            )
            verticalSpacingEXL()
            Text(
                text = "Missing notification?",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
            verticalSpacingS()
            Text(
                text = "Go to historical notification.",
                style = MaterialTheme.typography.labelLarge,
                color = AppColors.Blur20,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun NotificationTopbar() {
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
                text = "Notification",
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
fun NotificationRow() {
    Row() {
        Box() {
            Image(
                painter = painterResource(R.drawable.main_logo),
                contentDescription = null,
                modifier = Modifier.size(73.dp)
            )
        }
        Row() {
            Text(
                text = "Bajuku reward club...",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Jan 12, 2023",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.outline,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}