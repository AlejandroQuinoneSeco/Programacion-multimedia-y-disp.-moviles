package com.example.botonconjeckpackcompose

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.botonconjeckpackcompose.ui.theme.BotonConJeckpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            myButtonComposable()
        }
    }
}

@Composable
fun myButtonComposable(){

    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {

    val context = LocalContext.current
    Button(onClick = {
        Toast.makeText(context, "Se ha presionado el botón correctamente", Toast.LENGTH_SHORT).show()
    }) { Text ("Botón Composable")}
}}