package com.example.bajuku.ui.screen.onboarding.Components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun InterestsItemButton(
    text: String,
    onclick: () -> Unit,
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    image: Int

) {
    OutlinedButton(
        onClick = onclick,
        contentPadding = PaddingValues(horizontal = 15.dp),

        modifier = modifier,
        border = BorderStroke(
            1.dp,
            if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.surfaceVariant
        ),
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = text
        )

        Spacer(modifier = Modifier.width(8.dp)) // horizontal spacing
        Text(text = text)
    }
}
