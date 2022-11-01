package net.jackapp.matmuseumcomp.presentation.theme

import androidx.compose.material.Colors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val DefaultLightThemeColor: Colors
    get() = lightColors(
        primary = Purple40,
        secondary = Color.White,
        secondaryVariant = Color.Black,
        error = Color.Red,
        onPrimary = Color.White,
        onSecondary = Color.Black,
    )

val Colors.ShimmerColor: Color get() = Shimmer
val Colors.ShimmerMidColor: Color get() = Color.White

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
private val Shimmer = Color(0xFFEDF2F6)
