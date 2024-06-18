package com.dxv.apkveterinariadx.screens.pagina3.modeldata

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.dxv.apkveterinariadx.R

@Composable
fun ProductoCard(producto: Producto, onAgregarAlCarrito: (Producto, Int) -> Unit) {
    var cantidad by remember { mutableStateOf(0) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray,
        )

    ) {
        Column(
            modifier = Modifier
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = producto.nombre,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            Image(
                painter = rememberImagePainter(producto.imagen),
                contentDescription = null,
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

            Text(
                text = "S/${producto.precio}",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                modifier = Modifier.padding(vertical = 4.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 4.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_remove_24),
                    contentDescription = "Reducir cantidad",
                    modifier = Modifier.clickable {
                        if (cantidad > 0) cantidad--
                    }
                )
                Text(
                    text = cantidad.toString(),
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.Black),
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "Aumentar cantidad",
                    modifier = Modifier.clickable {
                        cantidad++
                    }
                )
            }
            Spacer(modifier = Modifier.height(4.dp))

            Button(
                onClick = {
                    onAgregarAlCarrito(producto, cantidad)
                },
                modifier = Modifier.padding(top = 4.dp)
            ) {
                Text(text = "Agregar")
            }


        }
    }
}
