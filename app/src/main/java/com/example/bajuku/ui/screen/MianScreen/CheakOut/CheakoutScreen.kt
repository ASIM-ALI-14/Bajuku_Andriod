package com.example.bajuku.ui.screen.MianScreen.CheakOut

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.bajuku.ui.screen.MianScreen.Bag.BagItem
import com.example.bajuku.ui.theme.HorizontalSpacingEXL
import com.example.bajuku.ui.theme.screenHorizontal
import com.example.bajuku.ui.theme.verticalSpacingL
import com.example.bajuku.ui.theme.verticalSpacingM
import com.example.bajuku.ui.theme.verticalSpacingS

@Composable
fun CheckOutScreen(onclick: () -> Unit, onsucses: () -> Unit) {
    var address by remember { mutableStateOf("") }
    Scaffold(
        containerColor = Color(0xFFFAFAFA),
        topBar = { CheckOutTopbar() },
        bottomBar = { CheckOutBottomBar(onsucses) }) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = screenHorizontal)
        ) {
            verticalSpacingM()
            Text(
                text = "List Product",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.SemiBold
            )
            verticalSpacingS()
            BagItem()
            verticalSpacingM()
            Text(
                text = "Pickup Location",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.SemiBold
            )
            verticalSpacingS()
            Box(modifier = Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = address,
                    onValueChange = { address = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 56.dp), // minimum height
                    textStyle = MaterialTheme.typography.labelLarge.copy(
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onBackground
                    ),
                    placeholder = {
                        Text(
                            text = "Input your Location",
                            style = MaterialTheme.typography.labelLarge.copy(
                                fontWeight = FontWeight.SemiBold
                            ),
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    shape = RoundedCornerShape(12.dp),
                    trailingIcon = {} // leave empty, we'll overlay manually
                )
                // Overlay icon at top-end
                Icon(
                    imageVector = Icons.Outlined.Edit,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 16.dp, end = 12.dp)
                )
            }

            verticalSpacingM()
            Text(
                text = "Payment",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.SemiBold
            )
            verticalSpacingS()
            Text(
                text = "Select payment method",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.surfaceVariant,
                fontWeight = FontWeight.SemiBold
            )
            verticalSpacingS()
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = onclick)
                    .background(Color.Transparent)
                    .border(1.5.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(10.dp))
                    .padding(horizontal = 20.dp, 14.dp)
            ) {
                Text(
                    text = "Select your payment method",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.SemiBold
                )
            }
            verticalSpacingL()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(10.dp))
                    .padding(horizontal = 17.dp, vertical = 24.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Sub total :",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = "IDR 700.000",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                }
                verticalSpacingS()
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Shipping :",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = "IDR 34.000",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                }
                verticalSpacingS()
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Delivery fee :",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = "IDR 70.000",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                }
                verticalSpacingM()
                HorizontalDivider(
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                verticalSpacingM()
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Total :",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = "IDR 905.000",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
fun CheckOutTopbar() {
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
                text = "Check out",
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
fun CheckOutBottomBar(onclick: () -> Unit) {
    Column(modifier = Modifier.background(Color.White)) {
        HorizontalDivider(thickness = 1.5.dp, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Row(
            modifier = Modifier.padding(horizontal = screenHorizontal, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "IDR 905.000",
                style = MaterialTheme.typography.headlineLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
            HorizontalSpacingEXL()
//            SelectedButton(
//                "Next",
//                { onclick() },
//                modifier = Modifier
//                    .fillMaxWidth(),
//                selected = false
//
//            )

        }
    }
}
