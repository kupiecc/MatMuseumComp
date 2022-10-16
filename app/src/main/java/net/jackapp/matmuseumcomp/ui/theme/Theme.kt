package net.jackapp.matmuseumcomp.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val LightColorScheme = Colors(
    primary = Purple40,
    secondary = PurpleGrey40,

    background = Color(0xFFFFFBFE),
    surface = Color(0xFF6650A3),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),

    primaryVariant = Color.White,
    secondaryVariant = Color.Black,
    error = Color.Red,
    onError = Color.White,
    isLight = true
)

@Composable
fun MatMuseumCompTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = LightColorScheme,
    ) {
        content()
    }
}