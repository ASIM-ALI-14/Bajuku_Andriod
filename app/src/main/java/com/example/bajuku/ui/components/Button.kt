package com.example.bajuku.ui.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Button(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isSelected: Boolean = true,
    selectedBg: Color = MaterialTheme.colorScheme.primary,
    selectedContent: Color = MaterialTheme.colorScheme.onPrimary,
    unselectedBg: Color = MaterialTheme.colorScheme.surfaceVariant,
    unselectedContent: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    height: Dp = 45.dp,
    outlined: Boolean = false
) {
    if (outlined) {
        OutlinedButton(
            onClick = onClick,
            border = BorderStroke(
                1.dp,
                if (isSelected) selectedBg else MaterialTheme.colorScheme.outline
            ),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = unselectedContent
            ),
            modifier = modifier.height(height)
        ) {
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                color = unselectedContent
            )
        }
    } else {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isSelected) selectedBg else unselectedBg,
                contentColor = if (isSelected) selectedContent else unselectedContent
            ),
            modifier = modifier.height(height)
        ) {
            Text(text = text, fontWeight = FontWeight.SemiBold, color = unselectedContent)
        }
    }
}

@Composable
fun PrimaryButton(
    buttonText: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isSelected: Boolean = true,
    height: Dp = 45.dp,
    width: Dp = 0.dp,
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant,
            contentColor = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface
        ),
        modifier = modifier
            .defaultMinSize(0.dp, 0.dp)
            .height(height)
            .width(width),
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(
            text = buttonText,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(0.dp),
            color = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
fun SecondaryButton(
    buttonText: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    height: Dp = 45.dp,
    width: Dp = 0.dp,
    onSelected: Boolean = false
) {
    OutlinedButton(
        onClick = onClick,
        border = BorderStroke(
            1.dp,
            if (onSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),
        modifier = modifier
            .defaultMinSize(0.dp, 0.dp)
            .height(height)
            .width(width),
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(
            text = buttonText,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.primary
        )
    }

}
