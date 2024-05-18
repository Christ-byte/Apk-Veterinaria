package com.dxv.apkveterinariadx.presentacion.process.screens

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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dxv.apkveterinariadx.R
import com.dxv.apkveterinariadx.presentacion.process.compontes.Dimens

@Composable
fun LoginPagina(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val bottomColor = colorResource(id = R.color.principalYellow)
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomStart
    ) {
        //Canvas como fondo
        Canvas(modifier = Modifier.fillMaxSize()) {
            val width = size.width
            val height = size.height

            // Dibuja rectangulo
            drawRect(
                color = bottomColor,
                size = Size(width, height)
            )

            val cornerRadius = 120f
            val rectHeight = height - height/2 + height/8 // Altura del rectángulo (mitad de la altura del canvas)
            val rectWidth = width

            val horizontalSeparation = Path().apply {
                moveTo(0f, height)
                lineTo(0f, height - rectHeight + cornerRadius)
                arcTo(
                    rect = Rect(0f, height - rectHeight, cornerRadius * 2, height - rectHeight + cornerRadius * 2),
                    startAngleDegrees = 180f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )
                lineTo(rectWidth - cornerRadius, height - rectHeight)
                arcTo(
                    rect = Rect(rectWidth - cornerRadius * 2, height - rectHeight, rectWidth, height - rectHeight + cornerRadius * 2),
                    startAngleDegrees = -90f,
                    sweepAngleDegrees = 90f,
                    forceMoveTo = false
                )
                lineTo(rectWidth, height)
                close()
            }

            // Recorta
            clipPath(horizontalSeparation) {
                // Dibuja rectangulo
                drawRect(
                    color = Color.White,
                    size = Size(width, height)
                )
            }
        }
        // Columna que contiene la imagen y el texto
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Bienvenido",
                modifier = Modifier.padding(horizontal = Dimens.MediumPadding2),
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
                color = colorResource(id = R.color.gray),
                textAlign = TextAlign.Center
            )
            Text(
                text = "Email",
                modifier = Modifier.padding(horizontal = Dimens.MediumPadding2),
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.gray),
                textAlign = TextAlign.Left
            )
            

            //Boton Ingresar
            ElevatedButton(
                onClick = {},
                modifier = Modifier
                    .padding(vertical = Dimens.MaximPadding1, horizontal = Dimens.MaximPadding2)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.gray)), // Personalizar el color de fondo del botón
                contentPadding = PaddingValues(vertical = Dimens.MediumPadding1)
            ) {
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
fun LoginPaginaPreview(){
    LoginPagina(navController = rememberNavController())
}