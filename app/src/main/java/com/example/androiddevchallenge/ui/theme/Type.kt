package io.embry.pawson.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import io.embry.pawson.R

// Set of Material typography styles to start with

val Aromia = FontFamily(
    Font(R.font.aromiabold)
)

val BodyFont = FontFamily(
    Font(R.font.volkorn_semibold)
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = BodyFont,
        fontSize = 16.sp
    ),
    h1 = TextStyle(
        fontFamily = Aromia,
        fontSize = 28.sp
    )
)
val button = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.W500,
    fontSize = 14.sp
)
val caption = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp
)