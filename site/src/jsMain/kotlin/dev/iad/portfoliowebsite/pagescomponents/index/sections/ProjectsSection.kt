package dev.iad.portfoliowebsite.pagescomponents.index.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.letterSpacing
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.onMouseEnter
import com.varabyte.kobweb.compose.ui.modifiers.onMouseLeave
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.whiteSpace
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import dev.iad.portfoliowebsite.pagescomponents.index.components.SectionScaffold
import dev.iad.portfoliowebsite.toSitePalette
import dev.iad.portfoliowebsite.widgets.VerticalSpacer
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.CSSUnitValueTyped
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.Text

private val PROJECTS = listOf(
    Project(
        image = "projects/trivago.png",
        link = "https://play.google.com/store/apps/details?id=com.trivago",
        type = Project.Type.MOBILE,
        headline = "trivago: Compare hotel prices",
        summary = "In addition to working on the core product features, I assumed responsibility of developing long-term, " +
                "member-retention features including the price drop notifications system (registration, notifications, " +
                "list management, and live prices) and the favorites lists feature increasing member acquisition and engagement.\n\n" +
                "On the tech-improvement side, I led and managed the introduction of the Jetpack Compose UI framework " +
                "to the trivago Android app resulting in improved developer experience and faster development iterations.",
    ),
    Project(
        image = "projects/headspace-care.png",
        link = "https://play.google.com/store/apps/details?id=com.ginger",
        type = Project.Type.MOBILE,
        headline = "Headspace Care: Mental health support -- available through organizations + health plans",
        summary = "My experience working on the Headspace Care app included handling major projects including porting the " +
                "Headspace Care Flutter Mobile app to a web app. This resulted in increased user base and retention " +
                "through providing an extra platform for product access. \n\n" +
                "I also worked in a three-person engineering sub-team to redevelop the content system, a large part of " +
                "the app resulting, in a more scalable, higher quality of the system and in effect, a better user experience."
    ),
    Project(
        image = "projects/autochek.png",
        link = "https://play.google.com/store/apps/details?id=com.autochek.buysalefixcars",
        type = Project.Type.MOBILE,
        headline = "Autochek: Enjoy 360 degree solutions at your fingertips",
        summary = "I joined the Autochek startup team to develop the first release of the app handling major product features " +
                "including ad placements/uploads, financing application process, purchase payments, user authentication, etc. " +
                "The development featured using the Google-recommended MVVM architecture for developing Android apps, Kotlin and " +
                "Kotlin Coroutines (for async operations).\n\n" +
                "It is one of the projects I adopted Jetpack Compose in at the early stages " +
                "of the framework based on my experience and understanding of declarative UI frameworks and the benefits they " +
                "bring to frontend engineering. " +
                "The release garnered up to 15,000 downloads with minimal impediments to user experience reported.",
    ),
    Project(
        image = "projects/aventine-alt.png",
        link = "https://aventine.org",
        type = Project.Type.WEB,
        headline = "Aventine: THE WORLD AS YOU'LL KNOW IT",
        summary = "I worked as a solo engineer with a product designer to develop this highly-custom blogging platform built " +
                "using Netlify CMS, ReactJS and TailwindCSS (for a top research/journalism institute). The platform featured " +
                "heavy animations on the frontend using Framer Motion and some AST manipulations to develop a glossary " +
                "database feature unique to it.",
    ),
    Project(
        image = "projects/mtc.png",
        link = "https://www.intentionalfutures.com/posts/mastery-transcript",
        type = Project.Type.WEB,
        headline = "Mastery Transcript",
        summary = "Built with Firebase Cloud storage and ReactJS, the project started as a prototype (through rapid iterations) " +
                "and developed till first major version of a modern transcript system for a network of high-schools in the US. It also " +
                "included highly technical, custom SVG drawings to provide an immediate visualization summary of a " +
                "student's credit distribution.",
    ),
)

private data class Project(
    val image: String,
    val link: String,
    val type: Type,
    val headline: String,
    val summary: String,
) {
    enum class Type {
        ALL, MOBILE, WEB
    }
}

