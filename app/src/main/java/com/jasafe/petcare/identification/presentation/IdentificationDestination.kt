package com.jasafe.petcare.identification.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.jasafe.petcare.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IdentificationDestination(
    modifier: Modifier = Modifier,
    onOpenDrawerState: () -> Unit
) {

    var name by remember { mutableStateOf("") }
    var race by remember { mutableStateOf("") }
    var eyesColor by remember { mutableStateOf("") }

    val image = ImageRequest.Builder(LocalContext.current)
        .data(R.raw.perro)
        .crossfade(true)
        .build()



    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text("Perfil") },
                navigationIcon = {
                    IconButton(onClick = { onOpenDrawerState() }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Toggle drawer"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(300.dp)
                    .clip(RoundedCornerShape(16.dp)),
                model = image,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            HorizontalDivider()

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                singleLine = true,
                label = { Text("Nombre de la mascota") }
            )
            OutlinedTextField(
                value = race,
                onValueChange = { race = it },
                singleLine = true,
                label = { Text("Raza de la mascota") }
            )
            OutlinedTextField(
                value = eyesColor,
                onValueChange = { eyesColor = it },
                singleLine = true,
                label = { Text("Color de ojos") }
            )
        }
    }
}