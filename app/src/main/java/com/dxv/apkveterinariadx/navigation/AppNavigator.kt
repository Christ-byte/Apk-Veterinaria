package com.dxv.apkveterinariadx.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dxv.apkveterinariadx.presentacion.process.screens.LoginPagina

import com.dxv.apkveterinariadx.presentacion.process.screens.ProcesoPagina

@Composable
fun AppNavigator() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "proceso_pagina") {
        composable("proceso_pagina") {
            ProcesoPagina(navController = navController)
        }
        composable("login-pagina") {
            LoginPagina(navController = navController)
        }
        // Aquí puedes agregar más rutas según sea necesario
        // Ejemplo: composable("product_list") { ProductListPage(navController = navController) }
        // Ejemplo: composable("service_reservation") { ServiceReservationPage(navController = navController) }
    }
}