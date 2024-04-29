package com.dxv.apkveterinariadx.presentacion.Proces

import android.icu.text.CaseMap.Title
import androidx.annotation.DrawableRes

data class Pagina(
    val Titulo: String,
    val Descripcion:String,
    @DrawableRes val Imagen: Int

)
val paginas = listOf(
    Pagina(
        Titulo = "Bienvenido a VeterinariaDx",
        Descripcion = "La mejor veterinaria de la ciudad",
        Imagen = com.dxv.apkveterinariadx.R.drawable.veterinaria_principal
    ),
)