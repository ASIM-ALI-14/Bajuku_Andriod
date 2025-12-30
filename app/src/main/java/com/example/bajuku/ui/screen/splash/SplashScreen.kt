package com.example.bajuku.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun SplashScreen(onFinish: () -> Unit) {
    val viewModel: SplashViewModel = viewModel()
    val uiModel = viewModel.uiModel
    val navigate by viewModel.navigate.collectAsState()

    LaunchedEffect(navigate) {
        if (navigate) onFinish()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(uiModel.logoRes),
            contentDescription = null,
            modifier = Modifier.size(uiModel.logoSizeDp.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = uiModel.appName,
            style = MaterialTheme.typography.displaySmall.copy(
                fontWeight = FontWeight.Bold,
                shadow = Shadow(
                    color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.25f),
                    offset = Offset(2f, 2f),
                    blurRadius = 4f
                )

            )
        )


    }
}