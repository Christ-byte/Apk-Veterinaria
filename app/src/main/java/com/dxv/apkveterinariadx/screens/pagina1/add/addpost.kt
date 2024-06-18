package com.dxv.apkveterinariadx.screens.pagina1.add

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dxv.apkveterinariadx.navigation.AppScreens
import com.dxv.apkveterinariadx.ui.theme.ApkVeterinariaDxTheme
import com.dxv.apkveterinariadx.ui.theme.tertiaryContainerLight

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun addpost(navController: NavController) {
    var textFieldValue by remember { mutableStateOf("Titulo") }
    var textFieldValue2 by remember { mutableStateOf("Contenido") }

    Scaffold(
        topBar = {

            TopAppBar(
                modifier = Modifier.shadow(3.dp),
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(route = AppScreens.MainScreenNav.route)
                    }) {
                        androidx.compose.material3.Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
                    }
                },
                title = { Text("Agregar Publicación") }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextField(
                value = textFieldValue,
                onValueChange = { newValue ->
                    textFieldValue = newValue
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp, top = 25.dp),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
            )
            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(
                value = textFieldValue2,
                minLines = 4,
                onValueChange = { newValue ->
                    textFieldValue2 = newValue
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp, bottom = 20.dp),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
            )

            ElevatedButton(
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = tertiaryContainerLight
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, end = 30.dp),

                ) {
                Text("Publicar", color = Color.Black)
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun DefaultPost() {
    val navController = rememberNavController()
    ApkVeterinariaDxTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            addpost(navController)
        }
    }
}