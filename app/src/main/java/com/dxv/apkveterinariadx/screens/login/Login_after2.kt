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
import androidx.compose.material.icons.rounded.ArrowBack
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
import androidx.compose.ui.graphics.Color
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
fun Login_after2(
    navController: NavController
    //modifier: Modifier = Modifier,
    //  pagina: Pagina,
) {

    val buttonColor = colorResource(id = R.color.botoncolor2)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.secondYellow))
    ) {

        Canvas(modifier = Modifier.fillMaxSize()) {
            val canvasWidth = size.width
            val radius = canvasWidth * 0.75f
            val x = canvasWidth / 2
            val y = radius / 2

            drawCircle(
                color = Color.White,
                radius = radius,
                center = Offset(x, y)
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
                painter = painterResource(id = R.drawable.veterinaria_principal),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(Dimens.MediumPadding1))
            Text(
                text = paginas[1].Titulo,
                modifier = Modifier.padding(horizontal = Dimens.MediumPadding2),
                style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
                color = colorResource(id = R.color.black),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(Dimens.MediumPadding2))
            Text(
                text = paginas[1].Descripcion,
                modifier = Modifier.padding(horizontal = Dimens.MediumPadding2),

                color = colorResource(id = R.color.black),
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                lineHeight = 30.sp
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                ElevatedButton(
                    onClick = {
                        navController.popBackStack()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = buttonColor),
                    modifier = Modifier
                        .padding(30.dp)
                        .width(100.dp)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBack,
                        contentDescription = null,
                        tint = colorResource(id = R.color.black)
                    )
                }
                Spacer(modifier = Modifier.width(70.dp))
                ElevatedButton(
                    onClick = {
                        navController.navigate(route = AppScreens.Login_index.route)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = buttonColor),
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
fun DefaultPreview2() {
    val navController = rememberNavController()
    ApkVeterinariaDxTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Login_after2(navController)
        }
    }
}