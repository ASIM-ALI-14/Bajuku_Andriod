package com.example.bajuku.ui.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bajuku.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class SplashUiModel(
    val appName: String,
    val logoRes: Int,
    val logoSizeDp: Int
)

class SplashViewModel : ViewModel() {
    private val _navigate = MutableStateFlow(false)
    val navigate = _navigate.asStateFlow()
    val uiModel = SplashUiModel(
        appName = "Bajuku",
        logoRes = R.drawable.main_logo,
        logoSizeDp = 44
    )

    init {
        startSplash()
    }

    private fun startSplash() {
        viewModelScope.launch {
            delay(1500)
            _navigate.value = true
        }
    }
}