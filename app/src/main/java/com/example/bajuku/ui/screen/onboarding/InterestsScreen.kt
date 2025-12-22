package com.example.bajuku.ui.screen.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.bajuku.R
import com.example.bajuku.ui.components.SelectedButton
import com.example.bajuku.ui.screen.onboarding.Components.InterestsItemButton
import com.example.bajuku.ui.theme.screenHorizontal
import com.example.bajuku.ui.theme.verticalSpacingL
import com.example.bajuku.ui.theme.verticalSpacingM

@Composable
fun Onboarding_3(navController: NavHostController) {
    var selectedOptions by remember { mutableStateOf(setOf<String>()) }

    // Determine if Continue button should be enabled
    val isContinueEnabled = selectedOptions.isNotEmpty()
    fun toggleSelection(option: String) {
        selectedOptions =
            if (selectedOptions.contains(option))
                selectedOptions - option
            else
                selectedOptions + option
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = { navController.popBackStack() }
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
                text = "2/5",
                modifier = Modifier.align(Alignment.Center),
                color = MaterialTheme.colorScheme.surfaceVariant,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Column(modifier = Modifier.padding(screenHorizontal)) {
            Text("Exploring Interests", style = MaterialTheme.typography.displaySmall)
            Text(
                text = "Which categories are you interested in ? (You can select\nmultiple options)",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.surfaceVariant,
            )
            verticalSpacingL()
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                InterestsItemButton(
                    "Hats",
                    { toggleSelection("Hats") },
                    modifier = Modifier,
                    selected = selectedOptions.contains("Hats"), R.drawable.group,

                    )
                InterestsItemButton(
                    "Jacket",
                    { toggleSelection("Jacket") },
                    modifier = Modifier,
                    selected = selectedOptions.contains("Jacket"), R.drawable.group,
                )
                InterestsItemButton(
                    "Dress & Skirts",
                    { toggleSelection("Dress & Skirts") },
                    modifier = Modifier,
                    selected = selectedOptions.contains("Dress & Skirts"),
                    R.drawable.group,
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                InterestsItemButton(
                    "Shoes",
                    { toggleSelection("Shoes") },
                    modifier = Modifier,
                    selected = selectedOptions.contains("Shoes"),
                    R.drawable.group,
                )
                InterestsItemButton(
                    "Accessories",
                    { toggleSelection("Accessories") },
                    modifier = Modifier,
                    selected = selectedOptions.contains("Accessories"),
                    R.drawable.group,
                )
                InterestsItemButton(
                    "Sport",
                    { toggleSelection("Sport") },
                    modifier = Modifier,
                    selected = selectedOptions.contains("Sport"),
                    R.drawable.group,
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            SelectedButton(
                "Continue",
                modifier = Modifier.fillMaxWidth(),
                selected = isContinueEnabled,
                onclick = {
                    if (isContinueEnabled) {
                        navController.navigate("style")
                    }
                }
            )
            verticalSpacingM()
        }

    }
}