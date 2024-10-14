package com.example.characters

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.characters.ui.pantalles.CartaBolaDeDrac
import com.example.characters.ui.pantalles.GraellaHorizontal
import com.example.characters.ui.pantalles.GraellaVertical
import com.example.characters.ui.pantalles.PantallaListItem
import com.example.characters.ui.pantalles.PantallaListItem
import com.example.characters.ui.theme.CharactersTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CharactersTheme {

                CartaBolaDeDrac()

            }
        }
    }
}
