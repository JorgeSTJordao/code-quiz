package com.masterjorge.codequiz.presentation.components

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity


//https://www.youtube.com/watch?v=xakNOVaYLAg&t=491s

@Composable
fun LoadingAnimation(){

    val circles = listOf(
        remember { Animatable(initialValue = 0f) },
        remember { Animatable(initialValue = 0f) },
        remember { Animatable(initialValue = 0f) }
    )

    val circleValues = circles.map { it.value }
    /*val distance = with(LocalDensity.current) { travelDistance.toPx() }

    Row(
        modifier = Modifier
            .fillMaxSize()
    ) {
        circleValues.forEachIndexed { index, value ->
            Box(modifier = Modifier
                .size(circleSize)
                .graphicsLayer
            ){
                translationY = -value * distance
            }
        }
    }*/
}