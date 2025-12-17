package com.example.bajuku.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bajuku.R

@Preview
@Composable
fun OnboardingScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Image(
            painterResource(R.drawable.onboarding_1),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp)
        ) {
            Spacer(modifier = Modifier.height(15.dp))

            Row {
                Box(
                    modifier = Modifier
                        .size(73.dp, 4.dp)
                        .background(MaterialTheme.colorScheme.onBackground)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Box(
                    modifier = Modifier
                        .size(73.dp, 4.dp)
                        .background(MaterialTheme.colorScheme.onBackground.copy(alpha = 0.3f))
                )
                Spacer(modifier = Modifier.width(12.dp))
                Box(
                    modifier = Modifier
                        .size(73.dp, 4.dp)
                        .background(MaterialTheme.colorScheme.onBackground.copy(alpha = 0.3f))
                )
                Spacer(modifier = Modifier.width(12.dp))
                Box(
                    modifier = Modifier
                        .size(73.dp, 4.dp)
                        .background(MaterialTheme.colorScheme.onBackground.copy(alpha = 0.3f))
                )

            }
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                "Welcome to Bajuku App",
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Find the latest trends and most up-to-date fashion\nchoices in the \"Latest Collections\" section. Start your\nfashion journey with the most stylish items from leading\nbrands.",
                style = MaterialTheme.typography.labelLarge, fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(45.dp))
            Button(
                onClick = {}, modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.background
                )
            ) {
                Text(text = "Next")
            }
        }


    }
}