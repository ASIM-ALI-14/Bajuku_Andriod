package com.example.bajuku.ui.screen.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.bajuku.R
import com.example.bajuku.ui.components.SelectedButton
import com.example.bajuku.ui.theme.screenHorizontal
import com.example.bajuku.ui.theme.verticalSpacingEXL
import com.example.bajuku.ui.theme.verticalSpacingS

@Composable
fun CongratulationsScreen(navController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = screenHorizontal)
    ) {
        Spacer(modifier = Modifier.height(223.dp))
        Image(
            painter = painterResource(R.drawable.congratulations),
            contentDescription = null,
            modifier = Modifier.size(110.dp)
        )
        verticalSpacingS()
        Text(text = "Congratulations!")
        verticalSpacingS()
        Text(
            text = "Your account is ready to use. You will be\nredirected to the Home page in a few seconds..",
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.weight(1f))
        SelectedButton(
            "Continue",
            {
                navController.navigate("home") {
                    popUpTo("onboarding_intro") { inclusive = true }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            selected = true,
        )
        verticalSpacingEXL()


    }

}