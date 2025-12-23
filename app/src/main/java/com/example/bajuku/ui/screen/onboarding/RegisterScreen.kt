package com.example.bajuku.ui.screen.onboarding

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.bajuku.ui.components.SelectedButton
import com.example.bajuku.ui.components.AppTextFieldBasic
import com.example.bajuku.ui.screen.onboarding.Components.PasswordRequirements
import com.example.bajuku.ui.theme.HorizontalSpacingS
import com.example.bajuku.ui.theme.screenHorizontal
import com.example.bajuku.ui.theme.verticalSpacingEXL
import com.example.bajuku.ui.theme.verticalSpacingM
import com.example.bajuku.ui.theme.verticalSpacingS

@Composable
fun RegisterScreen(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var Password by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        verticalSpacingM()
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = { navController.popBackStack() }
            ) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp),
                    tint = MaterialTheme.colorScheme.onBackground

                )
            }
            Text(
                text = "Register",
                modifier = Modifier.align(Alignment.Center),
                color = MaterialTheme.colorScheme.surfaceVariant,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold
            )
        }
        Column(
            modifier = Modifier
                .padding(screenHorizontal)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        2.dp,
                        MaterialTheme.colorScheme.outline.copy(alpha = 0.5f),
                        RoundedCornerShape(12.dp)
                    )
                    .padding(15.dp)

            ) {
                Text(
                    text = "Phone number or email",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Medium
                )
                verticalSpacingS()
                AppTextFieldBasic(
                    value = email,
                    onValueChange = { email = it },
                    keyboardType = KeyboardType.Email,
                    leadingIcon = Icons.Outlined.MailOutline,
                    placeholder = "Example@gmail.com"
                )
                verticalSpacingM()
                Text(
                    text = "Password",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Medium
                )
                verticalSpacingS()
                AppTextFieldBasic(
                    value = Password,
                    onValueChange = { Password = it },
                    keyboardType = KeyboardType.Password,
                    placeholder = "Please your password"
                )
                verticalSpacingM()
                Text(
                    text = "Conform Password",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Medium
                )
                verticalSpacingS()
                AppTextFieldBasic(
                    value = Password,
                    onValueChange = { Password = it },
                    keyboardType = KeyboardType.Password,
                    placeholder = "Please your password"
                )
                verticalSpacingS()
                val passwordRequirements = listOf(
                    "Has at least 8 characters (no space)",
                    "Has numbers, letters, and special characters",
                    "Not easy to guess"
                )
                PasswordRequirements(requirements = passwordRequirements)
                verticalSpacingM()
                SelectedButton(
                    "Register",
                    onclick = { navController.navigate("verification") },
                    modifier = Modifier.fillMaxWidth(),
                    true
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Already have an account?",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            HorizontalSpacingS()
            Text(
                text = "Login",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.clickable {
                    navController.navigate("login")
                }
            )
        }
        verticalSpacingEXL()
    }

}