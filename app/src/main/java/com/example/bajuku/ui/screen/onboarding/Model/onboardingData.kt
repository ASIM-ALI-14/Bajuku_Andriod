package com.example.bajuku.ui.screen.onboarding.Model

import com.example.bajuku.R

data class OnboardingItem(
    val imageRes: Int,
    val title: String,
    val description: String
)

val onboardingItems = listOf(
    OnboardingItem(
        imageRes = R.drawable.onboarding_1,
        title = "Welcome to Bajuku App",
        description = "Find the latest trends and most up-to-date fashion choices in the \"Latest Collections\" section. Start your fashion journey with the most stylish items from leading brands."
    ),
    OnboardingItem(
        imageRes = R.drawable.onboarding_2,
        title = "Be the First to Know",
        description = "Enable the notification feature on your device to stay\ninformed about personally curated new arrival,trilling\nproduct launches, and exclusive promotional."
    ),
    OnboardingItem(
        imageRes = R.drawable.onboarding_3,
        title = "Sell on, Join the Collective",
        description = "By choosing to sell your items on our platform, you not\nonly find a potential buyer but also contribute to giving\nyour pre-loved belongings a fresh start"
    ),
    OnboardingItem(
        imageRes = R.drawable.onbording_4,
        title = "Tell us about you",
        description = "Based on your preferences, we will recommend style\nand send messages that we think you will love. "
    )
)