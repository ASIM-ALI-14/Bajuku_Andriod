package com.example.bajuku
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.bajuku.ui.screen.onboarding.LoginScreen
import com.example.bajuku.ui.theme.BajukuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BajukuTheme {
                LoginScreen()
            }
        }
    }
}

