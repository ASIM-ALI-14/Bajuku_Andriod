package com.example.bajuku.ui.screen.Authantication

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.input.key.Key
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OtpBox(
    value: String,
    onValueChange: (String) -> Unit,
    onBackspace: () -> Unit,
    modifier: Modifier = Modifier,
    focusRequester: FocusRequester,
    isFocused: Boolean,
    boxSize: Int = 47,
    filledColor: Color = MaterialTheme.colorScheme.primaryContainer,
    borderColor: Color = MaterialTheme.colorScheme.outline
) {
    val interactionSource = remember { MutableInteractionSource() }

    BasicTextField(
        value = value,
        onValueChange = { if (it.length <= 1) onValueChange(it) },
        modifier = modifier
            .size(boxSize.dp)
            .focusRequester(focusRequester)
            .onKeyEvent {
                if (it.key == Key.Backspace && value.isEmpty()) {
                    onBackspace()
                    true
                } else false
            }
            .border(
                width = 1.dp,
                color = if (isFocused) MaterialTheme.colorScheme.primary else borderColor,
                shape = RoundedCornerShape(12.dp)
            )
            .background(
                color = if (value.isNotEmpty()) filledColor else Color.Transparent,
                shape = RoundedCornerShape(12.dp)
            ),
        singleLine = true,
        textStyle = TextStyle(
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.onBackground
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        interactionSource = interactionSource,
        decorationBox = { innerTextField ->
            Box(contentAlignment = Alignment.Center) { innerTextField() }
        }
    )
}

@Composable
fun OtpVerificationRow(
    otpLength: Int = 6,
    onOtpComplete: (String) -> Unit,
    boxSize: Int = 47,
    spacing: Int = 8
) {
    val otpValues = remember { mutableStateListOf(*Array(otpLength) { "" }) }
    val focusRequesters = remember { List(otpLength) { FocusRequester() } }

    Row(horizontalArrangement = Arrangement.spacedBy(spacing.dp)) {
        otpValues.forEachIndexed { index, value ->

            val interactionSource = remember { MutableInteractionSource() }
            val isFocused by interactionSource.collectIsFocusedAsState()

            OtpBox(
                value = value,
                isFocused = isFocused,
                focusRequester = focusRequesters[index],
                onValueChange = { newValue ->
                    otpValues[index] = newValue

                    // Move focus to next box
                    if (newValue.isNotEmpty() && index < otpLength - 1) {
                        focusRequesters[index + 1].requestFocus()
                    }

                    // Always update OTP
                    onOtpComplete(otpValues.joinToString(""))
                },
                onBackspace = {
                    otpValues[index] = "" // clear current box
                    if (index > 0) {
                        focusRequesters[index - 1].requestFocus()
                    }

                    // Update OTP after deletion
                    onOtpComplete(otpValues.joinToString(""))
                },
                boxSize = boxSize
            )

        }
    }
}


