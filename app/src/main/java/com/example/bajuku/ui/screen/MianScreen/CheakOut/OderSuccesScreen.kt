package com.example.bajuku.ui.screen.MianScreen.CheakOut

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.bajuku.R
import com.example.bajuku.ui.components.PrimaryButton
import com.example.bajuku.ui.components.SecondaryButton

import com.example.bajuku.ui.theme.screenHorizontal
import com.example.bajuku.ui.theme.verticalSpacingEXL
import com.example.bajuku.ui.theme.verticalSpacingS

@Composable
fun OrderSuccessScreen(onBack: () -> Unit) {
    Scaffold(topBar = { CheckOutTopbar(onBack) }) { paddingValues ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(horizontal = screenHorizontal)
        ) {
            Image(
                painter = painterResource(R.drawable.congratulations),
                contentDescription = null,
                modifier = Modifier.size(130.dp)
            )
            verticalSpacingS()
            Text(
                text = "Order Successful!",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
            verticalSpacingS()
            Text(
                text = "You have successfully made order",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary
            )
            verticalSpacingEXL()
            PrimaryButton(
                "Continue",
                {
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 60.dp),
                isSelected = true,
            )
            verticalSpacingS()
            SecondaryButton(
                "View E-Receipt",
                {
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 60.dp),
                onSelected = false,
            )


        }
    }
}
