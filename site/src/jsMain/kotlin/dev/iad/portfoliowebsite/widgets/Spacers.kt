package dev.iad.portfoliowebsite.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.width

@Composable
fun VerticalSpacer(value: CSSLengthOrPercentageNumericValue) {
    Box(modifier = Modifier.height(size = value))
}

@Composable
fun HorizontalSpacer(value: CSSLengthOrPercentageNumericValue) {
    Box(modifier = Modifier.width(size = value))
}
