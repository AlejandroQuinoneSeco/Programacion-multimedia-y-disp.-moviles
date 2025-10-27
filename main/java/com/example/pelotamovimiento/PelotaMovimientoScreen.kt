package com.example.pelotamovimiento


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt
import kotlinx.coroutines.delay

@Composable
fun PelotaMovimientoScreen(
    xAcc: Float,
    yAcc: Float,
    zAcc: Float
) {
    // Estado para tamaño de pantalla
    var parentWidth by remember { mutableStateOf(0) }
    var parentHeight by remember { mutableStateOf(0) }

    // Tamaño de la imagen
    val imageSize = 80.dp
    val imageSizePx = with(LocalDensity.current) { imageSize.toPx() }

    // Estados de posición y velocidad
    var posX by remember { mutableStateOf(0f) }
    var posY by remember { mutableStateOf(0f) }

    var velX by remember { mutableStateOf(0f) }
    var velY by remember { mutableStateOf(0f) }

    val friction = 0.98f // para que no se descontrole la velocidad
    val accelFactor = 2.0f // sensibilidad

    LaunchedEffect(Unit) {
        while (true) {
            // Aplicar aceleración como cambio en velocidad
            velX += -xAcc * accelFactor
            velY += yAcc * accelFactor

            // Aplicar fricción
            velX *= friction
            velY *= friction

            // Actualizar posición
            posX += velX
            posY += velY

            // Rebotar en bordes
            if (posX < 0) {
                posX = 0f
                velX *= -0.5f
            } else if (posX > parentWidth - imageSizePx) {
                posX = parentWidth - imageSizePx
                velX *= -0.5f
            }

            if (posY < 0) {
                posY = 0f
                velY *= -0.5f
            } else if (posY > parentHeight - imageSizePx) {
                posY = parentHeight - imageSizePx
                velY *= -0.5f
            }

            delay(16L) // ~60 FPS
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .onSizeChanged {
                parentWidth = it.width
                parentHeight = it.height
            }
    ) {
        Image(
            painter = painterResource(id = R.drawable.pelota),
            contentDescription = "Pelota",
            modifier = Modifier
                .size(imageSize)
                .offset {
                    IntOffset(
                        posX.roundToInt(),
                        posY.roundToInt()
                    )
                }
        )

        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(16.dp)
        ) {
            Text("X: ${"%.2f".format(xAcc)}")
            Text("Y: ${"%.2f".format(yAcc)}")
            Text("Z: ${"%.2f".format(zAcc)}")
        }
    }
}