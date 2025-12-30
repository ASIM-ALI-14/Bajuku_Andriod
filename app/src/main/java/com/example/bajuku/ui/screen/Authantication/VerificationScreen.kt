package com.example.bajuku.ui.screen.Authantication

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.bajuku.ui.theme.HorizontalSpacingS
import com.example.bajuku.ui.theme.screenHorizontal
import com.example.bajuku.ui.theme.verticalSpacingL
import com.example.bajuku.ui.theme.verticalSpacingM
import com.example.bajuku.ui.theme.verticalSpacingS

@Composable
fun VerificationScreen(navController: NavHostController) {
    var isOtpComplete by remember { mutableStateOf(false) }
    var otpValue by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = screenHorizontal)
            .systemBarsPadding()

    ) {
        verticalSpacingM()
        Text("Verification", style = MaterialTheme.typography.displaySmall)
        verticalSpacingS()
        Text(
            text = "We have sent an OTP code to the email",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
        verticalSpacingM()
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    1.dp,
                    MaterialTheme.colorScheme.outline.copy(alpha = 0.3f),
                    RoundedCornerShape(12.dp)
                )
                .padding(15.dp)

        ) {
            OtpVerificationRow { otp ->
                otpValue = otp
                isOtpComplete = true
            }
            verticalSpacingM()
            Row {

                Text(text = "Didn't receive the code?", style = MaterialTheme.typography.labelLarge)
                HorizontalSpacingS()
                Text(
                    text = "00:47",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.secondary,
                    fontWeight = FontWeight.SemiBold
                )
            }
            verticalSpacingM()
//            SelectedButton(
//                "Verification",
//                { if (isOtpComplete) navController.navigate("congratulations") },
//                modifier = Modifier.fillMaxWidth(),
//                selected = isOtpComplete
//            )
        }
        verticalSpacingL()
        Text(
            text = "Not my phone number? Change",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center
        )
    }


}