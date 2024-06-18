package com.dxv.apkveterinariadx.screens.pagina2

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dxv.apkveterinariadx.screens.pagina3.modeldata.CarritoScreen
import com.dxv.apkveterinariadx.screens.pagina3.modeldata.ProductoCard
import com.dxv.apkveterinariadx.screens.pagina3.modeldata.VentasViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ventas(navController: NavController, ventasViewModel: VentasViewModel = viewModel()) {
    var mostrarCarritoDialog by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(bottom = 64.dp)
    ) {
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = { mostrarCarritoDialog = true },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.ShoppingCart,
                        contentDescription = "carrito",
                        tint = Color.Black,
                    )
                }

                Text(
                    text = "Productos disponibles",
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 16.dp, horizontal = 14.dp).align(Alignment.CenterVertically)
                )
            }



            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(ventasViewModel.productos.size) { index ->
                    val producto = ventasViewModel.productos[index]
                    ProductoCard(producto = producto) { prod, cantidad ->
                        ventasViewModel.agregarAlCarrito(prod, cantidad)
                    }
                }
            }
        }

        if (mostrarCarritoDialog) {
            CarritoScreen(
                ventasViewModel = ventasViewModel,
                onDismiss = { mostrarCarritoDialog = false }
            )
        }
    }
}

//@Composable
//fun CarritoDialog(
//    ventasViewModel: VentasViewModel,
//    onDismiss: () -> Unit
//) {
//    val carrito by ventasViewModel.carrito.collectAsState()
//    val totalCarrito = ventasViewModel.totalCarrito.collectAsState().value
//
//    AlertDialog(
//        onDismissRequest = { onDismiss() },
//        title = {
//            Text(text = "Carrito de compras")
//        },
//        text = {
//            Column {
//                carrito.forEach { item ->
//                    Text(
//                        text = "${item.producto.nombre} - ${item.cantidad} x S/${item.producto.precio}",
//                        color = Color.Gray,
//                        modifier = Modifier.padding(bottom = 8.dp)
//                    )
//                }
//
//                Text(
//                    text = "Total: $$totalCarrito",
//                    color = Color.Blue,
//                    modifier = Modifier.padding(top = 8.dp)
//                )
//            }
//        },
//        confirmButton = {
//            ElevatedButton(
//                onClick = { onDismiss() },
//                colors = ButtonDefaults.buttonColors(contentColor = Color.White),
//                content = { Text("Cerrar") }
//            )
//        },
//        dismissButton = {
//            Text("Pagar", modifier = Modifier.padding(end = 8.dp))
//            IconButton(onClick = { onDismiss() }) {
//                Icon(Icons.Default.Check, contentDescription = "Pagar")
//            }
//        }
//    )
//}

@Preview(showSystemUi = true)
@Composable
fun PreviewVentas() {
    val navController = rememberNavController()
    ventas(navController = navController)
}