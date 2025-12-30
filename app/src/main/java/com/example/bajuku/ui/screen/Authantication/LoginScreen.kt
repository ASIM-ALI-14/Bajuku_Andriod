package com.example.bajuku.ui.screen.Authantication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.bajuku.R
import com.example.bajuku.ui.components.AppTextFieldBasic
import com.example.bajuku.ui.theme.HorizontalSpacingS
import com.example.bajuku.ui.theme.screenHorizontal
import com.example.bajuku.ui.theme.verticalSpacingEXL
import com.example.bajuku.ui.theme.verticalSpacingL
import com.example.bajuku.ui.theme.verticalSpacingM
import com.example.bajuku.ui.theme.verticalSpacingS

@Composable
fun LoginScreen(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var Password by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .padding(horizontal = screenHorizontal)
            .systemBarsPadding()
            .background(MaterialTheme.colorScheme.background)

    ) {
        verticalSpacingM()
        Text("Login", style = MaterialTheme.typography.displayMedium)
        verticalSpacingS()
        Text("Secure your account with a swift login", style = MaterialTheme.typography.labelLarge)
        verticalSpacingL()
        Text(
            text = "Phone number or email",
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold
        )
        verticalSpacingS()
        AppTextFieldBasic(
            value = email,
            onValueChange = { email = it },
            keyboardType = KeyboardType.Email,
            leadingIcon = Icons.Outlined.MailOutline,
            placeholder = "Input your mail"
        )
        verticalSpacingM()
        Text(text = "Password", style = MaterialTheme.typography.labelLarge)
        verticalSpacingS()
        AppTextFieldBasic(
            value = Password,
            onValueChange = { Password = it },
            keyboardType = KeyboardType.Password,
            placeholder = "Input your Password"
        )
        verticalSpacingS()
        Text(
            text = "Forgot Password?",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.secondary
        )
        verticalSpacingL()
//        Button(
//            "Login",
//            {},
//
//            Modifier.fillMaxWidth(),
//            true
//        )
        verticalSpacingL()

        Row(verticalAlignment = Alignment.CenterVertically) {
            Divider(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp),
                color = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
            )

            Spacer(modifier = Modifier.width(8.dp)) // Space before text

            Text(
                text = "OR",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.width(8.dp)) // Space after text

            // Right divider
            Divider(
                modifier = Modifier
                    .weight(1f)
                    .height(1.dp),
                color = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
            )

        }
        verticalSpacingM()
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary
            )
        ) {
            Image(painter = painterResource(R.drawable.vector__1_), contentDescription = null)
            HorizontalSpacingS()
            Text(text = "Login with Facebook")

        }
        verticalSpacingS()
        OutlinedButton(
            onClick = {},
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
        ) {
            Image(painter = painterResource(R.drawable.group_1171274547), contentDescription = null)
            HorizontalSpacingS()
            Text(
                text = "Login with Facebook",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = " Don't have an account?",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            HorizontalSpacingS()
            Text(
                text = "Register",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.clickable {
                    navController.navigate("register")
                }
            )
        }
        verticalSpacingEXL()

    }
}