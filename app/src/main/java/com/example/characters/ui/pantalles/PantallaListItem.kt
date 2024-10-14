package com.example.characters.ui.pantalles

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.characters.Model.GuerrersZ
import com.example.characters.R
import com.example.characters.dades.repositoryFake

@OptIn(ExperimentalFoundationApi::class)
@Preview(showSystemUi = true)
@Composable
fun PantallaListItem(guerrersZ: List<GuerrersZ> =
                         repositoryFake.obtenirDadesGuerrersZ(),
                     onClickGuerrersZ: (Int) -> Unit = {})
{
    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        stickyHeader() {
            Text("Llista de guerrersZ",
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.background))
        }
        items(guerrersZ){
            ListItem(modifier = Modifier
                .clickable { onClickGuerrersZ(it.id) }
            ,
                colors = ListItemDefaults.colors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    headlineColor = MaterialTheme.colorScheme.onPrimary,
                    trailingIconColor = MaterialTheme.colorScheme.onPrimary,
                    leadingIconColor = MaterialTheme.colorScheme.background
                ),

                headlineContent = {
                    Text(it.nom,
                        style = MaterialTheme.typography.displaySmall)
                },
                trailingContent = {
                    Text(text = "${it.id}")
                },
                leadingContent = {
                    AsyncImage(
                        model = ImageRequest
                            .Builder(LocalContext.current)
                            .data(it.foto)
                            .crossfade(durationMillis = 2000)
                            .build(),
                        placeholder = painterResource(R.drawable.ic_launcher_foreground),// lo que surt mentre carrega la imatge
                        modifier = Modifier,
//                            .width(50.dp)
//                            .height(50.dp),
                        contentScale = ContentScale.Crop,
                        contentDescription = null)

                }

            )

            HorizontalDivider(
                color = Color.White,
                thickness = 12.dp,
                modifier = Modifier.height(10.dp)
            )
        }
    }
}
