package com.example.characters.ui.pantalles

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.characters.Model.GuerrersZ
import com.example.characters.R
import com.example.characters.dades.repositoryFake
import kotlin.random.Random

@Preview(showSystemUi = true)
@Composable
fun CartaBolaDeDrac(
    guerrersZ: List<GuerrersZ> = repositoryFake.obtenirDadesGuerrersZ(),
    onClickGuerrersZ: (Int) -> Unit = {}
) {
    var marvao = "Heroi"
    val personatje = guerrersZ[Random.nextInt(guerrersZ.size)]
    if (!personatje.esEvil) {
        marvao = "Vilà"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(10.dp)
            .background(color = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
                .padding(10.dp)
                .background(color = MaterialTheme.colorScheme.secondaryContainer),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left-aligned text (name)
            Text(
                text = personatje.nom,
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 18.dp),
                textAlign = TextAlign.Left,
                style = TextStyle(fontSize = 20.sp),
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )

            Text(
                text = personatje.id.toString(),
                modifier = Modifier.align(Alignment.CenterVertically),
                textAlign = TextAlign.Right
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.25f)
                .padding(10.dp)
                .background(color = MaterialTheme.colorScheme.secondaryContainer),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left-aligned text (name)
            Text(

                text = marvao,
                modifier = Modifier
                    .weight(1f),
                textAlign = TextAlign.Left,
                style = TextStyle(fontSize = 20.sp),
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
                .padding(10.dp)
                .background(color = MaterialTheme.colorScheme.secondaryContainer),
            verticalAlignment = Alignment.CenterVertically
        ){
            AsyncImage(
                model = ImageRequest
                    .Builder(LocalContext.current)
                    .data(personatje.foto)

                    .crossfade(durationMillis = 2000)
                    .build(),

                placeholder = painterResource(R.drawable.ic_launcher_foreground),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                alignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .border(10.dp, Color.White)

            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
                .padding(10.dp)
                .background(color = MaterialTheme.colorScheme.secondaryContainer),
            verticalAlignment = Alignment.CenterVertically
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Power bar
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 4.dp)
                ) {
                    Text(text = "Power", style = TextStyle(fontSize = 12.sp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(20.dp)
                            .background(Color.LightGray) // Background bar
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(fraction = personatje.unitatsDePoder / 100f)
                                .fillMaxHeight()
                                .background(Color.Red) // Power stat bar
                        )
                    }
                }

                // Defense bar
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 4.dp)
                ) {
                    Text(text = "Defense", style = TextStyle(fontSize = 12.sp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(20.dp)
                            .background(Color.LightGray) // Background bar
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(fraction = personatje.defensa / 100f)
                                .fillMaxHeight()
                                .background(Color.Blue) // Defense stat bar
                        )
                    }
                }

                // Life bar
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 4.dp)
                ) {
                    Text(text = "Life", style = TextStyle(fontSize = 12.sp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(20.dp)
                            .background(Color.LightGray) // Background bar
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(fraction = personatje.vida / 100f)
                                .fillMaxHeight()
                                .background(Color.Green) // Life stat bar
                        )
                    }
                }

                // Another Defense bar (if needed)
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    // Life bar
                    Column(
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        Text(text = "Vida", style = TextStyle(fontSize = 12.sp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(20.dp)
                                .background(Color.LightGray) // Background bar
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(fraction = personatje.vida / 100f)
                                    .fillMaxHeight()
                                    .background(color = MaterialTheme.colorScheme.onPrimaryContainer) // Life stat bar
                            )
                        }
                    }

                    // Power bar
                    Column(
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        Text(text = "Unitats de Poder", style = TextStyle(fontSize = 12.sp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(20.dp)
                                .background(Color.LightGray) // Background bar
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(fraction = personatje.unitatsDePoder / 100f)
                                    .fillMaxHeight()
                                    .background(color = MaterialTheme.colorScheme.onPrimaryContainer) // Life stat bar
                            )
                        }
                    }

                    // Defense bar
                    Column(
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        Text(text = "Defensa", style = TextStyle(fontSize = 12.sp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(20.dp)
                                .background(Color.LightGray) // Background bar
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(fraction = personatje.defensa / 100f)
                                    .fillMaxHeight()
                                    .background(color = MaterialTheme.colorScheme.onPrimaryContainer) // Life stat bar
                            )
                        }
                    }

                    // Speed bar
                    Column(
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        Text(text = "Velocitat", style = TextStyle(fontSize = 12.sp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(20.dp)
                                .background(Color.LightGray) // Background bar
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(fraction = personatje.velocitat / 100f)
                                    .fillMaxHeight()
                                    .background(color = MaterialTheme.colorScheme.onPrimaryContainer) // Life stat bar
                            )
                        }
                    }
                }
            }
        }
    }
}
