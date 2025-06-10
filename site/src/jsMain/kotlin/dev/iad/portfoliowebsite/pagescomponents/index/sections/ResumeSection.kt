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
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.letterSpacing
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textTransform
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.layout.VerticalDivider
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import dev.iad.portfoliowebsite.pagescomponents.index.components.SectionScaffold
import dev.iad.portfoliowebsite.toSitePalette
import dev.iad.portfoliowebsite.widgets.HorizontalSpacer
import dev.iad.portfoliowebsite.widgets.VerticalSpacer
import kotlinx.browser.window
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
internal fun ResumeSection() {
    SectionScaffold(
        title = "resume",
        subtitle = "Companies I've worked with",
        backgroundColor = ColorMode.current.toSitePalette().backgroundAlt,
    ) {
        VerticalSpacer(value = 2.cssRem)
        EXPERIENCES.forEachIndexed { index, experienceData ->
            Experience(
                contentPosition = if (index % 2 == 0) ContentPosition.START else ContentPosition.END,
                data = experienceData,
            )
            if (index != EXPERIENCES.lastIndex) {
                ExperienceDivider()
            }
        }
        VerticalSpacer(value = 4.cssRem)
        Button(
            onClick = {
                window.open(url = "CV.pdf", target = "_blank")
            },
            content = {
                SpanText(text = "Download Full Resume")
            },
            modifier = Modifier
                .backgroundColor(color = Color.transparent)
                .textTransform(textTransform = TextTransform.Uppercase)
                .letterSpacing(value = .0625.cssRem)
                .border(width = 1.px, style = LineStyle.Solid, color = Color.white)
                .fontSize(value = .820.cssRem),
        )
    }
}

@Composable
private fun Experience(
    contentPosition: ContentPosition,
    data: ExperienceData,
) {
    val content = @Composable {
        Column(modifier = Modifier.width(size = 40.percent)) {
            SpanText(
                text = data.company,
                modifier = Modifier
                    .textTransform(textTransform = TextTransform.Uppercase)
                    .letterSpacing(value = .125.cssRem)
                    .fontSize(value = .875.cssRem),
            )
            VerticalSpacer(value = 1.cssRem)
            SpanText(
                text = data.position,
                modifier = Modifier
                    .letterSpacing(value = .0625.cssRem)
                    .color(color = ColorMode.current.toSitePalette().contentAlt)
            )
            VerticalSpacer(value = 1.cssRem)
            SpanText(
                text = data.summary,
                modifier = Modifier.fontSize(value = .875.cssRem),
            )
        }
    }
    Row(
        modifier = Modifier.fillMaxWidth().padding(leftRight = 4.cssRem),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (contentPosition == ContentPosition.START) content()
        else HorizontalSpacer(value = 40.percent)
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
                SpanText(text = data.end)
                SpanText(text = "-")
                SpanText(text = data.start)
            }
        }
        if (contentPosition == ContentPosition.END) content()
        else HorizontalSpacer(value = 40.percent)
    }
}

@Composable
private fun ExperienceDivider() {
    VerticalDivider(
        modifier = Modifier
            .height(size = 6.5.cssRem)
            .color(color = ColorMode.current.toSitePalette().contentAlt),
    )
}

enum class ContentPosition {
    START, END
}

private val EXPERIENCES = listOf(
    ExperienceData(
        company = "trivago",
        position = "Mobile Software Engineer III",
        summary = "Developed and enhanced the trivago hotel search Android app within a cross-functional team, leading tech initiatives and mentoring peers.",
        end = "present",
        start = "2022"
    ),
    ExperienceData(
        company = "Headspace Care",
        position = "Senior Software Engineer",
        summary = "In addition to developing and improving the Ginger Care mobile app, handling features including user and content management, I created and reviewed technical design documents, resolved user issues and enhanced their experiences through journey analysis and logging.",
        end = "2022",
        start = "2021"
    ),
    ExperienceData(
        company = "Autochek Africa",
        position = "Android Engineer",
        summary = "Worked in a startup team to develop and release the Autocheck car marketplace Android app including features as ad-placements/uploads, financing application process, purchase payments, user authentication, etc.",
        end = "2021",
        start = "2020"
    ),
    ExperienceData(
        company = "Andela <> Intentional Futures",
        position = "Software Engineer",
        summary = "Proceeded through the Andela apprenticeship program to work with Intentional Futures developing multiple web and full-stack projects.",
        end = "2021",
        start = "2017"
    )
)

private data class ExperienceData(
    val company: String,
    val position: String,
    val summary: String,
    val end: String,
    val start: String,
)
