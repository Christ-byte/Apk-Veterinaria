package com.dxv.apkveterinariadx

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Surface
import com.dxv.apkveterinariadx.navigation.AppNavigation
import com.dxv.apkveterinariadx.ui.theme.ApkVeterinariaDxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApkVeterinariaDxTheme {
                Surface(color = colorScheme.background) {
                    AppNavigation()
                }
            }
        }
    }
}

//@Composable
//@Preview(showSystemUi = true)
//fun DefaultPreview() {
//    ApkVeterinariaDxTheme {
//        Surface(color = colorScheme.background) {
//            AppNavigation()
//        }
//    }
//}