@Composable
internal fun ProjectsSection() {
    var displayedProjectsType: Project.Type by remember { mutableStateOf(value = Project.Type.ALL) }
    SectionScaffold(
        title = "projects",
        subtitle = "Projects I've worked on",
    ) {
        Row {
            Project.Type.entries.forEach { projectType ->
                Button(
                    onClick = {
                        displayedProjectsType = projectType
                    },
                    modifier = ProjectsFilterButtonStyle.toModifier()
                        .then(
                            other = if (displayedProjectsType == projectType) {
                                projectTypeSelectorHighlightModifier(color = ColorMode.current.toSitePalette().contentAlt)
                            } else {
                                Modifier
                            }
                        ),
                ) {
                    Text(value = projectType.name)
                }
            }
        }
        VerticalSpacer(value = 3.cssRem)
        SimpleGrid(
            numColumns = numColumns(base = 3),
            modifier = Modifier.maxWidth(size = 82.5.cssRem),
        ) {
            PROJECTS
                .filter { displayedProjectsType == Project.Type.ALL || it.type == displayedProjectsType }
                .forEach { project ->
                    ProjectItem(project = project)
                }
        }
    }
}

@Composable
private fun ProjectItem(project: Project) {
    var hovered by remember { mutableStateOf(value = false) }

    Link(
        path = project.link,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB,
        modifier = ProjectLinkStyle
            .toModifier()
            .onMouseEnter(listener = {
                hovered = true
            })
            .onMouseLeave(listener = {
                hovered = false
            }),
    ) {
        Box(
            modifier = ProjectContentContainerStyle.toModifier()
                .then(other = if (hovered) Modifier.transform { rotateY(a = 180.deg) } else Modifier)
                .id(value = "inner"),
        ) {
            if (hovered) {
                Box(
                    modifier = ProjectContentStyle
                        .toModifier()
                        .transform { rotateY(a = 180.deg) },
                ) {
                    SpanText(
                        text = project.summary,
                        modifier = Modifier
                            .textAlign(textAlign = TextAlign.Center)
                            .fontSize(value = 0.9375.cssRem)
                            .lineHeight(value = 1.5.cssRem)
                            .align(alignment = Alignment.Center)
                            .whiteSpace(whiteSpace = WhiteSpace.PreLine)
                            .padding(all = 1.cssRem),
                    )
                }
            } else {
                Box(
                    modifier = ProjectContentStyle
                        .toModifier()
                        .backgroundColor(color = Color.white),
                ) {
                    Image(
                        src = project.image,
                        description = project.headline,
                        modifier = Modifier
                            .size(size = 100.percent)
                            .objectFit(objectFit = ObjectFit.Contain),
                    )
                }
            }

        }
    }
}

val ProjectLinkStyle = CssStyle.base {
    Modifier
        .size(size = 25.cssRem)
        .margin(right = 1.5.cssRem, bottom = 1.5.cssRem)
        .color(color = Color.white)
        .backgroundColor(color = Color.transparent)
}

val ProjectContentContainerStyle = CssStyle {
    base {
        Modifier
            .fillMaxSize()
            .position(position = Position.Relative)
            .transition(
                transition = Transition.of(
                    property = "transform",
                    duration = CSSUnitValueTyped(value = 0.4F, unit = CSSUnit.s)
                ),
            )
    }
}

val ProjectContentStyle = CssStyle {
    base {
        Modifier
            .position(position = Position.Absolute)
            .size(size = 100.percent)
    }
}

val ProjectsFilterButtonStyle = CssStyle {
    base {
        Modifier
            .color(color = colorMode.toSitePalette().contentAlt)
            .fontSize(value = .825.cssRem)
            .letterSpacing(value = .125.cssRem)
            .backgroundColor(color = Color.transparent)
            .borderRadius(r = 0.percent)
            .margin { right(value = .5.cssRem) }
    }
    hover {
        projectTypeSelectorHighlightModifier(color = colorMode.toSitePalette().contentAlt)
    }
}


private fun projectTypeSelectorHighlightModifier(color: CSSColorValue): Modifier = Modifier.border {
    color(color = color)
    style(lineStyle = LineStyle.Solid)
    width(top = 0.cssRem, bottom = .125.cssRem, leftRight = 0.cssRem)
}
