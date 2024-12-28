package com.example.compose_sandboxxx.animations.masks

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.compose_sandboxxx.R
import com.example.compose_sandboxxx.ui.theme.ComposesandboxxxTheme

@Composable
fun Avatar(
    strokeWidth: Float,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val stroke = remember {
        Stroke(width = strokeWidth)
    }
    Box(
        modifier = modifier
            .drawWithContent {
                drawContent()
                drawCircle(
                    color = Color.Black,
                    radius = size.minDimension / 2,
                    center = size.center,
                    style = stroke,
                    blendMode = BlendMode.Clear
                )
            }
            .clip(CircleShape)
    ) {
        content.invoke()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF00745C)
@Composable
private fun AvatarPreview() {

    ComposesandboxxxTheme {
        var offset = 0.dp
        val size = 200.dp
        Box(
            modifier = Modifier
                .size(size * 5, size * 1.4f)
                .drawWithContent {
                    drawContent()
                    drawRect(
                        brush = Brush.verticalGradient(listOf(Color.Black, Color.Transparent)),
                        blendMode = BlendMode.DstIn
                    )
                }
                .graphicsLayer {
                    compositingStrategy = CompositingStrategy.Offscreen
                }
                .padding(20.dp)
        ) {
            (1..5).forEach {
                Avatar(strokeWidth = 30f, modifier = Modifier.offset(offset)) {
                    Image(
                        painter = painterResource(R.drawable.cat),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(200.dp)
                    )
                }
                offset += size / 2
            }
        }
    }
}
