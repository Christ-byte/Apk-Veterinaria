package com.dxv.apkveterinariadx.screens.pagina3.modeldata

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarritoScreen(
    ventasViewModel: VentasViewModel,
    onDismiss: () -> Unit
) {
    val carrito by ventasViewModel.carrito.collectAsState()
    val totalCarrito = ventasViewModel.totalCarrito.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Carrito de compras") },
                navigationIcon = {
                    IconButton(onClick = { onDismiss() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Spacer(modifier = Modifier.height(35.dp))
                LazyColumn(
                    modifier = Modifier.weight(1f)
                ) {
                    items(carrito) { item ->
                        CarritoItem(item = item)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Total: S/${String.format("%.2f", totalCarrito)}",
                    color = Color.Blue,
                    style = MaterialTheme.typography.bodyMedium
                )


                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Button(
                        onClick = { /* Implementar lógica para pagar */ },
                        colors = ButtonDefaults.buttonColors(),
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Text("Pagar", color = Color.White)
                    }
                }
            }
        }
    )
}

@Composable
private fun CarritoItem(item: CarritoItem) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .height(48.dp)
                .width(48.dp) // Fija el tamaño del Box para la imagen
                .clip(CircleShape)
        ) {
            Image(
                painter = rememberImagePainter(item.producto.imagen),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        Column(
            modifier = Modifier.weight(1f) // Toma el espacio restante
        ) {
            Text(
                text = item.producto.nombre,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(4.dp)) // Espacio entre el nombre y la cantidad

            Text(
                text = "Cantidad: ${item.cantidad}",
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "Total: S/${String.format("%.2f", item.cantidad * item.producto.precio)}",
                style = MaterialTheme.typography.bodyMedium
            )

        }
//
//        IconButton(
//            onClick = { /* Implementar lógica para eliminar */ },
//            modifier = Modifier.align(Alignment.CenterVertically)
//        ) {
//            Icon(Icons.Default.Delete, contentDescription = "Eliminar")
//        }
        Icon(

            modifier = Modifier.align(Alignment.CenterVertically),
            imageVector = Icons.Default.Delete,
            contentDescription = "Eliminar",
            tint = MaterialTheme.colorScheme.error
        )
    }
}

