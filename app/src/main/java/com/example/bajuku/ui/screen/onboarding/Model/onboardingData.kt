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

// package com.example.bajuku.ui.screen.onboarding.model

data class AudienceOption(
    val id: String,
    val title: String
)

val audienceOptions = listOf(
    AudienceOption("woman", "Woman"),
    AudienceOption("man", "Man"),
    AudienceOption("kids", "Kids"),
    AudienceOption("baby", "Baby")
)


data class InterestOption(
    val id: String,
    val title: String,
    val iconRes: Int
)

val interestOptions = listOf(
    InterestOption("hats", "Hats", R.drawable.group__2_),
    InterestOption("jacket", "Jacket", R.drawable.group__1_),
    InterestOption("dress", "Dress & Skirts", R.drawable.vector),
    InterestOption("shoes", "Shoes", R.drawable.group),
    InterestOption("accessories", "Accessories", R.drawable.jewelry),
    InterestOption("sport", "Sport", R.drawable.group__3_)
)

enum class StyleCategory {
    WOMAN,
    MAN
}

data class StyleOption(
    val id: String,
    val title: String,
    val imageRes: Int,
    val category: StyleCategory
)

val styleOptions = listOf(
    // Woman
    StyleOption("woman_casual", "Casual", R.drawable.style_1, StyleCategory.WOMAN),
    StyleOption("woman_lounge", "Lounge", R.drawable.style_2, StyleCategory.WOMAN),
    StyleOption("woman_cute", "Cute", R.drawable.style_3, StyleCategory.WOMAN),

    // Man
    StyleOption("man_casual", "Casual", R.drawable.style_4, StyleCategory.MAN),
    StyleOption("man_formal", "Formal", R.drawable.style_5, StyleCategory.MAN),
    StyleOption("man_cute", "Cute", R.drawable.style_6, StyleCategory.MAN)
)
