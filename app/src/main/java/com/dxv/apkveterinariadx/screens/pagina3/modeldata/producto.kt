package com.dxv.apkveterinariadx.screens.pagina3.modeldata

data class Producto(
    val id: Int,         // Cambiado a tipo Int para reflejar el ID del producto
    val nombre: String,
    val precio: Double,
    val imagen: String
)
data class CarritoItem(
    val producto: Producto,
    var cantidad: Int
)
