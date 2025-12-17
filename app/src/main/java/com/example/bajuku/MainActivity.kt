package com.example.bajuku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.bajuku.ui.screens.Splash.onboarding.Onboarding_1
import com.example.bajuku.ui.theme.BajukuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BajukuTheme {
                Onboarding_1()
            }
        }
    }
}

