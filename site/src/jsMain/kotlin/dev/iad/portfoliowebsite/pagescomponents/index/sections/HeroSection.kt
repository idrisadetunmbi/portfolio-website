package dev.iad.portfoliowebsite.pagescomponents.index.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.functions.LinearGradient
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.BoxScope
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundImage
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.letterSpacing
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.rotate
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.ArrowForwardIcon
import com.varabyte.kobweb.silk.components.layout.VerticalDivider
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import dev.iad.portfoliowebsite.UncoloredButtonVariant
import dev.iad.portfoliowebsite.components.SocialLinks
import dev.iad.portfoliowebsite.toSitePalette
import dev.iad.portfoliowebsite.widgets.HorizontalSpacer
import dev.iad.portfoliowebsite.widgets.VerticalSpacer
import kotlinx.browser.window
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.SMOOTH
import org.w3c.dom.ScrollBehavior
import org.w3c.dom.ScrollToOptions

@Composable
internal fun HeroSection() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .height(size = 100.vh)
            .fillMaxWidth(),
    ) {
        HeroContent()
        BottomContent()
    }
}

@Composable
private fun BoxScope.BottomContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .align(alignment = Alignment.BottomCenter)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(leftRight = 2.5.cssRem),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            LinksContent()
            LearnMoreButton()
        }
        Box(modifier = Modifier.fillMaxWidth().height(size = 4.cssRem))
    }
}

@Composable
private fun HeroContent() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(leftRight = 3.5.cssRem),
    ) {
        Column {
            SpanText(
                text = "IDRIS ADETUNMBI",
                modifier = Modifier
                    .fontSize(value = 2.5.cssRem)
                    .fontWeight(value = FontWeight.Medium)
                    .letterSpacing(value = .75.cssRem),
            )
            VerticalSpacer(value = 1.25.cssRem)
            SpanText(
                text = "Software Engineer",
                modifier = Modifier
                    .fontSize(value = 1.cssRem)
                    .fontWeight(value = FontWeight.Light)
                    .letterSpacing(value = .167.cssRem),
            )
        }
        Box {
            Image(
                src = "me-hero.png",
                modifier = Modifier.size(size = 36.cssRem),
            )
            Box(
                modifier = Modifier
                    .width(size = 30.cssRem)
                    .fillMaxHeight()
                    .align(alignment = Alignment.TopEnd)
                    .backgroundImage(
                        linearGradient(
                            Color.transparent,
                            Color.black,
                            LinearGradient.Direction.ToRight
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(size = 4.cssRem)
                    .align(alignment = Alignment.BottomCenter)
                    .backgroundImage(
                        linearGradient(
                            Color.transparent,
                            Color.black,
                            LinearGradient.Direction.ToBottom
                        )
                    )
            )
        }
    }
}

@Composable
private fun LinksContent() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .color(color = ColorMode.current.toSitePalette().contentAlt),
    ) {
        VerticalDivider(
            modifier = Modifier
                .height(size = 2.8.cssRem)
                .color(color = ColorMode.current.toSitePalette().contentAlt),
        )
        VerticalSpacer(value = .5.cssRem)
        SocialLinks()
    }
}

@Composable
private fun LearnMoreButton() {
    Button(
        onClick = {
            window.scrollBy(
                options = ScrollToOptions(
                    top = window.innerHeight.toDouble(),
                    behavior = ScrollBehavior.SMOOTH,
                )
            )
        },
        variant = UncoloredButtonVariant,
        modifier = Modifier
            .color(color = ColorMode.current.toSitePalette().content)
            .letterSpacing(value = .25.cssRem)
            .rotate(a = 90.deg)
            .fontSize(value = .75.cssRem)
            .width(size = 0.cssRem),
    ) {
        Row {
            Text(value = "Learn More".uppercase())
            HorizontalSpacer(value = 1.cssRem)
            ArrowForwardIcon()
        }
    }
}
