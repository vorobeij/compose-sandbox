package com.example.compose_sandboxxx.animations.masks

import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

class CustomShapex : androidx.compose.ui.graphics.Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {

        val path = Path().apply {
            addRoundRect(
                RoundRect(
                    Rect(0f, 0f, size.width, size.height),
                    CornerRadius(200f, 200f)
                )
            )
        }
        return Outline.Generic(path = path)
    }
}