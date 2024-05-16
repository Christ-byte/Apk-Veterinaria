package com.dxv.apkveterinariadx.presentacion.Proces.compontes

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.dxv.apkveterinariadx.R
import com.dxv.apkveterinariadx.presentacion.Proces.Pagina
import com.dxv.apkveterinariadx.presentacion.Proces.compontes.Dimens.MaximPadding1
import com.dxv.apkveterinariadx.presentacion.Proces.compontes.Dimens.MaximPadding2
import com.dxv.apkveterinariadx.presentacion.Proces.compontes.Dimens.MediumPadding1
import com.dxv.apkveterinariadx.presentacion.Proces.compontes.Dimens.MediumPadding2
import com.dxv.apkveterinariadx.presentacion.Proces.paginas

@Composable
fun ProcesoPagina(
    modifier: Modifier = Modifier,
    pagina: Pagina
) {
    val bottomColor = colorResource(id = R.color.principalYellow)
    // Canvas como fondo
    Box(modifier = modifier) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val width = size.width
            val height = size.height

            // Dibuja el rectángulo blanco en la mitad superior
            drawRect(
                color = Color.White,
                size = Size(width, height)
            )

            // Crea un arco de media luna en la mitad inferior
            val horizontalArc = Path().apply {
                moveTo(0f, height / 2 )
                arcTo(
                    rect = Rect(
                        left = 0f,
                        top = height / 2 - (width / 2),
                        right = width,
                        bottom = height / 2 + (width / 8)
                    ),
                    startAngleDegrees = -180f,
                    sweepAngleDegrees = -180f,
                    forceMoveTo = false
                )
                lineTo(width, height)
                lineTo(0f, height)
                close()
            }

            // Recorta el canvas en un arco media luna
            clipPath(horizontalArc) {
                // Dibujar el rectángulo amarillo en la mitad inferior
                drawRect(
                    color = bottomColor,
                    size = Size(width, height)
                )
            }
        }

        // Columna que contiene la imagen y el texto
        Column(modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f),
                painter = painterResource(id = pagina.Imagen),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(MediumPadding1))
            Text(
                text = pagina.Titulo,
                modifier = Modifier.padding(horizontal = MediumPadding2),
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
                color = colorResource(id = R.color.white),
                textAlign = TextAlign.Center
            )
            Text(
                text = pagina.Descripcion,
                modifier = Modifier.padding(horizontal = MediumPadding2),
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.white)
            )


            //Boton Ingresar
            ElevatedButton(
                onClick = {  },
                modifier = Modifier
                    .padding(vertical = MaximPadding1, horizontal = MaximPadding2)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.gray)), // Personalizar el color de fondo del botón
                contentPadding = PaddingValues(vertical = MediumPadding1)) {
                Text(
                    text = "Ingresar",
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@Preview
@Composable
fun ProcesoPaginaPreview() {
    ProcesoPagina(
        pagina = paginas[0]
    )
}
