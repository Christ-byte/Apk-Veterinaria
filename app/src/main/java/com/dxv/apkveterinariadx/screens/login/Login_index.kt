package com.dxv.apkveterinariadx.screens.login

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
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
import com.dxv.apkveterinariadx.ui.theme.tertiaryContainerLight

@Composable
fun Login_index(
//    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: LoginScreenVM = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val isButtonEnabled = password.length >= 6

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
            ) {


                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .align(Alignment.BottomCenter)
                ) {
                    drawRect(
                        color = Color.White,
                        size = Size(size.width, size.height)
                    )
                }
                Canvas(modifier = Modifier.fillMaxSize()) {

                    drawRoundRect(
                        color = Color.White,
                        topLeft = Offset(0f, 0f),
                        size = Size(size.width, size.height),
                        cornerRadius = CornerRadius(100f)
                    )
                }

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

                        TextField(
                            value = email,
                            onValueChange = { email = it },
                            label = { Text("Email") },
                            modifier = Modifier.fillMaxWidth(),
                            placeholder = { Text("example@gmail.com") },
                            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)


                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        TextField(
                            value = password,
                            onValueChange = { password = it },
                            label = { Text("Contraseña") },
                            visualTransformation = PasswordVisualTransformation(),
                            modifier = Modifier.fillMaxWidth(),
                            placeholder = { Text("123456") },
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
                                containerColor = tertiaryContainerLight
                            ),
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
