package com.dxv.apkveterinariadx.screens.pagina2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.dxv.apkveterinariadx.navigation.AppScreens

@Composable
fun citas(navController: NavController) {
    val servicios = listOf(
        Servicio("Consulta", "https://doctoravanevet.com/wp-content/uploads/2020/04/Servicios-vectores-consulta-integral.png"),
        Servicio("Vacunación", "https://img.freepik.com/vector-gratis/ilustracion-vector-concepto-abstracto-clinica-veterinaria-hospital-veterinario-cirugia-servicios-vacunacion-clinica-animales-atencion-medica-mascotas-servicio-veterinario-metafora-abstracta-equipos-diagnostico_335657-1362.jpg"),
        Servicio("Desparasitación", "https://img.freepik.com/vector-gratis/persona-que-da-hueso-ilustracion-vector-plano-perro-propietario-alimentando-mascota-feliz-cuidando-salud-comida-amistad-concepto-animales-domesticos-banner-diseno-sitios-web-o-pagina-web-destino_74855-25254.jpg"),
        Servicio("Cirugía", "https://previews.123rf.com/images/macrovector/macrovector2011/macrovector201100957/159778626-composici%C3%B3n-veterinaria-isom%C3%A9trica-con-vista-a-la-sala-de-cirug%C3%ADa-con-m%C3%A9dicos-en-perros-uniformes-e.jpg"),
        Servicio("Ultrasonido", "https://www.shutterstock.com/image-vector/veterinarians-do-ultrasound-scan-pregnant-260nw-1960120246.jpg"),
        Servicio("Laboratorio Clínico", "https://img.freepik.com/vector-gratis/pequenos-veterinarios-que-examinan-ilustracion-vectorial-plana-perro-medico-tratando-animal-enorme-clinica-veterinaria-cuidando-salud-determinando-diagnostico-hospital-servicio-medico-mascotas-concepto-veterinario_74855-25368.jpg"),
        Servicio("Emergencias 24/7", "https://oncubanews.com/wp-content/uploads/2021/06/WhatsApp-Image-2021-06-29-at-13.19.31.jpeg")
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(bottom = 64.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "Servicios",
                style = MaterialTheme.typography.titleLarge.copy(color = Color.Black),
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                modifier = Modifier.padding(bottom = 26.dp)
            )

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopCenter
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(servicios.size) { index ->
                        val servicio = servicios[index]
                        ServiceCard(servicio = servicio) {
                            if (servicio.nombre == "Consulta") {
                                navController.navigate(route = AppScreens.ConsultaScreen.route)
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServiceCard(servicio: Servicio, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clickable { onClick(  ) },  // Aquí añadimos el evento de clic
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = rememberImagePainter(servicio.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .height(130.dp)
                    .fillMaxWidth()
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Text(
                text = servicio.nombre,
                style = MaterialTheme.typography.bodyLarge.copy(color = Color.White),
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewCitas() {
    val navController = rememberNavController()
    citas(navController = navController)
}