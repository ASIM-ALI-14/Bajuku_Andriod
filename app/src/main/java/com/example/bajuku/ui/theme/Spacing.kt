package com.example.bajuku.ui.theme

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun verticalSpacingEXL() {
    Spacer(modifier = Modifier.height(42.dp))
}

@Composable
fun verticalSpacingL() {
    Spacer(modifier = Modifier.height(36.dp))
}

@Composable
fun verticalSpacingM() {
    Spacer(modifier = Modifier.height(18.dp))
}

@Composable
fun verticalSpacingS() {
    Spacer(modifier = Modifier.height(11.dp))
}

@Composable
fun verticalSpacingXS() {
    Spacer(modifier = Modifier.height(4.dp))
}

@Composable
fun HorizontalSpacingEXL() {
    Spacer(modifier = Modifier.width(45.dp))
}

@Composable
fun HorizontalSpacingL() {
    Spacer(modifier = Modifier.width(30.dp))
}

@Composable
fun HorizontalSpacingM() {
    Spacer(modifier = Modifier.width(15.dp))
}

@Composable
fun HorizontalSpacingS() {
    Spacer(modifier = Modifier.width(7.dp))
}

@Composable
fun HorizontalSpacingES() {
    Spacer(modifier = Modifier.height(4.dp))
}

val screenHorizontal: Dp = 16.dp

