package com.dxv.apkveterinariadx.presentacion.process.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.dxv.apkveterinariadx.R
import com.dxv.apkveterinariadx.presentacion.process.Pagina
import com.dxv.apkveterinariadx.presentacion.process.compontes.Dimens.MediumPadding1
import com.dxv.apkveterinariadx.presentacion.process.compontes.Dimens.MediumPadding2
import com.dxv.apkveterinariadx.presentacion.process.paginas
import com.dxv.apkveterinariadx.ui.theme.ApkVeterinariaDxTheme

@Composable
fun ProcesoPagina(
    modifier: Modifier = Modifier,
    pagina: Pagina,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
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
            color = colorResource(id = R.color.black),
            textAlign = TextAlign.Center
        )
        Text(
            text = pagina.Descripcion,
            modifier = Modifier.padding(horizontal = MediumPadding2),
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(id = R.color.black)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProcesoPaginaPreview() {
    ApkVeterinariaDxTheme{
        ProcesoPagina(
            pagina = paginas[0]
        )
    }
}


