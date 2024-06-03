package com.dxv.apkveterinariadx.data

import androidx.annotation.DrawableRes
import com.dxv.apkveterinariadx.R

data class Pagina(
    val Titulo: String,
    val Descripcion: String,
    @DrawableRes val Imagen: Int

)

val paginas = listOf(
    Pagina(
        Titulo = "DXVeterinary",
        Descripcion = "La mejor veterinaria de la ciudad",
        Imagen = R.drawable.veterinaria_principal
    ),
    Pagina(
        Titulo = "Nuestro Compromiso",
        Descripcion = "Cuidamos a tus mascotas con amor y profesionalismo",
        Imagen = R.drawable.veterinaria_principal2
    )
)