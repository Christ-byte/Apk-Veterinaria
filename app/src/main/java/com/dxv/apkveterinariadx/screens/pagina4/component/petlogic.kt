package com.dxv.apkveterinariadx.screens.pagina4.component

import androidx.compose.runtime.mutableStateListOf


val petsList = mutableStateListOf<Pet>()

fun addPet(edad: Int, raza: String, nombre: String, typo: String) {
    val id = petsList.size + 1 // Genera un ID único para cada mascota
    val newPet = Pet(id, edad, raza, nombre,typo)
    petsList.add(newPet)
}
//fun updatePet(id: Int, age: Int, breed: String, name: String, photo: String, type: String) {
//    val petToUpdate = petsList.find { it.id == id }
//    petToUpdate?.let {
//        it.age = age
//        it.name = name
//        it.photo = photo
//        it.type = type
//    }
//}
fun deletePet(id: Int) {
    petsList.removeAll { it.id == id }
}