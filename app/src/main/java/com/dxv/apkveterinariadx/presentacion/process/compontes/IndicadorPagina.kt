package com.dxv.apkveterinariadx.presentacion.process.compontes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.dxv.apkveterinariadx.presentacion.process.compontes.Dimens.IndicatorSize

@Composable
fun IndicadorPagina(
    modifier: Modifier = Modifier,
    pageSize: Int,
    selectedPage: Int,
    SelectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = Color.Green
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        repeat(pageSize) { page ->
            Box(
                modifier = Modifier
                    .size(IndicatorSize)
                    .clip(CircleShape)
                    .background(
                        color = if (page == selectedPage) SelectedColor else unselectedColor
                    )
            )
        }

    }
}