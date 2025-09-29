package com.example.appcontador

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appcontador.ui.theme.AppContadorTheme
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiPantalla()
            }
        }
    }


@Composable // IMPORTANTE (SIGNIFICA LO QUE VOY A MOSTAR POR PANTALLA)
fun MiPantalla() {
// Estado del contador
    var contador by remember {
        mutableStateOf(0)
    }
// Estado del texto del botón
    var textoBoton by remember {
        mutableStateOf("Incrementa contador")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

// Texto que cambia el label del botón
        Text(
            text = "Pulsa aquí ",
            fontSize = 20.sp,
            modifier = Modifier
                .padding(16.dp)
                .clickable {
                    textoBoton = "Contador: $contador"
                }
        )
// Botón que incrementa el contador
        Button(
            onClick = {
                if (contador < 10) contador += 4 },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (contador >= 10)
                    Color.Red
                else
                    Color.Green
            )
        ) {
            Text(textoBoton)
            textoBoton = "Contador: $contador"
        }
        Spacer(modifier = Modifier.height(20.dp))
        if (contador >= 12) {
            Text("El contador ya ha llegado a 10")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppContadorTheme {
        Greeting("Android")
    }
}

@Composable
fun Greeting(x0: String) {
    TODO("Not yet implemented")
}