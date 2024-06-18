package com.dxv.apkveterinariadx.screens.login

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dxv.apkveterinariadx.R
import com.dxv.apkveterinariadx.data.paginas
import com.dxv.apkveterinariadx.navigation.AppScreens
import com.dxv.apkveterinariadx.ui.theme.ApkVeterinariaDxTheme

@Composable
fun Login_after1(
    navController: NavController
    // pagina: Pagina,
) {
    val backgroundColor = colorResource(id = R.color.terceroYellow)
    val circleColor = colorResource(id = R.color.secondYellow)
    val textColor = colorResource(id = R.color.black)
    val buttonColor = colorResource(id = R.color.botoncolor2)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = backgroundColor)
    ) {

        Canvas(modifier = Modifier.fillMaxSize()) {
            val canvasWidth = size.width
            val canvasHeight = size.height

            val radius1 = canvasWidth * 0.7f
            val centerX1 = canvasWidth / 2
            val centerY1 = canvasHeight * 0.2f

            val radius2 = canvasWidth * 0.7f
            val centerX2 = canvasWidth * 0.1f
            val centerY2 = canvasHeight * 0.8f

            drawCircle(
                color = circleColor,
                radius = radius1,
                center = Offset(centerX1, centerY1)
            )

            drawCircle(
                color = circleColor,
                radius = radius2,
                center = Offset(centerX2, centerY2)
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f),
                painter = painterResource(id = R.drawable.veterinaria_principal2),
                contentDescription = null,
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(Dimens.MediumPadding1))
            Text(
                text = paginas[0].Titulo,
                modifier = Modifier.padding(horizontal = Dimens.MediumPadding2),
                style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
                color = textColor,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(Dimens.MaximPadding1))
            Text(
                text = paginas[0].Descripcion,
                modifier = Modifier.padding(horizontal = Dimens.MaximPadding1),
                style = MaterialTheme.typography.bodyLarge,
                color = textColor,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                lineHeight = 30.sp
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {

                ElevatedButton(
                    onClick = {
                        navController.navigate(route = AppScreens.Login_after2.route)
                    }, colors = ButtonDefaults.elevatedButtonColors(
                        containerColor = buttonColor
                    ),
                    modifier = Modifier
                        .padding(30.dp)
                        .width(100.dp)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowForward,
                        contentDescription = null,
                        tint = colorResource(id = R.color.black)
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun DefaultPreview1() {
    val navController = rememberNavController()
    ApkVeterinariaDxTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Login_after1(navController)
        }
    }
}



