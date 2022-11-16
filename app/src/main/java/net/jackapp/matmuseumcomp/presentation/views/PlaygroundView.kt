package net.jackapp.matmuseumcomp.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.ParagraphIntrinsics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.createFontFamilyResolver
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(widthDp = 210)
@Composable
fun PaymentDropDownFieldPreview() {
    PaymentDropDownField(
        label = "Select a payment method",
        prefix = "Master Master Master ",
        suffix = "*1234 (Default)",
        isExpanded = true
    )
}

@Composable
fun PaymentDropDownField(label: String, prefix: String, suffix: String, isExpanded: Boolean) {
    val prefixWidth = prefix.width().maxIntrinsicWidth
    val prefixWidthDp: Dp = with(LocalDensity.current) { prefixWidth.toDp() }
    val prefixWidthState: MutableState<Dp> = remember { mutableStateOf(prefixWidthDp) }
    val suffixWidthDp: Dp = 110.dp

    BoxWithConstraints(
        modifier = Modifier
            .background(
                color = Color.Black.copy(alpha = 0.2f),
                shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
            )
            .width(420.dp)
            .padding(12.dp),
    ) {
        Column(modifier = Modifier.background(Color.Gray)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Red),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f, false)
                ) {
                    Text(
                        text = label,
                        color = Color.Black.copy(alpha = 0.6f)
                    )
                    BoxWithConstraints {
                        val boxWidth = this.maxWidth
                        if (boxWidth < prefixWidthDp + suffixWidthDp) {
                            prefixWidthState.value = boxWidth - suffixWidthDp
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.Yellow),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                modifier = Modifier.width(prefixWidthState.value),
                                text = prefix,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                            )
                            Text(
                                modifier = Modifier.width(suffixWidthDp),
                                text = suffix,
                                maxLines = 1
                            )
                        }
                    }
                }
                IconButton(
                    modifier = Modifier.padding(6.dp),
                    onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "",
                        modifier = Modifier,
                        tint = Color.Black.copy(alpha = .6f),
                    )
                }
            }
            Divider(color = Color.Black.copy(alpha = .6f))
        }
    }
}

@Composable
private fun String.width(): ParagraphIntrinsics {
    return ParagraphIntrinsics(
        text = this,
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 80.sp,
            textAlign = TextAlign.Center
        ),
        density = LocalDensity.current,
        fontFamilyResolver = createFontFamilyResolver(LocalContext.current)
    )
}
