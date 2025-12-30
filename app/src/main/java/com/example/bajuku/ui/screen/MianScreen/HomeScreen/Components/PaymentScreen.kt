package com.example.bajuku.ui.screen.MianScreen.HomeScreen.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.bajuku.ui.theme.HorizontalSpacingS
import com.example.bajuku.ui.theme.screenHorizontal
import com.example.bajuku.ui.theme.verticalSpacingL
import com.example.bajuku.ui.theme.verticalSpacingM
import com.example.bajuku.ui.theme.verticalSpacingS

@Composable
fun PaymentScreen() {
    var selectedPayment by remember { mutableStateOf(0) }

    Scaffold(
        topBar = { PaymentTopbar() },
        bottomBar = { PaymentBottombar() },
        containerColor = Color(0xFFFAFAFA)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(horizontal = screenHorizontal)
        ) {
            verticalSpacingL()
            Text(
                text = "Payment",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.SemiBold
            )
            verticalSpacingS()
            Text(
                text = "Please check your shipping address. Incorrect address may cause order cancellation or delay.",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Medium
            )
            verticalSpacingS()
            PaymentBox(
                image = com.example.bajuku.R.drawable.group,
                Mywallet = true,
                selected = selectedPayment == 0,
                onSelect = { selectedPayment = 0 },
                text = "My Wallet"

            )
            verticalSpacingS()
            PaymentBox(
                image = com.example.bajuku.R.drawable.group__4_,
                Mywallet = false,
                selected = selectedPayment == 1,
                onSelect = { selectedPayment = 1 },
                "PayPal"

            )
            verticalSpacingS()
            PaymentBox(
                image = com.example.bajuku.R.drawable.frame__1_,
                Mywallet = false,
                selected = selectedPayment == 2,
                onSelect = { selectedPayment = 2 },
                "............4679"

            )


        }
    }
}

@Composable
fun PaymentTopbar() {
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
                text = "Payment",
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
fun PaymentBottombar() {
    Column() {
//        SelectedButton(
//            "Select",
//            {},
//            modifier = Modifier
//                .padding(screenHorizontal)
//                .fillMaxWidth(),
//            selected = true
//        )
    }
}

@Composable
fun PaymentBox(
    image: Int,
    Mywallet: Boolean,
    selected: Boolean,
    onSelect: () -> Unit,
    text: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                MaterialTheme.colorScheme.background,
                RoundedCornerShape(20.dp)
            )
            .padding(vertical = 10.dp, horizontal = 17.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(image), contentDescription = null)
            HorizontalSpacingS()
            Text(
                text = text,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.SemiBold
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (Mywallet) {
                Text(
                    text = "$9,379",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    fontWeight = FontWeight.Bold
                )
            }
            RadioButton(
                selected = selected,
                onClick = onSelect,
                colors = RadioButtonDefaults.colors(
                    selectedColor = MaterialTheme.colorScheme.primary,
                    unselectedColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    }
}