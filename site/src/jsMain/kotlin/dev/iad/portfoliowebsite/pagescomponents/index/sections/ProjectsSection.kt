package dev.iad.portfoliowebsite.pagescomponents.index.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.letterSpacing
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.minWidth
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.onMouseEnter
import com.varabyte.kobweb.compose.ui.modifiers.onMouseLeave
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.right
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.textTransform
import com.varabyte.kobweb.compose.ui.modifiers.top
import com.varabyte.kobweb.compose.ui.modifiers.transform
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.whiteSpace
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaInfo
import com.varabyte.kobweb.silk.components.icons.fa.FaXmark
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import dev.iad.portfoliowebsite.data.PROJECTS
import dev.iad.portfoliowebsite.models.Project
import dev.iad.portfoliowebsite.pagescomponents.index.components.SectionScaffold
import dev.iad.portfoliowebsite.toSitePalette
import dev.iad.portfoliowebsite.widgets.VerticalSpacer
import kotlinx.browser.window
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.CSSUnitValueTyped
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
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
                ProjectFilterButton(
                    name = projectType.name,
                    isActiveProject = projectType == displayedProjectsType,
                    onClick = {
                        displayedProjectsType = projectType
                    }
                )
            }
        }
        VerticalSpacer(value = 3.cssRem)
        SimpleGrid(
            numColumns = numColumns(base = 1, sm = 1, md = 2, lg = 2, xl = 3),
            modifier = ProjectsGridStyle.toModifier(),
        ) {
            PROJECTS
                .filter { displayedProjectsType == Project.Type.ALL || it.type == displayedProjectsType }
                .forEach { project ->
                    ProjectItem(project = project)
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
private fun ProjectFilterButton(
    name: String,
    isActiveProject: Boolean,
    onClick: () -> Unit,
) {
    Button(
        onClick = {
            it.preventDefault()
            onClick.invoke()
        },
        modifier = ProjectsFilterButtonStyle.toModifier()
            .then(
                other = if (isActiveProject) {
                    projectTypeSelectorHighlightModifier(color = ColorMode.current.toSitePalette().contentAlt)
                } else {
                    Modifier
                }
            ),
    ) {
        Text(value = name)
    }
}

@Composable
private fun ProjectItem(project: Project) {
    var infoVisible by remember { mutableStateOf(value = false) }

    Link(
        path = project.link,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB,
        modifier = ProjectLinkStyle
            .toModifier()
            .onMouseEnter(listener = {
                 infoVisible = true
            })
            .onMouseLeave(listener = {
                 infoVisible = false
            }),
    ) {
        Box(
            modifier = ProjectContentContainerStyle.toModifier()
                .then(other = if (infoVisible) Modifier.transform { rotateY(a = 180.deg) } else Modifier)
                .id(value = "inner"),
        ) {
            if (infoVisible) {
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
        if (infoVisible) {
            Button(
                modifier = BaseProjectInfoToggleButtonStyle.toModifier()
                    .then(
                        other = Modifier.size(size = 2.cssRem)
                            .backgroundColor(color = Colors.Transparent)
                    ),
                onClick = {
                    it.preventDefault()
                    infoVisible = false
                },
            ) {
                FaXmark(size = IconSize.LG)
            }
        } else {
            Button(
                modifier = BaseProjectInfoToggleButtonStyle.toModifier()
                    .then(other = ProjectInfoToggleButtonStyle.toModifier()),
                onClick = {
                    it.preventDefault()
                    infoVisible = true
                },
            ) {
                FaInfo(size = IconSize.XS)
            }
        }
    }
}

val ProjectsGridStyle = CssStyle {
    base {
        Modifier.fillMaxWidth()
    }

    Breakpoint.MD {
        Modifier.width(auto = auto)
    }
}

val ProjectLinkStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .height(size = 24.cssRem)
            .margin(bottom = 1.5.cssRem)
            .padding(leftRight = 1.5.cssRem)
            .color(color = Color.white)
            .backgroundColor(color = Color.transparent)
            .position(position = Position.Relative)
    }

    Breakpoint.MD {
        Modifier
            .padding(leftRight = 0.cssRem)
            .margin(right = 1.5.cssRem, bottom = 1.5.cssRem)
            .size(size = 24.cssRem)
    }
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

val BaseProjectInfoToggleButtonStyle = CssStyle {
    base {
        Modifier
            .position(position = Position.Absolute)
            .top(value = .75.cssRem)
            .right(value = 2.125.cssRem)
            .color(color = colorMode.toSitePalette().content)
            .minWidth(size = 0.cssRem)
            .padding(all = 0.cssRem)
    }
    Breakpoint.MD {
        Modifier.display(value = DisplayStyle.None)
    }
}

val ProjectInfoToggleButtonStyle = CssStyle {
    base {
        Modifier
            .border {
                style(lineStyle = LineStyle.Solid)
                color(color = colorMode.toSitePalette().content)
                width(width = .1.cssRem)
            }
            .borderRadius(r = 100.percent)
            .backgroundColor(color = colorMode.toSitePalette().contentAlt)
            .size(size = 1.5.cssRem)
    }
}

val ProjectInfoUntoggleButtonStyle = CssStyle {
    base {
        Modifier
            .border {
                style(lineStyle = LineStyle.Solid)
                color(color = colorMode.toSitePalette().content)
                width(width = .1.cssRem)
            }
            .borderRadius(r = 100.percent)
            .backgroundColor(color = colorMode.toSitePalette().contentAlt)
            .size(size = 1.5.cssRem)
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
