package com.example.nehank.chatapp_ui_androidcompose.common_components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp

@Composable
fun ImageComponentDrawable(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    size: Dp,
    tint: Color = Color.Unspecified
) {
    Icon(
        painter = painterResource(id = icon),
        contentDescription = "",
        tint = tint,
        modifier = modifier.size(size)
    )
}

@Composable
fun ImageComponentImageVector(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    size: Dp,
    tint: Color = Color.Unspecified
) {
    Icon(
        imageVector = icon,
        contentDescription = "",
        tint = tint,
        modifier = modifier.size(size)
    )
}