package com.jasafe.petcare.home.destination

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.jasafe.petcare.R
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("ResourceType", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeDestination(
    navController: NavHostController,
    onOpenDrawerState: () -> Unit
) {
    val pets = listOf(
        Animals(
            name = "Motta",
            imageId = R.raw.perro
        ),
        Animals(
            name = "Mavis Lieben",
            imageId = R.raw.gato
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text("Home") },
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
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("Mascotas",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
            )
            LazyHorizontalStaggeredGrid(
                modifier = Modifier.height(350.dp),
                rows = StaggeredGridCells.Fixed(1),
                horizontalItemSpacing = 16.dp
            ) {
                items(pets){ animal ->
                    OutlinedCard(
                        modifier = Modifier
                            .width(200.dp)
                            .height(220.dp)
                    ) {

                        val image = ImageRequest.Builder(LocalContext.current)
                            .data(animal.imageId)
                            .crossfade(true)
                            .build()

                        Column {
                            AsyncImage(
                                modifier = Modifier
                                    .size(200.dp)
                                    .clip(RoundedCornerShape(16.dp)),
                                model = image,
                                contentDescription = null,
                                contentScale = ContentScale.Crop
                            )

                            Row(
                                modifier = Modifier.padding(16.dp),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Text(text = "Nombre:")
                                Text(text = animal.name)
                            }
                        }
                    }
                }
            }
            Text("Monitoreo",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
            )
            LazyHorizontalGrid(
                rows = GridCells.Fixed(2),
            ) {
                item {
                    Box(
                        modifier = Modifier.size(100.dp)
                            .background(createRandomColor())
                    )
                }
                item {
                    Box(
                        modifier = Modifier.size(100.dp)
                            .background(createRandomColor())
                    )
                }
                item {
                    Box(
                        modifier = Modifier.size(100.dp)
                            .background(createRandomColor())
                    )
                }
                item {
                    Box(
                        modifier = Modifier.size(100.dp)
                            .background(createRandomColor())
                    )
                }
                item {
                    Box(
                        modifier = Modifier.size(100.dp)
                            .background(createRandomColor())
                    )
                }
                item {
                    Box(
                        modifier = Modifier.size(100.dp)
                            .background(createRandomColor())
                    )
                }
            }
        }
    }
}

data class Animals(
    val name: String,
    val imageId: Int,
)

fun createRandomColor() : Color {
    return Color(
        red = Random.nextInt(256),
        green = Random.nextInt(256),
        blue = Random.nextInt(256)
    )
}