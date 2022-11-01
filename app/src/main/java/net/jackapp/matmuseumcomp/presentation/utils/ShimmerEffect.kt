package net.jackapp.matmuseumcomp.presentation.utils

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import net.jackapp.matmuseumcomp.presentation.theme.ShimmerColor
import net.jackapp.matmuseumcomp.presentation.theme.ShimmerMidColor
import net.jackapp.matmuseumcomp.presentation.theme.themeColor

@Composable
fun ShimmerView() {
    val contentWidth: MutableState<Dp> = remember { mutableStateOf(0.dp) }
    val localDensity = LocalDensity.current


    Box(modifier = Modifier.animateContentSize()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .onGloballyPositioned { coordinates ->
                    contentWidth.value = with(localDensity) { coordinates.size.width.toDp() }
                },
            elevation = 4.dp
        ) {
            PaymentAmountShimmer(contentWidth = contentWidth)
        }
    }
}

@Composable
private fun PaymentAmountShimmer(
    contentWidth: MutableState<Dp>,
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        ShimmerAnimLine(width = contentWidth.value, height = 24.dp)
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ShimmerAnimLine(width = contentWidth.value / 3, height = 12.dp)
            ShimmerAnimLine(width = contentWidth.value / 4, height = 12.dp)
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ShimmerAnimLine(width = contentWidth.value / 3, height = 12.dp)
            ShimmerAnimLine(width = contentWidth.value / 4, height = 12.dp)
        }
        Spacer(modifier = Modifier.height(12.dp))
        ShimmerAnimLine(width = contentWidth.value / 2, height = 24.dp)
    }
}


@Composable
fun ShimmerAnimLine(width: Dp, height: Dp) {
    ShimmerAnimation(width) {
        Spacer(
            modifier = Modifier
                .width(width)
                .height(height)
                .background(
                    brush = it,
                    shape = RoundedCornerShape(8.dp)
                )
        )
    }
}

@Composable
private fun ShimmerAnimation(width: Dp, content: @Composable (Brush) -> Unit) {
    val widthFloat = with(LocalDensity.current) { width.toPx() }
    val transition = rememberInfiniteTransition()
    val translateAnimation by transition.animateFloat(
        initialValue = 0f,
        targetValue = widthFloat,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 2000, easing = FastOutLinearInEasing)
        )
    )

    val shimmerColorShades = listOf(
        themeColor.ShimmerColor,
        themeColor.ShimmerMidColor,
        themeColor.ShimmerColor,
    )
    val brush = Brush.linearGradient(
        colors = shimmerColorShades,
        start = Offset(0f, 0f),
        end = Offset(translateAnimation * 4, translateAnimation)
    )

    content(brush)
}