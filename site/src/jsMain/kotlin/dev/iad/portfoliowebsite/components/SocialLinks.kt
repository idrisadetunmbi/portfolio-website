package dev.iad.portfoliowebsite.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.silk.components.icons.fa.FaGithub
import com.varabyte.kobweb.silk.components.icons.fa.FaLinkedinIn
import com.varabyte.kobweb.silk.components.icons.fa.FaXTwitter
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import dev.iad.portfoliowebsite.toSitePalette
import dev.iad.portfoliowebsite.widgets.HorizontalSpacer
import org.jetbrains.compose.web.css.cssRem

@Composable
internal fun SocialLinks() {
    Link(
        path = "https://github.com/idrisadetunmbi",
        modifier = Modifier.color(color = ColorMode.current.toSitePalette().contentAlt)
    ) {
        FaGithub()
    }
    HorizontalSpacer(value = .75.cssRem)
    Link(
        path = "https://linkedin.com/in/idris-adetunmbi",
        modifier = Modifier.color(color = ColorMode.current.toSitePalette().contentAlt)
    ) {
        FaLinkedinIn()
    }
    HorizontalSpacer(value = .75.cssRem)
    Link(
        path = "https://x.com/idrisadetunmbi",
        modifier = Modifier.color(color = ColorMode.current.toSitePalette().contentAlt)
    ) {
        FaXTwitter()
    }
}
