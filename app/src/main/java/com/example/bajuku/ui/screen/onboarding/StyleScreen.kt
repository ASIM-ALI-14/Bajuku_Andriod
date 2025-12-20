package com.example.bajuku.ui.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.bajuku.R
import com.example.bajuku.ui.components.SelectedButton
import com.example.bajuku.ui.theme.HorizontalSpacingM
import com.example.bajuku.ui.theme.screenHorizontal
import com.example.bajuku.ui.theme.verticalSpacingL
import com.example.bajuku.ui.theme.verticalSpacingM

@Composable
fun StyleScreen() {
    var selectedOptions by remember { mutableStateOf(setOf<String>()) }
    val isContinueEnabled = selectedOptions.isNotEmpty()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        // Top bar
        Box(modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = { /* Back */ }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
            Text(
                text = "3/5",
                modifier = Modifier.align(Alignment.Center),
                color = MaterialTheme.colorScheme.surfaceVariant,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Column(modifier = Modifier.padding(screenHorizontal)) {
            Text(
                "Target Audience Selection",
                style = MaterialTheme.typography.displaySmall
            )
            Text(
                "Who do you usually shop for? (You can select multiple options)",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.surfaceVariant
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
                        selectedOptions = if (selectedOptions.contains(id)) {
                            selectedOptions - id
                        } else {
                            selectedOptions + id
                        }
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
                        selectedOptions = if (selectedOptions.contains(id)) {
                            selectedOptions - id
                        } else {
                            selectedOptions + id
                        }
                    }
                    HorizontalSpacingM()
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            SelectedButton(
                text = "Continue",
                onclick = { /* Continue action */ },
                modifier = Modifier.fillMaxWidth(),
                selected = isContinueEnabled
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

