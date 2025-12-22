package com.example.bajuku.ui.screen.onboarding

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import com.example.bajuku.ui.components.NotSelectedButton
import com.example.bajuku.ui.components.SelectedButton
import com.example.bajuku.ui.theme.screenHorizontal
import com.example.bajuku.ui.theme.verticalSpacingL
import com.example.bajuku.ui.theme.verticalSpacingM
import com.example.bajuku.ui.theme.verticalSpacingS

@Composable
fun SelectionScreen(navController: NavHostController) {
    var selectedOptions by remember { mutableStateOf(setOf<String>()) }

    // Determine if Continue button should be enabled
    val isContinueEnabled = selectedOptions.isNotEmpty()
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
                text = "1/5",
                modifier = Modifier.align(Alignment.Center),
                color = MaterialTheme.colorScheme.surfaceVariant,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Column(modifier = Modifier.padding(screenHorizontal)) {
            Text("Target Audience Selection", style = MaterialTheme.typography.displaySmall)
            Text(
                text = "Who do you usually shop for? (You can select multiple\noptions)",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.surfaceVariant,
            )
            verticalSpacingL()
            val options = listOf("Woman", "Man", "Kids", "Baby")

            options.forEach { option ->
                val isSelected = selectedOptions.contains(option)
                NotSelectedButton(
                    text = option,
                    onclick = {
                        selectedOptions = if (isSelected) {
                            selectedOptions - option
                        } else {
                            selectedOptions + option
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
                    isSelected
                )
                verticalSpacingS()
            }
            Spacer(modifier = Modifier.weight(1f))
            SelectedButton(
                "Continue",
                onclick = {
                    if (isContinueEnabled) {
                        navController.navigate("interests")
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                selected = isContinueEnabled
            )
            verticalSpacingM()
        }
    }
}