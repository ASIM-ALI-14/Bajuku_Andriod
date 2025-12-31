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
import com.example.bajuku.ui.components.SecondaryButton
import com.example.bajuku.ui.screen.onboarding.Components.InterestsItemButton
import com.example.bajuku.ui.screen.onboarding.Components.OnboardingHeadings
import com.example.bajuku.ui.screen.onboarding.Components.OnboardingTopBar
import com.example.bajuku.ui.screen.onboarding.Model.audienceOptions
import com.example.bajuku.ui.theme.screenHorizontal
import com.example.bajuku.ui.theme.verticalSpacingL
import com.example.bajuku.ui.theme.verticalSpacingM
import com.example.bajuku.ui.theme.verticalSpacingS

@Composable
fun SelectionScreen(navController: NavHostController) {
    var selectedOptions by remember { mutableStateOf(setOf<String>()) }
    val isContinueEnabled = selectedOptions.isNotEmpty()
    val options = audienceOptions

    val toggleSelection: (String) -> Unit = { option ->
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
            heading = "1/5"
        )
        Column(modifier = Modifier.padding(screenHorizontal)) {
            OnboardingHeadings(
                "Target Audience Selection",
                "Who do you usually shop for? (You can select multiple\noptions)"
            )
            verticalSpacingL()

            options.forEach { option ->
                val isSelected = selectedOptions.contains(option.id)

                SecondaryButton(
                    buttonText = option.title,
                    onClick = { toggleSelection(option.id) },
                    modifier = Modifier.fillMaxWidth(),
                    onSelected = isSelected
                )
                verticalSpacingS()
            }

            Spacer(modifier = Modifier.weight(1f))
            PrimaryButton(
                "Continue",
                onClick = {
                    if (isContinueEnabled) {
                        navController.navigate("interests")
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                isSelected = isContinueEnabled
            )
        }
    }
}

