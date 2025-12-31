package com.example.bajuku.ui.screen.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.bajuku.ui.components.PrimaryButton
import com.example.bajuku.ui.screen.onboarding.Components.InterestsItemButton
import com.example.bajuku.ui.screen.onboarding.Components.OnboardingHeadings
import com.example.bajuku.ui.screen.onboarding.Components.OnboardingTopBar
import com.example.bajuku.ui.screen.onboarding.Model.interestOptions
import com.example.bajuku.ui.theme.screenHorizontal
import com.example.bajuku.ui.theme.verticalSpacingL
import com.example.bajuku.ui.theme.verticalSpacingM

@Composable
fun Onboarding_3(navController: NavHostController) {

    var selectedOptions by remember { mutableStateOf(setOf<String>()) }
    val interests = interestOptions


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
        OnboardingTopBar(
            onBack = { navController.popBackStack() },
            heading = "2/5"
        )
        Column(modifier = Modifier.padding(screenHorizontal)) {
            OnboardingHeadings(
                "Exploring Interests",
                "Which categories are you interested in ? (You can select\nmultiple options)"
            )
            verticalSpacingL()
            interests.chunked(3).forEach { rowItems ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    rowItems.forEach { item ->
                        InterestsItemButton(
                            onclick = { toggleSelection(item.id) },
                            text = item.title,
                            image = item.iconRes,
                            selected = selectedOptions.contains(item.id),
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            PrimaryButton(
                "Continue",
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    if (isContinueEnabled) {
                        navController.navigate("style")
                    }
                },
                isSelected = isContinueEnabled
            )
            verticalSpacingM()
        }
    }

}

