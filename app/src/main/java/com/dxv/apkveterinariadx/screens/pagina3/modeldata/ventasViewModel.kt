package com.dxv.apkveterinariadx.screens.pagina3.modeldata

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class VentasViewModel : ViewModel() {

    val productos = mutableStateListOf(
        Producto(1, "Adefortex®500/75/50", 39.0, "https://shop.agrovetmarket.com/196-home_default/amoxi-tabs-c-250.jpg"),
        Producto(2, "AMOXI-TABS", 17.1, "https://shop.agrovetmarket.com/196-home_default/amoxi-tabs-c-250.jpg"),
        Producto(3, "Artrosamine®", 109.8, "https://shop.agrovetmarket.com/219-home_default/cani-tabs-daily-multi-senior.jpg"),
        Producto(4, "Pen Duo Strep®", 24.0, "https://shop.agrovetmarket.com/261-home_default/chickvit-b-os.jpg"),
        Producto(5, "ASCORVET", 23.4, "https://shop.agrovetmarket.com/261-home_default/chickvit-b-os.jpg"),
        Producto(6, "AGROGENTA 11 ", 36.0, "https://shop.agrovetmarket.com/537-home_default/marbocine-100.jpg"),
        Producto(7, "ChickVit® ", 11.7, "https://shop.agrovetmarket.com/261-home_default/chickvit-b-os.jpg"),
        Producto(8, "CANI-TABS ", 49.5, "https://shop.agrovetmarket.com/219-home_default/cani-tabs-daily-multi-senior.jpg"),
        Producto(9, "Cani-Tabs® Brain ", 87.3, "https://shop.agrovetmarket.com/15-home_default/cani-tabs-brain-neuro.jpg"),
        Producto(10, "CHICKVIT B OS ", 59.4, "https://shop.agrovetmarket.com/261-home_default/chickvit-b-os.jpg"),
        Producto(11, "Cani-Tabs® +", 67.5, "https://shop.agrovetmarket.com/624-home_default/cani-tabs-calming-relax.jpg"),
        Producto(12, "CHICKVIT ", 63.0, "https://shop.agrovetmarket.com/265-home_default/chickvit-ese-os.jpg"),
        Producto(13, "Aminoplex® ", 20.0, "https://shop.agrovetmarket.com/537-home_default/marbocine-100.jpg"),
        Producto(14, "Cani-Tabs® ", 87.3, "https://shop.agrovetmarket.com/219-home_default/cani-tabs-daily-multi-senior.jpg"),
        Producto(15, "AMINOPLEX LIGHT", 35.0, "https://shop.agrovetmarket.com/537-home_default/marbocine-100.jpg"),
        Producto(16, "Cani-Tabs® Digestive+", 79.2, "https://shop.agrovetmarket.com/235-home_default/cani-tabs-ut-support.jpg"),
        Producto(17, "CANI-TABS HEALTHY", 41.4, "https://shop.agrovetmarket.com/219-home_default/cani-tabs-daily-multi-senior.jpg"),
        Producto(18, "Cani-Tabs® Hip", 82.8, "https://shop.agrovetmarket.com/610-home_default/cani-tabs-skin-coat.jpg"),
        Producto(19, "Hepaviar® OS", 19.8, "https://shop.agrovetmarket.com/261-home_default/chickvit-b-os.jpg"),
        Producto(20, "Cani-Tabs® ", 82.8, "https://shop.agrovetmarket.com/235-home_default/cani-tabs-ut-support.jpg"),
        Producto(21, "Cani-Tabs® Liver+", 70.2, "https://shop.agrovetmarket.com/219-home_default/cani-tabs-daily-multi-senior.jpg"),
        Producto(22, "CANI-TABS ", 82.8, "https://shop.agrovetmarket.com/219-home_default/cani-tabs-daily-multi-senior.jpg"),
        Producto(23, "CANI-TABS ", 53.1, "https://shop.agrovetmarket.com/219-home_default/cani-tabs-daily-multi-senior.jpg"),
        Producto(24, "Cani-Tabs® S+", 65.7, "https://shop.agrovetmarket.com/219-home_default/cani-tabs-daily-multi-senior.jpg"),
        Producto(25, "CANI-TABS DAILY ", 55.8, "https://shop.agrovetmarket.com/219-home_default/cani-tabs-daily-multi-senior.jpg"),
        Producto(26, "CANI-TABS SKIN ", 61.2, "https://shop.agrovetmarket.com/610-home_default/cani-tabs-skin-coat.jpg"),
        Producto(27, "CANI-TABS UT", 93.6, "https://shop.agrovetmarket.com/235-home_default/cani-tabs-ut-support.jpg"),
        Producto(28, "Hematofos B12®", 11.0, "https://shop.agrovetmarket.com/1184-home_default/hematofos-b12.jpg"),
        Producto(29, "CARPRODYL 100 ", 95.4, "https://shop.agrovetmarket.com/537-home_default/marbocine-100.jpg"),
        Producto(30, "HEMOSTOP K ", 40.0, "https://shop.agrovetmarket.com/537-home_default/marbocine-100.jpg")
    )

    private val _carrito = MutableStateFlow<MutableList<CarritoItem>>(mutableListOf())
    val carrito: StateFlow<List<CarritoItem>> = _carrito

    private val _totalCarrito = MutableStateFlow(0.0)
    val totalCarrito: StateFlow<Double> = _totalCarrito

    init {
        // Inicializar el carrito con una lista vacía
        _carrito.value = mutableListOf()
    }

    fun agregarAlCarrito(producto: Producto, cantidad: Int) {
        viewModelScope.launch {
            val itemExistente = _carrito.value.find { it.producto.id == producto.id }
            if (itemExistente != null) {
                // Si el producto ya existe en el carrito, actualizar la cantidad
                itemExistente.cantidad += cantidad
            } else {
                // Si no existe, agregarlo al carrito con la cantidad dada
                _carrito.value.add(CarritoItem(producto, cantidad))
            }
            // Actualizar el total del carrito
            actualizarTotalCarrito()
        }
    }

    private fun actualizarTotalCarrito() {
        // Calcular el total del carrito
        val total = _carrito.value.sumByDouble { it.producto.precio * it.cantidad }
        // Actualizar el estado del total del carrito
        _totalCarrito.value = total
    }
}