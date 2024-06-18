package com.dxv.apkveterinariadx.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dxv.apkveterinariadx.R
import com.dxv.apkveterinariadx.navigation.AppScreens
import com.dxv.apkveterinariadx.ui.theme.ApkVeterinariaDxTheme

@Composable
fun Login_index(
//    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: LoginScreenVM = androidx.lifecycle.viewmodel.compose.viewModel(),
) {
    var email by remember { mutableStateOf("example@gmail.com") }
    var password by remember { mutableStateOf("123456") }
    val isButtonEnabled = password.length >= 6
    val buttonColor = colorResource(id = R.color.botoncolor2)
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.secondYellow)
    ) {

        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.3f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.veterinaria_principal3),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
                    ),

                ) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(30.dp),
                    contentAlignment = Alignment.TopEnd
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = "Bienvenido",
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = Color.Black
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            label = { Text("Email") },
                            modifier = Modifier.fillMaxWidth(),
                            placeholder = { Text("") },
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),


                            )

                        Spacer(modifier = Modifier.height(16.dp))

                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
                            label = { Text("Contraseña") },
                            visualTransformation = PasswordVisualTransformation(),
                            modifier = Modifier.fillMaxWidth(),
                            placeholder = { Text("") },
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password)
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        ElevatedButton(
                            onClick = {
                                viewModel.signEmailPassword(email, password) {
//                                    navController.navigate("Login_after1")
                                    navController.navigate(route = AppScreens.MainScreenNav.route)
                                }
                            }, colors = ButtonDefaults.buttonColors(
                                containerColor = buttonColor),
                            modifier = Modifier.fillMaxWidth(),
                            enabled = isButtonEnabled
//                            colors = ButtonDefaults.buttonColors(contentColor = Color(0xFFABDCE3), disabledContentColor = Color(0xFFFFF)  ),
                        ) {
                            Text("Iniciar Sesión", color = Color.Black)
                        }
                    }
                }

            }
        }
    }


}

@Composable
@Preview(showSystemUi = true)
fun DefaultPreviewIndex() {
    val navController = rememberNavController()
    val viewModel = LoginScreenVM()
    ApkVeterinariaDxTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Login_index(navController = navController, viewModel = viewModel)
        }
    }
}
