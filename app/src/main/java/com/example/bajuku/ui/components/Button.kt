package com.example.bajuku.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SelectedButton(text: String, onclick: () -> Unit, modifier: Modifier, selected: Boolean) {

    Button(
        onClick = { onclick() },
        modifier = modifier.height(45.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = if (selected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant,
            containerColor = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Text(text = text)
    }
}

@Composable
fun NotSelectedButton(text: String, onclick: () -> Unit, modifier: Modifier, selected: Boolean) {
    OutlinedButton(
        onClick = { onclick() }, border = BorderStroke(
            1.dp,
            if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline
        ), colors = ButtonDefaults.outlinedButtonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.surfaceVariant

        ),
        modifier = modifier
    ) {
        Text(text = text)
    }
}