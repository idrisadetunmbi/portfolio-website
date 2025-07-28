package dev.iad.portfoliowebsite.pagescomponents.index.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.letterSpacing
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.textTransform
import com.varabyte.kobweb.compose.ui.modifiers.whiteSpace
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.HorizontalDivider
import com.varabyte.kobweb.silk.components.text.SpanText
import dev.iad.portfoliowebsite.components.SocialLinks
import dev.iad.portfoliowebsite.widgets.VerticalSpacer
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.vh

private const val HEADLINE_TEXT =
    "Software Engineer with 7+ Years of Experience Contributing to Cross-Functional Product Success \n\n"

private const val SUBHEADLINE_TEXT =
    "Skilled in collaborating with product, backend, and data teams to build user-centric solutions that meet business goals—proven across diverse industries and teams."

@Composable
internal fun AboutMeSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(size = 100.vh),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            src = "idris-adetunmbi.jpg",
            width = 200,
            height = 200,
            modifier = Modifier
                .borderRadius(r = 100.percent)
                .objectFit(objectFit = ObjectFit.Cover),
        )
        VerticalSpacer(value = 2.cssRem)
        SpanText(
            text = "IDRIS ADETUNMBI",
            modifier = Modifier
                .fontSize(value = 1.75.cssRem)
                .fontWeight(value = FontWeight.Medium)
                .letterSpacing(value = .375.cssRem)
                .textAlign(textAlign = TextAlign.Center)
                .padding(leftRight = 1.cssRem),
        )
        VerticalSpacer(value = 2.cssRem)
        SpanText(
            text = "about me",
            modifier = Modifier
                .textTransform(textTransform = TextTransform.Uppercase)
                .fontSize(value = .75.cssRem)
                .letterSpacing(value = .125.cssRem)
        )
        VerticalSpacer(value = 1.cssRem)
        HorizontalDivider(modifier = Modifier.width(size = 1.5.cssRem))
        VerticalSpacer(value = 1.5.cssRem)
        Column(
            modifier = Modifier
                .maxWidth(size = 36.cssRem)
                .textAlign(textAlign = TextAlign.Center)
                .whiteSpace(whiteSpace = WhiteSpace.PreLine)
                .fontWeight(value = FontWeight.Light)
                .padding(leftRight = 1.cssRem),
        ) {
            SpanText(
                text = HEADLINE_TEXT,
                modifier = Modifier.fontSize(value = 1.125.cssRem),
            )
            SpanText(
                text = SUBHEADLINE_TEXT,
                modifier = Modifier.fontSize(value = .875.cssRem),
            )
        }
        VerticalSpacer(value = 2.5.cssRem)
        Row(verticalAlignment = Alignment.CenterVertically) {
            SocialLinks()
        }
    }
}
