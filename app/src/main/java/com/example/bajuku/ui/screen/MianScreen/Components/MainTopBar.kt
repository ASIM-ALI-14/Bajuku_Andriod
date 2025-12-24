package com.example.bajuku.ui.screen.MianScreen.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.NotificationsNone
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.bajuku.ui.components.AppTextFieldBasic
import com.example.bajuku.ui.components.SearchField
import com.example.bajuku.ui.theme.HorizontalSpacingM
import com.example.bajuku.ui.theme.HorizontalSpacingS
import com.example.bajuku.ui.theme.screenHorizontal

@Composable
fun HomeTopBar(value: String, onSearch: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(screenHorizontal)
            .systemBarsPadding()
    ) {
        SearchField(
            value = value,
            onValueChange = {},
            keyboardType = KeyboardType.Text,
            placeholder = "Search or tab",
            leadingIcon = Icons.Filled.Search,
            modifier = Modifier.weight(1f),
            Background = Color.Transparent,
            border = MaterialTheme.colorScheme.outline.copy(alpha = 0.7f),
            onTrailingIconClick = {
                onSearch()
            }
        )
        HorizontalSpacingM()
        CompactIconButton(
            onClick = {},
            icon = Icons.Outlined.NotificationsNone
        )
        HorizontalSpacingS()
        CompactIconButton(
            onClick = {},
            icon = Icons.Outlined.ShoppingBag
        )
    }
}

@Composable
fun CompactIconButton(
    onClick: () -> Unit,
    icon: ImageVector
) {
    Box(
        modifier = Modifier
            .size(37.dp)
            .clip(CircleShape)
            .clickable {
                onClick()
            }
            .border(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.5f), CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Icon(icon, contentDescription = null, modifier = Modifier.size(20.dp))
    }
}
