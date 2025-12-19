package com.example.bajuku.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.bajuku.R


val PlusJakartaSans = FontFamily(
    Font(R.font.regular, FontWeight.Normal),      // Regular weight
    Font(R.font.medium, FontWeight.Medium),       // Medium weight
    Font(R.font.semibold, FontWeight.SemiBold),   // SemiBold weight
    Font(R.font.bold, FontWeight.Bold)    // SemiBold weight
)

val Typography = Typography(
    displayLarge = TextStyle(       // H1
        fontFamily = PlusJakartaSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 41.sp
    ),
    displayMedium = TextStyle(
        // H2
        fontFamily = PlusJakartaSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 33.sp,

        ),
    displaySmall = TextStyle(       // H3
        fontFamily = PlusJakartaSans,
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp
    ),
    headlineLarge = TextStyle(
        // H4
        fontFamily = PlusJakartaSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 21.sp,
    ),
    headlineMedium = TextStyle(     // H5
        fontFamily = PlusJakartaSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 19.sp
    ),
    headlineSmall = TextStyle(      // H6
        fontFamily = PlusJakartaSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 17.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = PlusJakartaSans,
        fontSize = 19.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = PlusJakartaSans,
        fontSize = 17.sp
    ), bodySmall = TextStyle(
        fontFamily = PlusJakartaSans,
        fontSize = 15.sp
    ),
    labelLarge = TextStyle(
        fontFamily = PlusJakartaSans,
        fontSize = 13.sp,
        lineHeight = 18.sp
    )
)