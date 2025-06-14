package com.jasafe.petcare.advices.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun AdvicesDestination(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .background(Color.Yellow)
            .fillMaxSize()
    )
}