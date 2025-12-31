package com.example.bajuku.ui.screens.onboarding

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.bajuku.ui.components.PrimaryButton
import com.example.bajuku.ui.components.SecondaryButton
import com.example.bajuku.ui.screen.onboarding.Components.PageIndicator
import com.example.bajuku.ui.screen.onboarding.Model.onboardingItems
import com.example.bajuku.ui.theme.screenHorizontal
import com.example.bajuku.ui.theme.verticalSpacingEXL
import com.example.bajuku.ui.theme.verticalSpacingL
import com.example.bajuku.ui.theme.verticalSpacingM

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun OnboardingScreen(onFinished: () -> Unit) {
    var currentPage by remember { mutableStateOf(0) }
    var previousPage by remember { mutableStateOf(0) }
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight * 0.7f) // Fixed image height
                .clipToBounds()
        ) {
            // Animate image change with direction
            AnimatedContent(
                targetState = currentPage,
                transitionSpec = {
                    if (targetState > previousPage) {
                        // Next animation
                        slideInHorizontally(
                            initialOffsetX = { fullWidth -> fullWidth },
                            animationSpec = tween(500)
                        ) + fadeIn(animationSpec = tween(500)) with
                                slideOutHorizontally(
                                    targetOffsetX = { fullWidth -> -fullWidth },
                                    animationSpec = tween(500)
                                ) + fadeOut(animationSpec = tween(500))
                    } else {
                        // Back animation (reverse)
                        slideInHorizontally(
                            initialOffsetX = { fullWidth -> -fullWidth },
                            animationSpec = tween(500)
                        ) + fadeIn(animationSpec = tween(500)) with
                                slideOutHorizontally(
                                    targetOffsetX = { fullWidth -> fullWidth },
                                    animationSpec = tween(500)
                                ) + fadeOut(animationSpec = tween(500))
                    }
                }
            ) { page ->
                Image(
                    painter = painterResource(onboardingItems[page].imageRes),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            // Page indicator
            PageIndicator(
                totalPages = onboardingItems.size,
                currentPage = currentPage,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 15.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = screenHorizontal)
        ) {
            verticalSpacingM()

            // Title
            AnimatedContent(
                targetState = onboardingItems[currentPage].title,
                transitionSpec = { fadeIn(tween(400)) with fadeOut(tween(400)) }
            ) { title ->
                Text(
                    text = title,
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.SemiBold
                )
            }

            verticalSpacingM()
            Box(modifier = Modifier.height(screenHeight * 0.1f)) {
                // Description
                AnimatedContent(
                    targetState = onboardingItems[currentPage].description,
                    transitionSpec = { fadeIn(tween(400)) with fadeOut(tween(400)) }
                ) { desc ->
                    Text(
                        text = desc,
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
            verticalSpacingM()
            if (currentPage == 0) {
                // First page: full width Next button only
                PrimaryButton(
                    buttonText = "Next",
                    onClick = {
                        previousPage = currentPage
                        currentPage++
                    },
                    modifier = Modifier.fillMaxWidth(),
                    true
                )
            } else {
                // From second page onwards: Back + Next in a row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    SecondaryButton(
                        buttonText = "Back",
                        onClick = {
                            previousPage = currentPage
                            currentPage--
                        },
                        modifier = Modifier.weight(1f),
                        onSelected = false
                    )

                    Spacer(modifier = Modifier.width(16.dp)) // Optional spacing

                    PrimaryButton(
                        buttonText = "Next",
                        onClick = {
                            previousPage = currentPage
                            if (currentPage < onboardingItems.size - 1) {
                                currentPage++
                            } else {
                                onFinished()
                            }
                        },
                        modifier = Modifier.weight(1f),
                        true
                    )
                }
            }
        }
    }
}