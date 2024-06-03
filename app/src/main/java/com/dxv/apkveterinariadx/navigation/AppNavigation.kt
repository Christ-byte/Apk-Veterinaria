package com.dxv.apkveterinariadx.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dxv.apkveterinariadx.screens.barNavigation.MainScreenNav
import com.dxv.apkveterinariadx.screens.login.Login_after1
import com.dxv.apkveterinariadx.screens.login.Login_after2
import com.dxv.apkveterinariadx.screens.login.Login_index
import com.dxv.apkveterinariadx.screens.pagina1.publicanimals
import com.dxv.apkveterinariadx.screens.pagina2.citas
import com.dxv.apkveterinariadx.screens.pagina3.ventas

@Composable
fun AppNavigation() {
val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.Login_after1.route) {
        composable(route = AppScreens.Login_after1.route) {
            Login_after1(navController)
        }
        composable(route = AppScreens.Login_after2.route) {
            Login_after2(navController)
        }
        composable(route = AppScreens.Login_index.route) {
            Login_index(navController)
        }
        composable(route = AppScreens.MainScreenNav.route) {
            MainScreenNav(navController)
        }
        composable(route = AppScreens.publicanimals.route) {
            publicanimals(navController)
        }
        composable(route = AppScreens.citas.route) {
            citas(navController)
        }
        composable(route = AppScreens.ventas.route) {
            ventas(navController)
        }
    }

}