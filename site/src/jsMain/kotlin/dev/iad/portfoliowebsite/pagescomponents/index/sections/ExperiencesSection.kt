package dev.iad.portfoliowebsite.pagescomponents.index.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.letterSpacing
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textTransform
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.layout.VerticalDivider
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import dev.iad.portfoliowebsite.data.EXPERIENCES
import dev.iad.portfoliowebsite.models.Experience
import dev.iad.portfoliowebsite.pagescomponents.index.components.SectionScaffold
import dev.iad.portfoliowebsite.toSitePalette
import dev.iad.portfoliowebsite.widgets.HorizontalSpacer
import dev.iad.portfoliowebsite.widgets.VerticalSpacer
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent

@Composable
internal fun ExperiencesSection() {
    SectionScaffold(
        title = "experiences",
        backgroundColor = ColorMode.current.toSitePalette().backgroundAlt,
    ) {
        ExperiencesDesktopContent()
        ExperiencesMobileContent()
    }
}

@Composable
private fun ExperiencesDesktopContent() {
    Column(modifier = ExperiencesDesktopStyle.toModifier()) {
        EXPERIENCES.forEachIndexed { index, experienceData ->
            val contentPosition = if (index % 2 == 0) ContentPosition.START else ContentPosition.END
            ExperienceDesktopContentRow(
                contentPosition = contentPosition,
                data = experienceData,
            )
            if (index != EXPERIENCES.lastIndex) {
                ExperienceDivider()
            }
        }
    }
}

@Composable
private fun ExperiencesMobileContent() {
    Column(
        modifier = ExperiencesMobileStyle.toModifier(),
        verticalArrangement = Arrangement.Center,
    ) {
        EXPERIENCES.forEachIndexed { index, experienceData ->
            ExperienceContent(data = experienceData)
            if (index != EXPERIENCES.lastIndex) {
                VerticalSpacer(value = 3.cssRem)
            }
        }
    }
}

@Composable
private fun ExperienceDesktopContentRow(
    contentPosition: ContentPosition,
    data: Experience,
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(leftRight = 4.cssRem),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (contentPosition == ContentPosition.START) ExperienceContent(data = data)
        else HorizontalSpacer(value = 40.percent)

        ExperienceDesktopDateContent(start = data.start, end = data.end)

        if (contentPosition == ContentPosition.END) ExperienceContent(data = data)
        else HorizontalSpacer(value = 40.percent)
    }
}

@Composable
private fun ExperienceContent(data: Experience) {
    Column(modifier = ExperienceContentStyle.toModifier()) {
        SpanText(
            text = data.company,
            modifier = Modifier
                .textTransform(textTransform = TextTransform.Uppercase)
                .letterSpacing(value = .125.cssRem)
                .fontSize(value = .875.cssRem),
        )
        VerticalSpacer(value = .25.cssRem)
        SpanText(
            text = data.position,
            modifier = Modifier
                .letterSpacing(value = .0625.cssRem)
                .color(color = ColorMode.current.toSitePalette().contentAlt)
        )
        VerticalSpacer(value = .25.cssRem)
        ExperienceMobileDateContent(start = data.start, end = data.end)
        SpanText(
            text = data.summary,
            modifier = Modifier.fontSize(value = .875.cssRem),
        )
    }
}

@Composable
private fun ExperienceDesktopDateContent(
    start: String,
    end: String,
) {
    Box(
        modifier = Modifier
            .size(size = 8.75.cssRem)
            .backgroundColor(color = Color.white)
            .color(color = Color.black)
            .borderRadius(r = 100.percent),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fontWeight(value = FontWeight.Light)
                .textTransform(textTransform = TextTransform.Uppercase)
                .fontSize(value = .85.cssRem)
                .letterSpacing(value = .175.cssRem)
        ) {
            SpanText(text = end)
            SpanText(text = "-")
            SpanText(text = start)
        }
    }
}

@Composable
private fun ExperienceMobileDateContent(
    start: String,
    end: String,
) {
    Column(modifier = ExperienceMobileDateContentStyle.toModifier()) {
        Row(
            modifier = Modifier
                .fontWeight(value = FontWeight.Light)
                .textTransform(textTransform = TextTransform.Uppercase)
                .fontSize(value = .75.cssRem)
                .letterSpacing(value = .175.cssRem)
        ) {
            SpanText(text = start)
            SpanText(text = "-")
            SpanText(text = end)
        }
        VerticalSpacer(value = .625.cssRem)
    }
}

@Composable
private fun ExperienceDivider() {
    VerticalSpacer(value = .5.cssRem)
    VerticalDivider(
        modifier = Modifier
            .height(size = 6.5.cssRem)
            .color(color = ColorMode.current.toSitePalette().contentAlt),
    )
    VerticalSpacer(value = 1.cssRem)
}

enum class ContentPosition {
    START, END
}

val ExperiencesMobileStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .padding(leftRight = 1.5.cssRem)
            .maxWidth(size = 28.cssRem)
    }
    Breakpoint.MD {
        Modifier.display(value = DisplayStyle.None)
    }
}

val ExperiencesDesktopStyle = CssStyle {
    base {
        Modifier.display(value = DisplayStyle.None)
    }
    Breakpoint.MD {
        Modifier.display(value = DisplayStyle.Flex)
    }
}

val ExperienceContentStyle = CssStyle {
    base {
        Modifier.width(size = 100.percent)
    }
    Breakpoint.MD {
        Modifier.width(size = 40.percent)
    }
}

val ExperienceMobileDateContentStyle = CssStyle {
    base {
        Modifier.display(value = DisplayStyle.Flex)
    }
    Breakpoint.MD {
        Modifier.display(value = DisplayStyle.None)
    }
}
