package dev.iad.portfoliowebsite.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.setVariable
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.style.vars.color.ColorVar
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import dev.iad.portfoliowebsite.toSitePalette
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.Span

@Composable
fun Footer(modifier: Modifier = Modifier) {
    Box(
        modifier = FooterStyle.toModifier().then(other = modifier),
        contentAlignment = Alignment.Center,
    ) {
        Span(attrs = Modifier.textAlign(TextAlign.Center).toAttrs()) {
            val sitePalette = ColorMode.current.toSitePalette()
            SpanText("Built with ")
            Link(
                path = "https://github.com/varabyte/kobweb",
                text = "Kobweb",
                modifier = Modifier.setVariable(variable = ColorVar, value = sitePalette.contentAlt),
                variant = UncoloredLinkVariant
            )
        }
    }
}

val FooterStyle = CssStyle.base {
    Modifier.backgroundColor(colorMode.toSitePalette().background)
        .padding(topBottom = 1.5.cssRem, leftRight = 10.percent)
}
