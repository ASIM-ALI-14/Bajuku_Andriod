package com.example.bajuku.ui.screen.onboarding.Components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bajuku.ui.theme.verticalSpacingXS

@Composable
fun OnboardingTopBar(onBack: () -> Unit, heading: String) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        IconButton(
            onClick = { onBack() }
        ) {
            Icon(
                Icons.Filled.ArrowBack,
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp),
                tint = MaterialTheme.colorScheme.onBackground

            )
        }
        Text(
            text = heading,
            modifier = Modifier.align(Alignment.Center),
            color = MaterialTheme.colorScheme.surfaceVariant,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun OnboardingHeadings(heading: String, subHeading: String) {
    Column() {
        Text(heading, style = MaterialTheme.typography.displaySmall)
        verticalSpacingXS()
        Text(
            text = subHeading,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.surfaceVariant,
        )
    }

}