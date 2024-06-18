package com.dxv.apkveterinariadx.screens.pagina4

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.dxv.apkveterinariadx.screens.pagina4.component.addPet
import com.dxv.apkveterinariadx.screens.pagina4.component.deletePet
import com.dxv.apkveterinariadx.screens.pagina4.component.petsList

@Composable
fun pets(navController: NavController) {
    var edad by remember { mutableStateOf("") }
    var raza by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var typo by remember { mutableStateOf("") }
    var photoUrl by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.TopStart
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.TopStart)
                .fillMaxWidth()
        ) {


            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            ) {
                OutlinedTextField(
                    value = edad, onValueChange = { edad = it }, label = { Text("Edad") })
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = raza, onValueChange = { raza = it }, label = { Text("Raza") })
                Spacer(
                    modifier = Modifier.height(8.dp)
                )
                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    label = { Text("Nombre") })
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = typo, onValueChange = { typo = it }, label = { Text("Tipo") })
                Spacer(modifier = Modifier.height(8.dp))
                ElevatedButton(
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                    onClick = { addPet(edad.toInt(), raza, nombre, typo) }
                ) {
                    Text("Agregar Mascota")
                }

            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(petsList) { pet ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(80.dp)
                                    .clip(CircleShape)
                                    .background(Color.Gray)
                            ) {
                                Image(
                                    painter = rememberImagePainter("https://i.pinimg.com/736x/15/c1/ec/15c1ec0f3beb08c3587d65462fd0fc7a.jpg"),
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .padding(start = 16.dp)
                                    .weight(1f)
                            ) {
                                Text(
                                    text = pet.nombre,
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = "Raza: ${pet.raza}",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Text(
                                    text = "Tipo: ${pet.typo}",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Text(
                                    text = "Edad: ${pet.edad} años",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                            IconButton(
                                onClick = { deletePet(pet.id) },
                                modifier = Modifier.align(Alignment.CenterVertically)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "Eliminar",
                                    tint = MaterialTheme.colorScheme.error
                                )
                            }
                        }
                    }
                    Divider()
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewPets() {
    val navController = rememberNavController()
    pets(navController = navController)
}
