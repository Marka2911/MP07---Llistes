package com.example.characters.ui.pantalles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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

@Preview(showSystemUi = true)
@Composable
fun GraellaVertical(
    guerrersZ: List<GuerrersZ> =
        repositoryFake.obtenirDadesGuerrersZ(),
    onClickGuerrersZ: (Int) -> Unit = {}
){
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 150.dp),
        modifier = Modifier
            .fillMaxSize()) {
        items(guerrersZ){
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(10.dp)
                    .background(color = MaterialTheme.colorScheme.primaryContainer)



            ) {
                Text(text = it.nom, modifier = Modifier
                    .width(200.dp)
                    ,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,

                    textAlign = TextAlign.Center)
                AsyncImage(
                    model = ImageRequest
                        .Builder(LocalContext.current)
                        .data(it.foto)
                        .crossfade(durationMillis = 2000)
                        .build()
                        ,
                placeholder = painterResource(R.drawable.ic_launcher_foreground),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
    }
}