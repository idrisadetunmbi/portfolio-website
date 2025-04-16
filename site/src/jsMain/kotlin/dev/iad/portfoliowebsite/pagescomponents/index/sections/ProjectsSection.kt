package dev.iad.portfoliowebsite.pagescomponents.index.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.letterSpacing
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import dev.iad.portfoliowebsite.pagescomponents.index.components.SectionScaffold
import dev.iad.portfoliowebsite.toSitePalette
import dev.iad.portfoliowebsite.widgets.VerticalSpacer
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.Text

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
                    modifier = ProjectsFilterButtonStyle.toModifier()
                        .then(
                            if (displayedProjectsType == projectType) {
                                projectTypeSelectorHighlightModifier(color = ColorMode.current.toSitePalette().contentAlt)
                            } else {
                                Modifier
                            }
                        ),
                    onClick = {
                        displayedProjectsType = projectType
                    },
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
            projects
                .filter { displayedProjectsType == Project.Type.ALL || it.type == displayedProjectsType }
                .forEach { project ->
                    Link(
                        path = project.link,
                        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB,
                        modifier = ProjectLinkStyle.toModifier(),
                    ) {
                        Image(
                            src = project.image,
                            description = project.description,
                            modifier = Modifier
                                .fillMaxSize()
                                .objectFit(objectFit = ObjectFit.Contain),
                        )
                    }
                }
        }
    }
}

private data class Project(
    val image: String,
    val link: String,
    val type: Type,
    val description: String,
) {
    enum class Type {
        ALL, MOBILE, WEB
    }
}

private val projects = listOf(
    Project(
        image = "projects/trivago.png",
        link = "https://play.google.com/store/apps/details?id=com.trivago",
        type = Project.Type.MOBILE,
        description = "trivago: Compare hotel prices"
    ),
    Project(
        image = "projects/headspace-care.png",
        link = "https://play.google.com/store/apps/details?id=com.ginger",
        type = Project.Type.MOBILE,
        description = "Headspace Care: Mental health support -- available through organizations + health plans"
    ),
    Project(
        image = "projects/autochek.png",
        link = "https://play.google.com/store/apps/details?id=com.autochek.buysalefixcars",
        type = Project.Type.MOBILE,
        description = "Autochek: Enjoy 360 degree solutions at your fingertips"
    ),
    Project(
        image = "projects/aventine-alt.png",
        link = "https://aventine.org",
        type = Project.Type.WEB,
        description = "Aventine: THE WORLD AS YOU'LL KNOW IT"
    ),
    Project(
        image = "projects/mtc.png",
        link = "https://www.intentionalfutures.com/posts/mastery-transcript",
        type = Project.Type.WEB,
        description = "Mastery Transcript"
    ),
)

val ProjectLinkStyle = CssStyle.base {
    Modifier
        .size(size = 25.cssRem)
        .margin(right = 1.5.cssRem, bottom = 1.5.cssRem)
        .color(color = Color.white)
}

val ProjectsFilterButtonStyle = CssStyle {
    base {
        Modifier
            .color(colorMode.toSitePalette().contentAlt)
            .fontSize(value = .825.cssRem)
            .letterSpacing(value = .125.cssRem)
            .backgroundColor(color = Color.transparent)
            .borderRadius(0.percent)
            .margin { right(.5.cssRem) }
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
