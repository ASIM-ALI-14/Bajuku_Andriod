package com.example.bajuku.ui.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.bajuku.R
import com.example.bajuku.ui.components.PrimaryButton
import com.example.bajuku.ui.screen.onboarding.Components.OnboardingHeadings
import com.example.bajuku.ui.screen.onboarding.Components.OnboardingTopBar
import com.example.bajuku.ui.theme.HorizontalSpacingM
import com.example.bajuku.ui.theme.screenHorizontal
import com.example.bajuku.ui.theme.verticalSpacingL
import com.example.bajuku.ui.theme.verticalSpacingM

@Composable
fun StyleScreen(navController: NavHostController) {
    var selectedOptions by remember { mutableStateOf(setOf<String>()) }
    val isContinueEnabled = selectedOptions.isNotEmpty()
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
        // Top bar
        OnboardingTopBar(
            onBack = { navController.popBackStack() },
            heading = "3/5"
        )
        Column(modifier = Modifier.padding(screenHorizontal)) {
            OnboardingHeadings(
                "Style Selection",
                "Who do you usually shop for? (You can select multiple\noptions)"
            )
            verticalSpacingL()
            // Woman styles
            Text("Woman", style = MaterialTheme.typography.titleLarge)
            verticalSpacingM()
            Row {
                val womanOptions = listOf(
                    "Casual" to R.drawable.style_1,
                    "Lounge" to R.drawable.style_2,
                    "Cute" to R.drawable.style_3
                )
                womanOptions.forEach { (text, image) ->
                    val id = "Woman_$text" // Unique ID
                    StyleItem(text, image, selectedOptions.contains(id)) {
                        toggleSelection(id)

                    }
                    HorizontalSpacingM()
                }
            }
            verticalSpacingM()

            // Man styles
            Text("Man", style = MaterialTheme.typography.titleLarge)
            verticalSpacingM()
            Row {
                val manOptions = listOf(
                    "Casual" to R.drawable.style_4,
                    "Formal" to R.drawable.style_5,
                    "Cute" to R.drawable.style_6
                )
                manOptions.forEach { (text, image) ->
                    val id = "Man_$text" // Unique ID
                    StyleItem(text, image, selectedOptions.contains(id)) {
                        toggleSelection(id)
                    }
                    HorizontalSpacingM()
                }
            }
            Spacer(modifier = Modifier.weight(1f))

            PrimaryButton(
                buttonText = "Continue",
                onClick = {
                    if (isContinueEnabled) {
                        navController.navigate("interests")
                    }
                }, modifier = Modifier.fillMaxWidth(), isSelected = isContinueEnabled
            )
            verticalSpacingM()
        }
    }
}


// StyleItem composable
@Composable
fun StyleItem(text: String, image: Int, isSelected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(106.dp, 117.dp)
            .clip(RoundedCornerShape(8.dp))
            .border(
                2.dp,
                if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent,
                RoundedCornerShape(8.dp)
            )
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Gradient overlay at bottom
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    androidx.compose.ui.graphics.Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            MaterialTheme.colorScheme.primary.copy(alpha = 0.4f)
                        )
                    )
                )
        )

        // Text overlay
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.background,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 12.dp)
        )
    }
}

