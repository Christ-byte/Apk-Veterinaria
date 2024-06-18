package com.dxv.apkveterinariadx.navigation

sealed class AppScreens(val route: String){
    object Login_after1: AppScreens("Login_after1")
    object Login_after2: AppScreens("Login_after2")
    object Login_index: AppScreens("Login_index")
    object MainScreenNav: AppScreens("MainScreenNav")
    object publicanimals: AppScreens("publicanimals")
    object citas: AppScreens("citas")
    object ventas: AppScreens("ventas")
    object homepost: AppScreens("homepost")
    object pets: AppScreens("pets")
    object addpost: AppScreens("addpost")

    object ConsultaScreen: AppScreens("ConsultaScreen")
}
