package com.dxv.apkveterinariadx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import com.dxv.apkveterinariadx.presentacion.process.OnboardingScreen
import com.dxv.apkveterinariadx.ui.theme.ApkVeterinariaDxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApkVeterinariaDxTheme {
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)){
                    OnboardingScreen()

                }
            }
        }
    }
}

/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
*/
