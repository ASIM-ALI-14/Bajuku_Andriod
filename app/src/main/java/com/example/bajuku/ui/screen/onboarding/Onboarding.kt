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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
    var isAnimating by remember { mutableStateOf(false) }

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
                .weight(1f)
                .clipToBounds()
        ) {

            AnimatedContent(
                targetState = currentPage,
                transitionSpec = {
                    isAnimating = true

                    val direction =
                        if (targetState > initialState) 1 else -1

                    slideInHorizontally(
                        initialOffsetX = { it * direction },
                        animationSpec = tween(500)
                    ) + fadeIn(tween(500)) with
                            slideOutHorizontally(
                                targetOffsetX = { -it * direction },
                                animationSpec = tween(500)
                            ) + fadeOut(tween(500))
                },
                contentAlignment = Alignment.Center,
                label = "OnboardingImage"
            ) { page ->

                Image(
                    painter = painterResource(onboardingItems[page].imageRes),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            // Unlock input after animation completes
            LaunchedEffect(currentPage) {
                kotlinx.coroutines.delay(500)
                isAnimating = false
            }

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
                .heightIn(min = 80.dp)
        ) {

            verticalSpacingM()

            AnimatedContent(
                targetState = onboardingItems[currentPage].title,
                transitionSpec = { fadeIn(tween(300)) with fadeOut(tween(300)) },
                label = "Title"
            ) { title ->
                Text(
                    text = title,
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.SemiBold
                )
            }

            verticalSpacingM()

            AnimatedContent(
                targetState = onboardingItems[currentPage].description,
                transitionSpec = { fadeIn(tween(300)) with fadeOut(tween(300)) },
                label = "Description"
            ) { desc ->
                Text(
                    text = desc,
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Medium
                )
            }
        }
        verticalSpacingL()

        if (currentPage == 0) {

            PrimaryButton(
                buttonText = "Next",
                onClick = {
                    if (!isAnimating) currentPage++
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = screenHorizontal),
                isSelected = !isAnimating
            )

        } else {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = screenHorizontal),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                SecondaryButton(
                    buttonText = "Back",
                    onClick = {
                        if (!isAnimating) currentPage--
                    },
                    modifier = Modifier.weight(1f),
                    onSelected = false
                )

                Spacer(modifier = Modifier.width(16.dp))

                PrimaryButton(
                    buttonText = "Next",
                    onClick = {
                        if (!isAnimating) {
                            if (currentPage < onboardingItems.size - 1) {
                                currentPage++
                            } else {
                                onFinished()
                            }
                        }
                    },
                    modifier = Modifier.weight(1f),
                    isSelected = !isAnimating
                )
            }
        }
        verticalSpacingL()
    }
}
