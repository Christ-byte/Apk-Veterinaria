package com.dxv.apkveterinariadx.screens.pagina1.component

import com.google.firebase.Timestamp

data class Post(
    val Titulo: String = "",
    val content: String = "",
    val image: String = "",
    val timestamp: Timestamp? = null,
    val userID: String = "",
    val userName: String = ""
)
