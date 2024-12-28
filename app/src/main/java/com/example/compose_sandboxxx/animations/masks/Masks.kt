package com.example.compose_sandboxxx.animations.masks

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_sandboxxx.R
import com.example.compose_sandboxxx.ui.theme.ComposesandboxxxTheme

@Composable
@Preview(showBackground = true, backgroundColor = 0xFF362B2B)
fun Masks(modifier: Modifier = Modifier) {
    ComposesandboxxxTheme {
        Image(
            painter = painterResource(R.drawable.cat),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )
    }
}
