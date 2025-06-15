package dev.iad.portfoliowebsite

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.silk.components.forms.ButtonStyle
import com.varabyte.kobweb.silk.style.addVariant
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.compose.ui.graphics.Color as KobwebColor

@Suppress("UnusedReceiverParameter")
fun ColorMode.toSitePalette() = SitePalette(
    background = Color.rgb(value = 0x13171F),
    backgroundAlt = KobwebColor.rgb(r = 16, g = 16, b = 16),
    content = Color.rgb(0xFFFFFF),
    contentAlt = Color.rgb(0x898989),
)

class SitePalette(
    val background: Color,
    val backgroundAlt: Color,
    val content: Color,
    val contentAlt: Color,
)

/* Region Buttons */

val UncoloredButtonVariant = ButtonStyle.addVariant {
    base {
        Modifier
            .backgroundColor(color = Colors.Transparent)
            .color(color = colorMode.toSitePalette().contentAlt)
    }
    hover {
        Modifier
            .backgroundColor(color = Colors.Transparent)
            .color(color = colorMode.toSitePalette().contentAlt)
    }
}

/* endregion */
