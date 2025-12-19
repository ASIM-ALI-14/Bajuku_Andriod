package com.example.bajuku.ui.screen.onboarding

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.outlined.Face
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.bajuku.R
import com.example.bajuku.ui.components.SelectedButton
import com.example.bajuku.ui.screen.onboarding.Components.InterestsItemButton
import com.example.bajuku.ui.theme.screenHorizontal
import com.example.bajuku.ui.theme.verticalSpacingL
import com.example.bajuku.ui.theme.verticalSpacingM
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.HatCowboy
import compose.icons.fontawesomeicons.solid.VestPatches

@Composable
fun Onboarding_3() {
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
                onClick = {}
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
            Row() {
                InterestsItemButton(
                    "Hats",
                    {},
                    modifier = Modifier,
                    selected = false,
                    FontAwesomeIcons.Solid.HatCowboy
                )
                InterestsItemButton(
                    "Jacket",
                    {},
                    modifier = Modifier,
                    selected = false,
                    FontAwesomeIcons.Solid.VestPatches
                )
                InterestsItemButton(
                    "Dress & Skirts",
                    {},
                    modifier = Modifier,
                    selected = false,
                    FontAwesomeIcons.Solid.HatCowboy
                )
            }
            Row() {
                InterestsItemButton(
                    "Shoes",
                    {},
                    modifier = Modifier,
                    selected = false,
                    FontAwesomeIcons.Solid.HatCowboy
                )
                InterestsItemButton(
                    "Accessories",
                    {},
                    modifier = Modifier,
                    selected = false,
                    FontAwesomeIcons.Solid.HatCowboy
                )
                InterestsItemButton(
                    "Sport",
                    {},
                    modifier = Modifier,
                    selected = false,
                    FontAwesomeIcons.Solid.HatCowboy
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            SelectedButton(
                "Continue",
                {},
                modifier = Modifier.fillMaxWidth(),
                selected = isContinueEnabled
            )
            verticalSpacingM()
        }

    }
}