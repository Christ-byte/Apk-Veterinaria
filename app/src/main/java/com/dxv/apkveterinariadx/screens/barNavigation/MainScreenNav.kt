package com.dxv.apkveterinariadx.screens.barNavigation

import android.annotation.SuppressLint
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dxv.apkveterinariadx.screens.pagina1.publicanimals
import com.dxv.apkveterinariadx.screens.pagina2.citas
import com.dxv.apkveterinariadx.screens.pagina3.ventas
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.Parabolic
import com.exyte.animatednavbar.animation.indendshape.Height
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius
import com.exyte.animatednavbar.utils.noRippleClickable

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreenNav(
    navController: NavController,
) {
    val navigationBarItems = remember { NavigationBarItems.values() }
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
//        modifier = Modifier.padding(all = 12.dp),
        bottomBar = {
            AnimatedNavigationBar(
                modifier = Modifier.height(64.dp).padding(horizontal = 12.dp).offset(y = (-12).dp),
                selectedIndex = selectedIndex,
                cornerRadius = shapeCornerRadius(cornerRadius = 34.dp),
                ballAnimation = Parabolic(tween(300)),
                indentAnimation = Height(tween(300)),
                barColor = MaterialTheme.colorScheme.primary,
                ballColor = MaterialTheme.colorScheme.primary
            ) {
                navigationBarItems.forEach { item ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .noRippleClickable {
                                selectedIndex = item.ordinal
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = "Boton bar",
                            modifier = Modifier.size(26.dp),
                            tint = if (selectedIndex == item.ordinal) MaterialTheme.colorScheme.onPrimary
                            else MaterialTheme.colorScheme.inversePrimary
                        )
                    }
                }
            }
        },
        content = {
            when (selectedIndex) {
                NavigationBarItems.Home.ordinal -> publicanimals(navController)
                NavigationBarItems.Favorite.ordinal -> citas(navController)
                NavigationBarItems.ShoppingCart.ordinal -> ventas(navController)
            }
        }
    )
}

enum class NavigationBarItems(val icon: ImageVector) {
    Home(icon = Icons.Default.Home),
    Favorite(icon = Icons.Default.Favorite),
    ShoppingCart(icon = Icons.Default.ShoppingCart)

}

fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}