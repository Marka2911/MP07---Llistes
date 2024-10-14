package com.example.characters.ui.pantalles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.characters.Model.GuerrersZ
import com.example.characters.R
import com.example.characters.dades.repositoryFake

@Preview(showSystemUi = true,
    heightDp = 720,
    widthDp = 1080)
@Composable
fun GraellaHorizontal(guerrersZ: List<GuerrersZ> =
                          repositoryFake.obtenirDadesGuerrersZ(),
                      onClickGuerrersZ: (Int) -> Unit = {})
{
    LazyHorizontalGrid(rows = GridCells.Adaptive(minSize = 200.dp),
        modifier = Modifier
            .fillMaxSize()) {
        items(guerrersZ){
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .height(150.dp)
                .background(color = MaterialTheme.colorScheme.primaryContainer))
            {
                Text(text = it.nom, color = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier
                        .width(200.dp),
                    textAlign = TextAlign.Center)

                AsyncImage(
                    model = ImageRequest
                        .Builder(LocalContext.current)
                        .data(it.foto)
                        .crossfade(durationMillis = 2000)
                        .build(),
                    placeholder = painterResource(R.drawable.ic_launcher_foreground),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    alignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize()

                )
            }
        }
    }

}