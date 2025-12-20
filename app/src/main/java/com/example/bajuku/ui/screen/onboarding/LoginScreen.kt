package com.example.bajuku.ui.screen.onboarding

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.bajuku.ui.screen.onboarding.Components.NotSelectedTextField
import com.example.bajuku.ui.theme.screenHorizontal
import com.example.bajuku.ui.theme.verticalSpacingL
import com.example.bajuku.ui.theme.verticalSpacingM
import com.example.bajuku.ui.theme.verticalSpacingS

@Composable
fun LoginScreen() {
    var text by remember { mutableStateOf("") }
    Column(modifier = Modifier
        .padding(horizontal = screenHorizontal)
        .systemBarsPadding()) {
        verticalSpacingM()
        Text("Login", style = MaterialTheme.typography.displayMedium)
        verticalSpacingS()
        Text("Secure your account with a swift login", style = MaterialTheme.typography.labelLarge)
        verticalSpacingL()
        Text(text = "Phone number or email", style = MaterialTheme.typography.labelLarge)
        verticalSpacingS()
        NotSelectedTextField(
            value = text,
            onValueChange = { text = it },
            selected = true,
            placeholder = "Email"
        )


    }
}